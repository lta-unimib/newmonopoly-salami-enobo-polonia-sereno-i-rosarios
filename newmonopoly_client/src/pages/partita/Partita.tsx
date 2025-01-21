import React from "react";
import IPartita from "../../interfaces/IPartita";
import Tabellone from "../../components/Tabellone";
import StompController from "../../application/stompController";
import { ObserverPartita, Observer } from "../../application/Observer";
import CasellaSingleton from "../../components/caselle/CasellaSingleton";

interface Props {
  nickname: string;
  isImprenditore: boolean;
}

interface State {
  partita?: IPartita;
}

export default class Partita extends React.Component<Props, State> implements ObserverPartita {
  constructor(props: Props) {
    super(props);
    this.state = {
      partita: undefined,
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
        <Tabellone
          caselle={this.state.partita.tabellone.caselle}
          giocatori={this.state.partita.giocatori}
        />
      </div>
    );
  }
}
