import React from "react";
import Partita from "./Partita";
import IPartita from "../../interfaces/IPartita";
import { useLocation } from "react-router-dom";
import { Difficolta } from "../../interfaces/IConfigurazione";

interface Props {}

interface State {
  nickname?: string;
  isImprenditore: boolean;
  partita?: IPartita;
}

const partitaEsempio: IPartita = {
    tabellone: {
      caselle: [],
      probabilita: [],
      imprevisti: []
    },
    config: {
      admin: "adminGiocatore",
      difficolta: Difficolta.FACILE, // Facile, Medio, Difficile
      numeroGiocatori: 4
    },
    giocatori: [
        {
          nome: "Giocatore1",
          conto: new Map([[1, { valore: 500, quantita: 1 }]]),
          casellaCorrente: { nome: "Partenza", id: 1 },
          proprietaPossedute: [
            { nome: "Proprietà 1", id: 2, proprietario: "Giocatore1", costoBase: 100, ipoteca: 50, affitto: 10 },
            { nome: "Proprietà 2", id: 3, proprietario: "Giocatore1", costoBase: 200, ipoteca: 100, affitto: 20 },
          ],
          puntiFedelta: 10,
        },
        {
          nome: "Giocatore2",
          conto: new Map([[1, { valore: 500, quantita: 1 }]]),
          casellaCorrente: { nome: "Partenza", id: 1 },
          proprietaPossedute: [
            { nome: "Proprietà 3", id: 4, proprietario: "Giocatore2", costoBase: 150, ipoteca: 75, affitto: 15 },
            { nome: "Proprietà 4", id: 5, proprietario: "Giocatore2", costoBase: 250, ipoteca: 125, affitto: 25 },
          ],
          puntiFedelta: 12,
        },
        {
          nome: "Giocatore3",
          conto: new Map([[1, { valore: 500, quantita: 1 }]]),
          casellaCorrente: { nome: "Partenza", id: 1 },
          proprietaPossedute: [
            { nome: "Proprietà 5", id: 6, proprietario: "Giocatore3", costoBase: 120, ipoteca: 60, affitto: 12 },
            { nome: "Proprietà 6", id: 7, proprietario: "Giocatore3", costoBase: 220, ipoteca: 110, affitto: 22 },
          ],
          puntiFedelta: 15,
        },
        {
          nome: "Giocatore4",
          conto: new Map([[1, { valore: 500, quantita: 1 }]]),
          casellaCorrente: { nome: "Partenza", id: 1 },
          proprietaPossedute: [
            { nome: "Proprietà 7", id: 8, proprietario: "Giocatore4", costoBase: 180, ipoteca: 90, affitto: 18 },
            { nome: "Proprietà 8", id: 9, proprietario: "Giocatore4", costoBase: 280, ipoteca: 140, affitto: 28 },
          ],
          puntiFedelta: 20,
        },
      ]
  };
class PartitaRouter extends React.Component<Props, State> {
  constructor(props: Props) {
    super(props);

    this.state = {
      nickname: undefined,
      isImprenditore: false,
      partita: undefined,
    };
  }

  componentDidMount() {
    const { state } = this.props as any; // Accesso ai parametri passati tramite routing
    if (state) {
      this.setState({
        nickname: state.nickname,
        isImprenditore: state.isImprenditore,
        partita: state.partita,
      });
    }

    // test
    console.log(this.props)
  }

  render() {
    // const { nickname, isImprenditore, partita } = this.state;
    const { nickname, isImprenditore, partita } = {
        nickname: partitaEsempio.giocatori[0].nome,
        isImprenditore: false,
        partita: partitaEsempio,
      };

    if (!nickname || !partita) {
      return (
        <div className="flex items-center justify-center h-screen">
          <h1 className="text-2xl font-semibold text-gray-600">
            Caricamento partita...
          </h1>
        </div>
      );
    }

    return <Partita nickname={nickname} isImprenditore={isImprenditore} partita={partitaEsempio}/>;
  }
}

export default PartitaRouter;
