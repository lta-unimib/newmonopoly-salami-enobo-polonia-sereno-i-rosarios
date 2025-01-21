import React, { useEffect, useState } from "react";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Home from "./pages/home/Home";
import Lobby from "./pages/home/Lobby";
import PartitaRouter from "./pages/partita/PartitaRouter";

import './index.css'

const App = () => {
    // Stato globale per controllare se una partita è stata creata
    const [partitaCreata, setPartitaCreata] = useState(false);

    // Stato per memorizzare i dati del giocatore (nickname, admin, etc.)
    const [giocatore, setGiocatore] = useState<{ nickname: string; admin: boolean; isImprenditore: boolean } | null>(null);

    const setGiocatoreHandler = (nick: string, isImprenditore: boolean) => {
        setGiocatore({ nickname: nick, admin: true, isImprenditore });
      };

    // Effetto per caricare lo stato della partita dalla memoria locale (localStorage)
    useEffect(() => {
        const partitaSalvata = localStorage.getItem("partitaCreata");
        const giocatoreSalvato = localStorage.getItem("giocatore");

        if (partitaSalvata === "true") {
            setPartitaCreata(true);
        }

        if (giocatoreSalvato) {
            setGiocatore(JSON.parse(giocatoreSalvato));
        }
    }, []);

    // Salvataggio dello stato della partita e del giocatore in localStorage
    useEffect(() => {
        if (partitaCreata) {
            localStorage.setItem("partitaCreata", "true");
        }
        if (giocatore) {
            localStorage.setItem("giocatore", JSON.stringify(giocatore));
        }
    }, [partitaCreata, giocatore]);

    return (
        <BrowserRouter>
            <Routes>
                {/* Rotta iniziale condizionale */}
                <Route
                    path="/"
                    element={
                        partitaCreata ? (
                            <Navigate to="/partita" /> // Redirezione automatica se la partita è già creata
                        ) : (
                            <Home />
                        )
                    }
                />
                
                <Route path="/partita" element={<PartitaRouter />} />

                {/* Rotta per la lobby */}
                <Route path="/lobby" element={<Lobby setGiocatore={setGiocatoreHandler} />} />
            </Routes>
        </BrowserRouter>
    );
};

export default App;