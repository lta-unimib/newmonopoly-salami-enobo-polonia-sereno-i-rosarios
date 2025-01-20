import React, { ChangeEvent } from "react";
import { NavigateFunction } from "react-router-dom";
import IConfigurazione, { Difficolta } from "../../interfaces/IConfigurazione";
import StompController from "../../application/stompController";

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
                admin: this.props.nickname,
                difficolta: Difficolta.FACILE,
                numeroGiocatori: 6,
            },
            selectedDifficolta: this.difficolta[0],
        };
    }

    handleSet = (ca: (config: IConfigurazione) => IConfigurazione) => {
        const config = this.state.configurazione;
        this.setState({configurazione: ca(config)})
    }

    handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        // Debug dei dati
        console.log({
            difficolta: this.state.selectedDifficolta,
        });

        StompController.creaPartita(this.state.configurazione);

        // Navigazione alla pagina della lobby
        this.props.navigate("/lobby", {
            state: {
                nickname: this.props.nickname,
                difficolta: this.state.selectedDifficolta,
            },
        });
    };

    handleChangeDifficolta = (event: ChangeEvent<HTMLSelectElement>) => {
        this.handleSet((config) => {
            config.difficolta = event.target.value as Difficolta;
            return config;
        })
    }


    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div className="flex flex-col gap-4 mt-6">
                        <div>
                            <span>Seleziona la difficoltà:</span>
                            <select
                                id="difficoltaDropdown"
                                value={this.state.configurazione.difficolta}
                                onChange={this.handleChangeDifficolta}
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
