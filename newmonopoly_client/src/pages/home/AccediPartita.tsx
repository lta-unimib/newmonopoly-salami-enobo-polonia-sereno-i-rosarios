import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { Client } from "@stomp/stompjs";

const AccediPartita: React.FC = () => {
    const [nomeGiocatore, setNomeGiocatore] = useState("");
    const [idPartita, setIdPartita] = useState("");
    const [isConnecting, setIsConnecting] = useState(false);
    const navigate = useNavigate();

    // Recupera l'ID della partita da localStorage all'avvio
    useEffect(() => {
        const partitaSalvata = localStorage.getItem("idPartita");
        if (partitaSalvata) {
            setIdPartita(partitaSalvata); // Precompila il campo ID partita
        }
    }, []);

    const handleAccedi = () => {
        if (!nomeGiocatore.trim() || !idPartita.trim()) {
            alert("Inserisci nome e ID partita validi");
            return;
        }

        setIsConnecting(true);

        const client = new Client({
            brokerURL: "ws://localhost:8080/ws",
            onConnect: () => {
                client.publish({
                    destination: `/app/partita/${idPartita}/join`,
                    body: JSON.stringify({ nome: nomeGiocatore }),
                });

                // Naviga alla lobby
                navigate(`/lobby/${idPartita}`);
            },
            onStompError: (frame) => {
                console.error("Errore STOMP: ", frame.headers["message"]);
                alert("Errore durante la connessione alla partita. Riprova.");
                setIsConnecting(false);
            },
            onWebSocketClose: () => {
                console.warn("Connessione WebSocket chiusa.");
                setIsConnecting(false);
            },
        });

        client.activate();
    };

    return (
        <div>
            <h1>Accedi a una Partita</h1>
            <input
                type="text"
                placeholder="Inserisci il tuo nome"
                value={nomeGiocatore}
                onChange={(e) => setNomeGiocatore(e.target.value)}
            />
            <input
                type="text"
                placeholder="ID Partita"
                value={idPartita}
                onChange={(e) => setIdPartita(e.target.value)}
            />
            <button onClick={handleAccedi} disabled={isConnecting}>
                {isConnecting ? "Connessione in corso..." : "Accedi"}
            </button>
        </div>
    );
};

export default AccediPartita;