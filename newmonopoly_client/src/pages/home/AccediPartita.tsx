import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { Client } from "@stomp/stompjs";

const AccediPartita: React.FC = () => {
    const [nomeGiocatore, setNomeGiocatore] = useState("");
    const [idPartita, setIdPartita] = useState("");
    const [isConnecting, setIsConnecting] = useState(false);
    const navigate = useNavigate();
    return (
        <div>
            <h1>Accedi a una Partita</h1>
            
        </div>
    );
};

export default AccediPartita;