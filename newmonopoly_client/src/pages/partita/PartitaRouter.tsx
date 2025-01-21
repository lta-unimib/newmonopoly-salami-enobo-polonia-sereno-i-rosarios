import React from "react";
import Partita from "./Partita";
import IPartita from "../../interfaces/IPartita";
import { useLocation } from "react-router-dom";

interface Props {}

interface State {
  nickname?: string;
  isImprenditore: boolean;
  partita?: IPartita;
}

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
  }

  render() {
    const { nickname, isImprenditore, partita } = this.state;

    if (!nickname || !partita) {
      return (
        <div className="flex items-center justify-center h-screen">
          <h1 className="text-2xl font-semibold text-gray-600">
            Caricamento partita...
          </h1>
        </div>
      );
    }

    return <Partita nickname={nickname} isImprenditore={isImprenditore} />;
  }
}

export default PartitaRouter;
