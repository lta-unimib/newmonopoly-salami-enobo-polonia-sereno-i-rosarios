import {CompatClient, Stomp} from "@stomp/stompjs";
import websocket from "websocket"
import IConfigurazione from "../interfaces/IConfigurazione";
import { Observer } from "./Observer";
import IPartita from "../interfaces/IPartita";
import IGiocatore from "../interfaces/IGiocatore";

Object.assign(global, {WebSocket: websocket.w3cwebsocket})

const URL = "http://" + (process.env.NODE_ENV === "development" ? "localhost:8080" : window.location.host);
const WS_URL = "ws://" + (process.env.NODE_ENV === "development" ? "localhost:8080" : window.location.host);

export default class StompController {

    static client: CompatClient;
    static idPartita: string;

    static async creaPartita(configuration: IConfigurazione): Promise<String> {
        try {
            const res = await fetch(URL + "/partita", {
                method: "POST",
                body: JSON.stringify(configuration),
                headers: {
                    'Content-Type': 'application/json',
                },
            });
    
            if (!res.ok) {
                const errorMessage = await res.text();
                throw new Error(`Errore server: ${errorMessage}`);
            }

            if (this.client) {
                this.client.send("/app/partita/crea", {}, JSON.stringify({
                    partitaCreata: true, 
                }));
            }
            
            return await res.text();
        } catch (error: any) {
            console.error("Errore durante la creazione della partita:", error.message);
            throw new Error("Impossibile creare una partita. Dettagli: " + error.message);
        }
    }

    static onPartitaCreata(onPartitaCreataCallback: (partitaCreata: boolean) => void) {
        const client = Stomp.client(WS_URL + "/stomp");
        this.client = client;
        
        client.connect({}, () => {
            // Sottoscrivi il client al topic della lobby
            client.subscribe(`/topic/partita/creata`, (res) => {
                const isCreata = JSON.parse(res.body);

                onPartitaCreataCallback(isCreata);  // Invoca la funzione per aggiornare la lista
            });
            client.send("/app/partita/creata", {}, JSON.stringify({ action: "start" }));
        }, (err: any) => {
            console.error("Errore nella connessione WebSocket:", err);
        });
    }

    static accediPartita(nickname: string) {
        const client = Stomp.client(WS_URL + "/stomp");
        this.client = client;
        client.connect({}, () => {
            client.subscribe("/topic/partita/" , (res) =>
                Observer.notify(JSON.parse(res.body) as IPartita)
            )
            console.log("qui", {nickname: nickname});
            client.send("/app/partita/entra", {},
                JSON.stringify({nickname: nickname})
            )
        })
    }

    static entraLobby(nickname: string, onLobbyUpdated: (giocatori: string[]) => void) {
        const client = Stomp.client(WS_URL + "/stomp");
        this.client = client;
    
        client.connect({}, () => {
            // Sottoscrivi il client al topic della lobby
            client.subscribe(`/topic/lobby`, (res) => {
                const giocatori = JSON.parse(res.body);

                onLobbyUpdated(giocatori);  // Invoca la funzione per aggiornare la lista
            });
            client.send("/app/lobby/entra", {}, JSON.stringify({
                nickname: nickname
            }));
        }, (err: any) => {
            console.error("Errore nella connessione WebSocket:", err);
        });
    }

    static esciLobby(nickname: string, onLobbyUpdated: (giocatori: any[]) => void) {
        const client = Stomp.client(WS_URL + "/stomp");
        this.client = client;
    
        client.connect({}, () => {
            // Sottoscrivi il client al topic della lobby
            client.subscribe(`/topic/lobby`, (res) => {
                const giocatori = JSON.parse(res.body);
                onLobbyUpdated(giocatori);  // Invoca la funzione per aggiornare la lista
            });
            client.send("/app/lobby/esci", {}, JSON.stringify({
                nickname: nickname
            }));
        }, (err: any) => {
            console.error("Errore nella connessione WebSocket:", err);
        });
    }

    static svuotaLobby(onLobbyUpdated: (giocatori: any[]) => void) {
        const client = Stomp.client(WS_URL + "/stomp");
        this.client = client;
    
        client.connect({}, () => {
            console.log("Connesso al WebSocket per la lobby!");
    
            // Sottoscrivi il client al topic della lobby
            client.subscribe(`/topic/lobby`, (res) => {
                const giocatori = JSON.parse(res.body);
                onLobbyUpdated(giocatori);  // Invoca la funzione per aggiornare la lista
            });
    
            // Invia un messaggio per aggiungere il giocatore alla lobby
            console.log("Invio il messaggio per svuotare la lobby");
            client.send("/app/lobby/svuota", {}, JSON.stringify({
            }));
        }, (err: any) => {
            console.error("Errore nella connessione WebSocket:", err);
        });

    }
}
