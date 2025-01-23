import React from "react";
import IPartita from "../../interfaces/IPartita";
import Tabellone from "../../components/Tabellone";
import StompController from "../../application/stompController";
import { ObserverPartita, Observer } from "../../application/Observer";
import CasellaSingleton from "../../components/caselle/CasellaSingleton";

import IGiocatore from "../../interfaces/IGiocatore";
import caselleData from "../../data/caselle.json";
import Optionsbar from "../../components/Optionsbar";

interface Props {
  nickname: string;
  isImprenditore: boolean;
  partita: IPartita;
}

interface State {
  partita?: IPartita;
}

const giocatori: IGiocatore[] = [
  {
    nome: "Giocatore1",
    conto: new Map([[1, { valore: 500, quantita: 1 }]]),
    casellaCorrente: { type: 'Via', nome: "Partenza", id: 1 },
    proprietaPossedute: [
      { type: 'Strada', nome: "Proprietà 1", id: 2, proprietario: "Giocatore1", costoBase: 100, ipoteca: 50, affitto: 10 },
      { type: 'Strada', nome: "Proprietà 2", id: 3, proprietario: "Giocatore1", costoBase: 200, ipoteca: 100, affitto: 20 },
    ],
    puntiFedelta: 10,
  },
  {
    nome: "Giocatore2",
    conto: new Map([[1, { valore: 500, quantita: 1 }]]),
    casellaCorrente: { type: 'Via', nome: "Partenza", id: 1 },
    proprietaPossedute: [
      { type: 'Strada', nome: "Proprietà 3", id: 4, proprietario: "Giocatore2", costoBase: 150, ipoteca: 75, affitto: 15 },
      { type: 'Strada', nome: "Proprietà 4", id: 5, proprietario: "Giocatore2", costoBase: 250, ipoteca: 125, affitto: 25 },
    ],
    puntiFedelta: 12,
  },
  {
    nome: "Giocatore3",
    conto: new Map([[1, { valore: 500, quantita: 1 }]]),
    casellaCorrente: { type: 'Via', nome: "Partenza", id: 1 },
    proprietaPossedute: [
      { type: 'Strada', nome: "Proprietà 5", id: 6, proprietario: "Giocatore3", costoBase: 120, ipoteca: 60, affitto: 12 },
      { type: 'Strada', nome: "Proprietà 6", id: 7, proprietario: "Giocatore3", costoBase: 220, ipoteca: 110, affitto: 22 },
    ],
    puntiFedelta: 15,
  },
  {
    nome: "Giocatore4",
    conto: new Map([[1, { valore: 500, quantita: 1 }]]),
    casellaCorrente: { type: 'Via', nome: "Partenza", id: 1 },
    proprietaPossedute: [
      { type: 'Strada', nome: "Proprietà 7", id: 8, proprietario: "Giocatore4", costoBase: 180, ipoteca: 90, affitto: 18 },
      { type: 'Strada', nome: "Proprietà 8", id: 9, proprietario: "Giocatore4", costoBase: 280, ipoteca: 140, affitto: 28 },
    ],
    puntiFedelta: 20,
  },
];

const caselleConId = caselleData.map((casella, index) => ({
  id: index,
  ...casella,
}));
export default class Partita extends React.Component<Props, State> implements ObserverPartita {
  constructor(props: Props) {
    super(props);
    this.state = {
      partita: this.props.partita,
    };
  }

  componentDidMount() {
    Observer.addListener(this);
    StompController.accediPartita(this.props.nickname, this.props.isImprenditore);
  }

  componentWillUnmount() {
    Observer.removeListener(this);
  }

  update(partita: IPartita) {
    this.setState({ partita });
  }

  render() {
    console.log("Porcaccio", this.state.partita)
    if (!this.state.partita) {
      return (
        <div className="flex items-center justify-center h-screen">
          <h1 className="text-2xl font-semibold text-gray-600">Caricamento partita...</h1>
        </div>
      );
    }

    CasellaSingleton.casellaGiocatore = {}
    this.state.partita.giocatori.forEach(el => {
        CasellaSingleton.addGiocatore(el.nome, el.casellaCorrente, 'pedina')
    })

    return (
      <div className="p-6">
        {/* <Tabellone
          caselle={this.state.partita.tabellone.caselle}
          giocatori={this.state.partita.giocatori}
        /> */}
      <Optionsbar partita={this.props.partita} nickname={this.props.nickname} />
      <Tabellone caselle={caselleConId} giocatori={giocatori} />
      </div>
    );
  }
}
