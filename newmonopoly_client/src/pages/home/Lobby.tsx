import React, { useEffect, useState } from "react";
import { Client } from '@stomp/stompjs';
import { useParams } from 'react-router-dom';

type Giocatore = {
    id: string;
    nome: string;
};

const Lobby: React.FC = () => {
    const { idPartita } = useParams<{ idPartita: string }>(); // Ottieni ID partita dall'URL
    const [giocatori, setGiocatori] = useState<Giocatore[]>([]);
    const [creatore, setCreatore] = useState<string | null>(null);
    const [currentUserId, setCurrentUserId] = useState<string>("1234"); // Imposta l'utente corrente (simulazione)
    const [client, setClient] = useState<Client | null>(null); // Gestisci un unico client condiviso

    useEffect(() => {
        const wsClient = new Client({
            brokerURL: "ws://localhost:8080/ws", // URL WebSocket
            onConnect: () => {
                console.log("Connesso al WebSocket!");

                // Sottoscrizione per ricevere la lista dei giocatori
                wsClient.subscribe(`/topic/partita/${idPartita}/giocatori`, (message) => {
                    const { giocatori, creatore } = JSON.parse(message.body);
                    setGiocatori(giocatori);
                    setCreatore(creatore);
                });
            },
            onStompError: (frame) => {
                console.error("Errore STOMP:", frame);
            },
            onWebSocketError: (error) => {
                console.error("Errore WebSocket:", error);
            },
        });

        wsClient.activate();
        setClient(wsClient); // Salva il client condiviso nello stato

        // Pulizia: disattiva il WebSocket quando il componente si smonta
        return () => {
            if (wsClient) wsClient.deactivate();
        };
    }, [idPartita]);

    const handleAvviaPartita = () => {
        if (!client) return; // Prevenire errori se il client non è pronto

        try {
            // Pubblica un messaggio per avviare la partita
            client.publish({
                destination: `/app/partita/${idPartita}/start`,
            });
            console.log("Partita avviata!");
        } catch (error) {
            console.error("Errore durante l'avvio della partita:", error);
        }
    };

    return (
        <div>
            <h1>Lobby</h1>
            <h2>Giocatori:</h2>
            <ul>
                {giocatori.map((g) => (
                    <li key={g.id}>{g.nome}</li>
                ))}
            </ul>

            {/* Mostra il pulsante solo se l'utente corrente è il creatore */}
            {creatore === currentUserId && (
                <button onClick={handleAvviaPartita}>Avvia Partita</button>
            )}
        </div>
    );
};

export default Lobby;