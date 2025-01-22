import {CompatClient, Stomp} from "@stomp/stompjs";
import websocket from "websocket"
import IConfigurazione from "../interfaces/IConfigurazione";
import { Observer } from "./Observer";
import IPartita from "../interfaces/IPartita";

Object.assign(global, {WebSocket: websocket.w3cwebsocket})

const URL = "http://" + (process.env.NODE_ENV === "development" ? "localhost:8080" : window.location.host);
const WS_URL = "ws://" + (process.env.NODE_ENV === "development" ? "localhost:8080" : window.location.host);

export default class StompController {

    static client: CompatClient;
    static idPartita: string;

    static async creaPartita(configuration: IConfigurazione): Promise<IPartita> {
        try {
            const res = await fetch(URL + "/partita", {
                method: "POST",
                body: JSON.stringify(configuration),
                headers: {
                    'Content-Type': 'application/json',
                },
            });
    
            // Log dettagliato della risposta
            console.log("Stato HTTP:", res.status);
            console.log("Contenuto della risposta:", await res.text());
    
            if (res.status === 200) {
                return res.json(); // Parse JSON solo se il codice è 200
            }
    
            throw new Error("Impossibile creare una partita"); // Se il codice non è 200, lancia un errore
        } catch (error) {
            console.error("Errore durante la creazione della partita:", error);
            throw error;
        }
    }

    static accediPartita(nickname: string, isImprenditore: boolean) {
        const client = Stomp.client(WS_URL + "/stomp");
        this.client = client;
        client.connect({}, () => {
            client.subscribe("/topic/partita/" , (res) =>
                Observer.notify(JSON.parse(res.body) as IPartita)
            )
            console.log("qui", isImprenditore);
            client.send("/app/partita/entra", {},
                JSON.stringify({nickname: nickname, isImprenditore: isImprenditore})
            )
        })
    }
}
