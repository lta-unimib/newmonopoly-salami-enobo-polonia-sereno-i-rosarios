import React from "react";
import { ICasella } from "../interfaces/caselle/ICasella";
import { Colore } from '../interfaces/caselle/ICasellaStrada'
import IGiocatore from "../interfaces/IGiocatore";
import { Casella } from "../components/caselle/Casella";

// Definizione delle props per il componente Tabellone
interface TabelloneProps {
    caselle: ICasella[];
    giocatori: IGiocatore[];
}

const Tabellone: React.FC<TabelloneProps> = ({ caselle, giocatori }) => {

    // Funzione per renderizzare una sezione del tabellone
    const renderCaselle = (caselleSubset: ICasella[]) => (
        <>
            {caselleSubset.map((casella, index) => (
                <div
                    key={index}
                    className="flex justify-center items-center border-2 border-gray-300 bg-gray-100 w-24 h-16 shrink-0"
                >
                    <Casella {...casella} />
                </div>
            ))}
        </>
    );

    const calcolaContoTotale = (conto: Map<number, { valore: number, quantita: number }>) => {
        return Array.from(conto.values()).reduce((totale, entry) => totale + entry.valore * entry.quantita, 0);
      };

    return (
        <div className="">
            <h2 className="text-4xl text-center font-bold mb-6">NewMonopoly</h2>
            <div className="flex justify-center text-sm">
                <div className="relative w-fill ">
                    {/* Top row (11 caselle) */}
                    <div className="flex justify-between">
                        {renderCaselle(caselle.slice(0, 11))}
                    </div>

                    {/* Middle section */}
                    <div className="flex justify-between">
                        {/* Left column (9 caselle) */}
                        <div className="flex flex-col justify-between">
                            {renderCaselle(caselle.slice(31).reverse())}
                        </div>
                        {/* Right column (10 caselle) */}
                        <div className="flex flex-col justify-between">
                            {renderCaselle(caselle.slice(11, 20))}
                        </div>
                    </div>

                    {/* Bottom row (10 caselle) */}
                    <div className="flex justify-between">
                        {renderCaselle(caselle.slice(20, 31).reverse())}
                    </div>
                </div>
            </div>

            {/* Giocatori */}
            <div className="mt-8">
                <h3 className="text-xl font-bold mb-4">Giocatori</h3>
                {giocatori.map((giocatore, index) => (
                    <div key={index} className="mb-4 border p-4 rounded-lg">
                        <strong className="block text-lg mb-2">{giocatore.nome}</strong>
                        <div>Posizione: {giocatore.casellaCorrente.nome}</div>
                        <div className="">Conto {calcolaContoTotale(giocatore.conto)}</div>
                        <div>Punti Fedeltà: {giocatore.puntiFedelta}</div>
                        <div className="">Conto: </div>
                        <div>Proprietà Possedute:</div>
                        <ul className="list-disc list-inside ml-4">
                            {giocatore.proprietaPossedute.length > 0 ? (
                                giocatore.proprietaPossedute.map((proprieta, idx) => (
                                    <li key={idx}>
                                        <strong>{proprieta.nome}</strong>
                                        <br />
                                        Proprietario: {proprieta.proprietario || "Nessuno"}
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
                    </div>
                ))}
            </div>
        </div>
    );
};

export default Tabellone;
