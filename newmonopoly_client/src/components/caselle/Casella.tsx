import ICasella from "../../interfaces/caselle/ICasella";
import React from "react";
import {Imprevisti} from "./Imprevisti";
import {Strada} from "./Strada";
import {Societa} from "./Societa";
import {Stazione} from "./Stazione";
import Prigione from "./Prigione";
import {Probabilita} from "./Probabilita";
import {Tassa} from "./Tassa";
import {VaiInPrigione} from "./VaiInPrigione";
import {Parcheggio} from "./Parcheggio";
import Via from "./Via";
import CasellaSingleton from "./CasellaSingleton";

const translate = {
    "Imprevisti": (props: any, giocatoriJsx: React.ReactNode) => <Imprevisti casella={props}>{giocatoriJsx} </Imprevisti>,
    "Strada": (props: any, giocatoriJsx: React.ReactNode, ca: () => {}) => <Strada casella={props} caHover={ca}> {giocatoriJsx} </Strada>,
    "Societa": (props: any, giocatoriJsx: React.ReactNode, ca: () => {}) => <Societa caHover={ca} casella={props}>{giocatoriJsx}</Societa>,
    "Stazione": (props: any, giocatoriJsx: React.ReactNode, ca: () => {}) => <Stazione caHover={ca} casella={props}>{giocatoriJsx}</Stazione>,
    "Prigione": (props: any, giocatoriJsx: React.ReactNode) => <Prigione casella={props}>{giocatoriJsx}</Prigione>,
    "Probabilita": (props: any, giocatoriJsx: React.ReactNode) => <Probabilita casella={props}>{giocatoriJsx}</Probabilita>,
    "Tassa": (props: any, giocatoriJsx: React.ReactNode) => <Tassa casella={props}>{giocatoriJsx}</Tassa>,
    "VaiInPrigione": (props: any, giocatoriJsx: React.ReactNode) => <VaiInPrigione casella={props}>{giocatoriJsx}</VaiInPrigione>,
    "Parcheggio": (props: any, giocatoriJsx: React.ReactNode) => <Parcheggio casella={props}>{giocatoriJsx}</Parcheggio>,
    "Via": (props: any, giocatoriJsx: React.ReactNode) => <Via casella={props}>{giocatoriJsx}</Via>
}

type Props = ICasella

export class Casella extends React.Component<Props>{

    constructor(props: Props) {
        super(props);
    }

    render() {
        if ("type" in this.props) {
            console.log("Tipo della casella:", this.props.type);
        } else {
            console.warn("Proprietà 'type' non trovata nei dati forniti:", this.props);
        }

        if (!CasellaSingleton.casellaGiocatore[this.props.id]) {
            console.warn("Nessun giocatore trovato per la casella:", this.props.id);
        }

        console.log("CasellaSingleton.casellaGiocatore:", CasellaSingleton.casellaGiocatore);


        const giocatoriJsx = <>
            <div className=''>
            {
                CasellaSingleton.casellaGiocatore[this.props.id]?.map(el => {
                        const pedina = CasellaSingleton.pedinaGiocatore[el];
                        return <div title={el} style={{backgroundColor: ''}}>{pedina}</div>
                    }
                )
            }
        </div>

        </>
        //@ts-ignore
        return translate[this.props.type](this.props, giocatoriJsx)
    }

}