import React, { useEffect, useState } from "react";
import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Home from "./pages/home/Home";
import Lobby from "./pages/home/Lobby";
import AccediPartita from "./pages/home/AccediPartita"; // Nuova pagina per accedere alla partita

const App = () => {
    // Stato globale per controllare se una partita è stata creata
    const [partitaCreata, setPartitaCreata] = useState(false);

    // Effetto per caricare lo stato della partita dalla memoria locale (localStorage)
    useEffect(() => {
        const partitaSalvata = localStorage.getItem("partitaCreata");
        if (partitaSalvata === "true") {
            setPartitaCreata(true);
        }
    }, []);

    return (
        <BrowserRouter>
            <Routes>
                {/* Rotta iniziale condizionale */}
                <Route
                    path="/"
                    element={
                        partitaCreata ? (
                            <Navigate to="/accedi-partita" /> // Redirezione automatica se la partita è già creata
                        ) : (
                            <Home />
                        )
                    }
                />
                {/* Rotta per accedere alla partita */}
                <Route path="/accedi-partita" element={<AccediPartita />} />

                {/* Rotta per la lobby */}
                <Route path="/lobby" element={<Lobby />} />
            </Routes>
        </BrowserRouter>
    );
};

export default App;