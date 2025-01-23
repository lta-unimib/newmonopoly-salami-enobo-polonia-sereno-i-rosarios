import React, { useEffect, useState } from 'react';
import IPartita from '../interfaces/IPartita'; 
import IGiocatore from "../interfaces/IGiocatore";

// Definiamo i tipi di props che il componente accetta
interface Props {
  partita: IPartita; 
  nickname: string;
}

const Optionsbar: React.FC<Props> = ({ partita, nickname }) => {
    const [giocatore, setGiocatore] = useState<IGiocatore | undefined>(undefined);
    const [showProprieta, setShowProprieta] = useState<boolean>(false);

    useEffect(() => {
      const giocatoreSelezionato = partita.giocatori.find((g) => g.nome === nickname);
      if (giocatoreSelezionato) {
        setGiocatore(giocatoreSelezionato);
      }
    }, [nickname, partita.giocatori]);

    console.log(partita.giocatori)

    const toggleProprietaVisibility = () => {
      setShowProprieta(!showProprieta); // Toggle della visibilità delle proprietà
    };

  return (
    <div className="bg-white p-6 rounded-lg shadow-md max-w-xs fixed">
      <h2 className="text-2xl font-semibold text-blue-600 mb-4">Menu Giocatore</h2>

      {/* Info Partita */}
      <div className="mb-4">
        <p className="text-lg text-gray-700">Numero di giocatori: {partita.giocatori.length}</p>
        <p className="text-lg text-gray-700">Numero di caselle: {partita.tabellone.caselle.length}</p>
      </div>

      <ul className="space-y-2">
        <button className="text-lg text-blue-500 cursor-pointer hover:text-blue-700" onClick={toggleProprietaVisibility}>Visualizza Proprietà</button>
        <ul className="list-disc list-inside ml-4">
            {giocatore && showProprieta && giocatore.proprietaPossedute.length > 0 ? (
                giocatore.proprietaPossedute.map((proprieta, idx) => (
                    <li key={idx}>
                        <strong>{proprieta.nome}</strong>
                        <br />
                        Costo: {proprieta.costoBase}
                        <br />
                        Ipoteca: {proprieta.ipoteca}
                        <br />
                        Affitto: {proprieta.affitto}
                    </li>
                ))
            ) : (
                <li>Nessuna proprietà</li>
            )}
        </ul>
        <li className="text-lg text-blue-500 cursor-pointer hover:text-blue-700">Gestisci Edifici</li>
        <li className="text-lg text-blue-500 cursor-pointer hover:text-blue-700">Commercio</li>
        <li className="text-lg text-blue-500 cursor-pointer hover:text-blue-700">Ipoteca</li>
      </ul>
    </div>
  );
};

export default Optionsbar;
