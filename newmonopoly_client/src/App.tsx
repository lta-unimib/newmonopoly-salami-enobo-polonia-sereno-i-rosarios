import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import CreaPartita from "./pages/home/CreaPartita";
import Lobby from "./pages/home/Lobby";
const App = () => {
    return (
        <BrowserRouter>
            <Routes>
                {/* Rota iniziale */}
                <Route path="/" element={<CreaPartita />} />
                {/* Rota per la lobby */}
                <Route path="/lobby" element={<Lobby />} />
            </Routes>
        </BrowserRouter>
    );
};
export default App;