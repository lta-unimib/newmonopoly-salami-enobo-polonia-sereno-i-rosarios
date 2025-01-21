import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import CreaPartita from "./CreaPartita";
// import Tabellone from "../../components/Tabellone";
// import caselleData from "../../data/caselle.json";
// import IGiocatore from "../../interfaces/IGiocatore";

const Home = () => {
  const [opzionePartita, setOpzionePartita] = useState("");
  const [nickname, setNickname] = useState("");
  
  const opzioniPartita = ["Crea Partita", "Accedi a Partita"];
  const navigate = useNavigate();

  const handleOptionSubmit = (el: string) => {
    if (nickname !== '') {
      setOpzionePartita(el);
    }

    if (el === "Accedi a Partita" && nickname !== '') {
      navigate("/lobby", {
        state: { nickname, admin: false }, // Passa il nickname alla Lobby
      });
    }
  };

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    // console.log({ nickname });
  };

  // Test
  // const giocatore: IGiocatore = {
  //   nome: nickname,
  //   conto: new Map([[1, { valore: 500, quantita: 1 }]]),
  //   casellaCorrente: { nome: "Partenza", id: 1 },
  //   proprietaPossedute: [
  //     { nome: "Proprietà 1", id: 2, proprietario: nickname, costoBase: 100, ipoteca: 50, affitto: 10 },
  //     { nome: "Proprietà 2", id: 3, proprietario: nickname, costoBase: 200, ipoteca: 100, affitto: 20 },
  //   ],
  //   puntiFedelta: 10,
  // };

  // const caselleConId = caselleData.map((casella, index) => ({
  //   id: index,
  //   ...casella,
  // }));

  return (
    <div className="p-6 max-w-4xl mx-auto">
      <h1 className="text-4xl font-bold text-center mb-6">NewMonopoly</h1>
      
      {/* Input Form */}
      <form onSubmit={handleSubmit} className="mb-6">
        <label className="block text-lg font-medium mb-2">
          Inserisci il tuo nickname:
          <input
            type="text"
            value={nickname}
            onChange={(e) => setNickname(e.target.value)}
            className="block w-full mt-2 px-4 py-2 border border-gray-300 rounded-lg shadow-sm focus:ring-blue-500 focus:border-blue-500"
            placeholder="Nickname"
            required
          />
        </label>
        <hr className="my-6" />
      
        {/* Opzioni Partita */}
        <div className="flex justify-center gap-4 mb-6">
          {opzioniPartita.map((el) => (
            <button
              key={el}
              onClick={() => handleOptionSubmit(el)}
              className={`px-6 py-2 rounded-lg shadow transition ${
                opzionePartita === el
                  ? "bg-blue-600 text-white"
                  : "bg-gray-200 hover:bg-gray-300"
              }`}
            >
              {el}
            </button>
          ))}
        </div>
      </form>

      {/* Mostra componenti */}
      {opzionePartita === opzioniPartita[0] && (
        <CreaPartita nickname={nickname} navigate={navigate} admin={true} />
      )}
      {/* <Tabellone caselle={caselleConId} giocatori={[giocatore]} /> */}
    </div>
  );
};

export default Home;
