import React from 'react'
import CreaPartita from "./CreaPartita";
import AccediPartita from "./AccediPartita";
import { useState } from 'react';

const Home = () => {
    const [opzionePartita, setOpzionePartita] = useState("")

    const opzioniPartita = ["Crea Partita", "Accedi a Partita"]


  return (
    <div>
        <h1>Monopoly</h1>
        {/* <div className="">
            {opzioniPartita.map(( el ) => 
                <button onClick={() => setOpzionePartita(el)}>{el}</button>
            )}
        </div>

        {opzionePartita === opzioniPartita[1]  ? (
            <AccediPartita />
        ) :
        <CreaPartita />} */}
        <CreaPartita />
        <hr />

        <button>Accedi a Partita Esistente</button>
    </div>
  )
}

export default Home