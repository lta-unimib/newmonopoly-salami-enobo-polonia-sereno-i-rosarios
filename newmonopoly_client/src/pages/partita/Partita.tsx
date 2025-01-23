import React, { useEffect, useState } from "react";
import IPartita from "../../interfaces/IPartita";
import Tabellone from "../../components/Tabellone";
import StompController from "../../application/stompController";
import { ObserverPartita, Observer } from "../../application/Observer";
import CasellaSingleton from "../../components/caselle/CasellaSingleton";

import IGiocatore from "../../interfaces/IGiocatore";
import caselleData from "../../data/caselle.json";
import Optionsbar from "../../components/Optionsbar";
import { useLocation } from "react-router-dom";

interface Props {
}

interface State {
  partita?: IPartita;
}


const caselleConId = caselleData.map((casella, index) => ({
  id: index,
  ...casella,
}));


const Partita = () =>  {
  const [Igiocatori, SetIgiocatori] = useState<IGiocatore[]>([])
  // constructor(props: Props) {
  //   // super(props);
  //   // this.state = {
  //   //   // partita: this.props.partita,
  //   // };
  // }

  // componentDidMount() {
  //   console.log("provaaa", this.props)
  //   Observer.addListener(this);
  //   // StompController.accediPartita(this.props.nickname, this.props.isImprenditore);
  // }

  // componentWillUnmount() {
  //   Observer.removeListener(this);
  // }

  // update(partita: IPartita) {
  //   this.setState({ partita });
  // }

    // console.log("prova", this.state.partita)
    // if (!this.state.partita) {
    //   return (
    //     <div className="flex items-center justify-center h-screen">
    //       <h1 className="text-2xl font-semibold text-gray-600">Caricamento partita...</h1>
    //     </div>
    //   );
    // }

    // CasellaSingleton.casellaGiocatore = {}
    // this.state.partita.giocatori.forEach(el => {
    //     CasellaSingleton.addGiocatore(el.nome, el.casellaCorrente, 'pedina')
    // })

    const { state } = useLocation()
    const { nickname, giocatori } = state || {};
    console.log("Partita: ", giocatori)

    useEffect(() => {
      
      localStorage.setItem("partitaCreata", "true");

      const nuoviGiocatori = giocatori.map((giocatore: string) => ({
        nome: giocatore,
        conto: new Map([]),
        casellaCorrente: { type: 'Via', nome: "Partenza", id: 1 },
        proprietaPossedute: [],
        puntiFedelta: 0,
      }));
    
      // Utilizziamo una funzione di aggiornamento basata sul valore precedente
      SetIgiocatori(prevIgiocatori => [...prevIgiocatori, ...nuoviGiocatori]);
    
      console.log("Igiocatori aggiornati: ", nuoviGiocatori);

      // StompController.accediPartita(giocatori)

    
    }, [])
    

    return (
      <div className="p-6">
        {/* <Tabellone
          caselle={this.state.partita.tabellone.caselle}
          giocatori={this.state.partita.giocatori}
        /> */}
      {/* <Optionsbar partita={this.props.partita} nickname={this.props.nickname} /> */}
      <Tabellone caselle={caselleConId} giocatori={Igiocatori} />
      CIao
      </div>
    );
}

export default Partita