import {CompatClient, Stomp} from "@stomp/stompjs";
import websocket from "websocket"
import IConfigurazione from "../interfaces/IConfigurazione";

Object.assign(global, {WebSocket: websocket.w3cwebsocket})

const URL = "http://" + (process.env.NODE_ENV === "development" ? "localhost:8080" : window.location.host);

export default class StompController {

    static client: CompatClient;
    static idPartita: string;

    static creaPartita(configuration: IConfigurazione): Promise<string> {
        return fetch(URL + "/partita", {
            method: "POST",
            body: JSON.stringify(configuration),
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then((res) => {
                if (res.status === 200) {
                    return res.text()
                }
                throw new Error("Impossibile creare una partita")
            })
    }
}
