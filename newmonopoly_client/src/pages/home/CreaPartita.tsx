import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const CreaPartita = () => {
    const difficolta = ["Facile", "Medio", "Difficile"];
    const token = ["pedina1", "pedina2", "pedina3", "pedina4"];

    const [nickname, setNickname] = useState("");
    const [selectedDifficolta, setSelectedDifficolta] = useState(difficolta[0]);
    const [selectedToken, setSelectedToken] = useState(token[0]);

    // Hook per navigare tra le pagine
    const navigate = useNavigate();

    const handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        // Stampo i dati per il debug
        console.log({
            nickname,
            difficolta: selectedDifficolta,
            token: selectedToken,
        });

        // Naviga alla pagina della lobby dopo il submit
        navigate("/lobby", {
            state: {
                nickname,
                difficolta: selectedDifficolta,
                token: selectedToken,
            },
        });
    };

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <div className="flex flex-col gap-4 mt-6">
                    <label>
                        Inserisci il tuo nickname:
                        <input
                            type="text"
                            required
                            value={nickname}
                            onChange={(e) => setNickname(e.target.value)}
                        />
                    </label>

                    <div>
                        <span>Seleziona la difficoltà:</span>
                        <select
                            id="difficoltaDropdown"
                            value={selectedDifficolta}
                            onChange={(e) => setSelectedDifficolta(e.target.value)}
                        >
                            {difficolta.map((i, index) => (
                                <option key={index} value={i}>
                                    {i}
                                </option>
                            ))}
                        </select>
                    </div>

                    <div>
                        <span>Scegli la pedina:</span>
                        <select
                            id="tokenDropdown"
                            value={selectedToken}
                            onChange={(e) => setSelectedToken(e.target.value)}
                        >
                            {token.map((tk, index) => (
                                <option key={index} value={tk}>
                                    {tk}
                                </option>
                            ))}
                        </select>
                    </div>

                    <button type="submit">Crea Partita</button>
                </div>
            </form>
        </div>
    );
};

export default CreaPartita;
