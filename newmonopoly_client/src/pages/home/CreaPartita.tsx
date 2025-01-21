import React, { ChangeEvent } from "react";
import { NavigateFunction } from "react-router-dom";
import IConfigurazione, { Difficolta } from "../../interfaces/IConfigurazione";
import StompController from "../../application/stompController";

interface CreaPartitaProps {
    nickname: string;
    admin: boolean;
    navigate: NavigateFunction;
}

interface State {
    configurazione: IConfigurazione;
    selectedDifficolta: Difficolta;  // Cambia la tipizzazione
}

class CreaPartita extends React.Component<CreaPartitaProps, State> {
    difficolta = [Difficolta.FACILE, Difficolta.MEDIA, Difficolta.DIFFICILE];  // Usa l'enum Difficolta

    constructor(props: CreaPartitaProps) {
        super(props);

        this.state = {
            configurazione: {
                admin: this.props.nickname,
                difficolta: Difficolta.FACILE,  // Imposta l'enum
                numeroGiocatori: 6,
            },
            selectedDifficolta: Difficolta.FACILE,  // Usa l'enum
        };
    }

    handleSet = (ca: (config: IConfigurazione) => IConfigurazione) => {
        const config = this.state.configurazione;
        this.setState({ configurazione: ca(config) });
    };

    handleSubmit = (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();

        // console.log({
        //     difficolta: this.state.selectedDifficolta,
        // });

        // StompController.creaPartita(this.state.configurazione);

        this.props.navigate("/lobby", {
            state: {
                nickname: this.props.nickname,
                admin: true,
                difficolta: this.state.selectedDifficolta,  // Passa l'enum Difficolta
            },
        });
    };

    handleChangeDifficolta = (event: ChangeEvent<HTMLSelectElement>) => {
        this.handleSet((config) => {
            config.difficolta = event.target.value as Difficolta;
            return config;
        });
        this.setState({
            selectedDifficolta: event.target.value as Difficolta,  // Aggiorna anche lo stato locale
        });
    };

    render() {
        return (
            <div className="max-w-lg mx-auto p-6 bg-white shadow-lg rounded-lg mt-8">
                <h2 className="text-2xl font-bold mb-6 text-center">
                    Crea una nuova partita
                </h2>
                <form onSubmit={this.handleSubmit} className="space-y-6">
                    <div>
                        <label
                            htmlFor="difficoltaDropdown"
                            className="block text-lg font-medium text-gray-700"
                        >
                            Seleziona la difficoltà:
                        </label>
                        <select
                            id="difficoltaDropdown"
                            value={this.state.configurazione.difficolta}
                            onChange={this.handleChangeDifficolta}
                            className="w-full mt-2 p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
                        >
                            {this.difficolta.map((difficolta, index) => (
                                <option key={index} value={difficolta}>
                                    {difficolta}
                                </option>
                            ))}
                        </select>
                    </div>

                    <button
                        type="submit"
                        className="w-full py-3 px-4 bg-blue-500 text-white font-bold rounded-lg hover:bg-blue-600 transition duration-200"
                    >
                        Crea Lobby
                    </button>
                </form>
            </div>
        );
    }
}

export default CreaPartita;
