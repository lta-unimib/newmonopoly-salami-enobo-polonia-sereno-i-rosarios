import React, { useState }  from 'react'
import CreaPartita from "./CreaPartita";

import { useNavigate } from "react-router-dom";

const Home = () => {
    const [opzionePartita, setOpzionePartita] = useState("")

    const opzioniPartita = ["Crea Partita", "Accedi a Partita"]
    
    const [nickname, setNickname] = useState("");

    // Hook per navigare tra le pagine
    const navigate = useNavigate();

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        // Stampo i dati per il debug
        console.log({
            nickname,
        });
    };

  return (
    <div>
        <h1>Monopoly</h1>
        <form>
            <label>
                Inserisci il tuo nickname:
                <input
                    type="text"
                    required
                    value={nickname}
                    onChange={(e) => setNickname(e.target.value)}
                />
            </label>
        </form>
        <hr />
        
        <div className="">
            {opzioniPartita.map(( el ) => 
                <button onClick={() => setOpzionePartita(el)}>{el}</button>
            )}
        </div>

        {opzionePartita === opzioniPartita[0] &&
        <CreaPartita nickname={nickname} navigate={navigate} /> }
    </div>
  )
}

export default Home