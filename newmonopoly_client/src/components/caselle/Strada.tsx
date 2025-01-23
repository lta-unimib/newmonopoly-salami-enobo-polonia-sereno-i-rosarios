import React from 'react';
import ICasellaStrada, { Colore } from '../../interfaces/caselle/ICasellaStrada'
import CasellaSingleton from "./CasellaSingleton";


interface State {

}

interface Props {
    casella: ICasellaStrada,
    children?: React.ReactNode;
}

export class Strada extends React.Component<Props, State> {

    render() {
        let casella : ICasellaStrada = this.props.casella;
        // let style = {}
        if (casella.proprietario !== null){
            let pedina = CasellaSingleton.pedinaGiocatore[casella.proprietario];
            // style = {backgroundColor: colore};
        }
        
        const caseJsx: React.ReactNode[] = [];

        for(let i = 0; i < this.props.casella.numeroCase; ++i){
            caseJsx.push(<div className={"casa"}></div>)
        }

        // console.log(this.props.casella.colore)

        return <div>
            {/* <div className = "" aria-disabled={this.props.casella.stato.type === "StradaIpotecata"}> */}
            <div className = "text-center"  style={{ backgroundColor: `${this.props.casella.colore}` }}>
                <div className=''>
                    {
                        this.props.casella.hasAlbergo ? <div className={"albergo"}></div> : caseJsx
                    }
                </div>
                <div className="">{this.props.casella.nome}</div>
                <div className="">{this.props.casella.costoBase}</div>
                {this.props.children}
            </div>
        </div>
    }
}