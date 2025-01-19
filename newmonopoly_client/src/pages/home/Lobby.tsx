import React, { useEffect, useState } from "react";
import { Client } from '@stomp/stompjs';
import { useParams } from 'react-router-dom';

type Giocatore = {
    id: string;
    nome: string;
};

const Lobby: React.FC = () => {
    const { idPartita } = useParams(); // Ottieni ID partita dall'URL
    const [giocatori, setGiocatori] = useState<Giocatore[]>([]);
    const [creatore, setCreatore] = useState<string | null>(null);

    useEffect(() => {
        const client = new Client({
            brokerURL: "ws://localhost:8080/ws", // URL WebSocket
            onConnect: () => {
                // Sottoscrizione alla lista giocatori
                client.subscribe(`/topic/partita/${idPartita}/giocatori`, (message) => {
                    const { giocatori, creatore } = JSON.parse(message.body);
                    setGiocatori(giocatori);
                    setCreatore(creatore);
                });
            },
        });

        client.activate();

        return () => {
            client.deactivate(); // Pulizia quando il componente si smonta
        };
    }, [idPartita]);

    const handleAvviaPartita = () => {
        // Notifica il server per iniziare la partita
        const client = new Client({
            brokerURL: "ws://localhost:8080/ws",
            onConnect: () => {
                client.publish({
                    destination: `/app/partita/${idPartita}/start`,
                });
            },
        });

        client.activate();
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

            {creatore === "currentUserId" && ( // Mostra il pulsante solo al creatore
                <button onClick={handleAvviaPartita}>Avvia Partita</button>
            )}
        </div>
    );
};

export default Lobby;