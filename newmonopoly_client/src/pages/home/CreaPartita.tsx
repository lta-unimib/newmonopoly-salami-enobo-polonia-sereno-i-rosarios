import React from "react";
import { NavigateFunction } from "react-router-dom";
import IConfigurazione, { Difficolta } from "../../interfaces/IConfigurazione";

interface CreaPartitaProps {
    nickname: string;
    navigate: NavigateFunction; // Deve essere passato come prop
}

interface State {
    configurazione: IConfigurazione;
    selectedDifficolta: string;
}

class CreaPartita extends React.Component<CreaPartitaProps, State> {
    difficolta = ["Facile", "Medio", "Difficile"];

    constructor(props: CreaPartitaProps) {
        super(props);

        this.state = {
            configurazione: {
                difficolta: Difficolta.FACILE,
                numeroGiocatori: 6,
                caselleCasuali: false,
                fluttuazioneEconomica: false,
            },
            selectedDifficolta: this.difficolta[0],
        };
    }

    handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        // Debug dei dati
        console.log({
            difficolta: this.state.selectedDifficolta,
        });

        // Navigazione alla pagina della lobby
        this.props.navigate("/lobby", {
            state: {
                nickname: this.props.nickname,
                difficolta: this.state.selectedDifficolta,
            },
        });
    };

    handleChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
        this.setState({ selectedDifficolta: e.target.value });
    };

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div className="flex flex-col gap-4 mt-6">
                        <div>
                            <span>Seleziona la difficoltà:</span>
                            <select
                                id="difficoltaDropdown"
                                value={this.state.selectedDifficolta}
                                onChange={this.handleChange}
                            >
                                {this.difficolta.map((i, index) => (
                                    <option key={index} value={i}>
                                        {i}
                                    </option>
                                ))}
                            </select>
                        </div>

                        <button type="submit">Crea Lobby</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default CreaPartita;
