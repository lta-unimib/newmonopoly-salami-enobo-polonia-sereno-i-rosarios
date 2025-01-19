import React, { useState } from "react";
import { useNavigate } from 'react-router-dom'; // Per spostarsi alla lobby
import { Client } from '@stomp/stompjs';

const AccediPartita: React.FC = () => {
  const [nomeGiocatore, setNomeGiocatore] = useState("");
  const [idPartita, setIdPartita] = useState("");
  const navigate = useNavigate();

  const handleAccedi = () => {
    if (!nomeGiocatore || !idPartita) {
      alert("Inserisci nome e ID partita");
      return;
    }

    // Connessione al WebSocket
    const client = new Client({
      brokerURL: "ws://localhost:8080/ws", // URL WebSocket
      onConnect: () => {
        client.publish({
          destination: `/app/partita/${idPartita}/join`,
          body: JSON.stringify({ nome: nomeGiocatore }),
        });

        // Naviga alla lobby
        navigate(`/lobby/${idPartita}`);
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
        <button onClick={handleAccedi}>Accedi</button>
      </div>
  );
};

export default AccediPartita;
