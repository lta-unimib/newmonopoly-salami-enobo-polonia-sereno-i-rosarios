import React from 'react';
import ICasellaSocieta from "../../interfaces/caselle/ICasellaSocieta";
import CasellaSingleton from "./CasellaSingleton";

interface State {

}

interface Props {
    casella: ICasellaSocieta,
    children?: React.ReactNode;
    caHover: () => {}
}

export class Societa extends React.Component<Props, State> {
    render() {

        let casella : ICasellaSocieta = this.props.casella;
        let style = {}
        if (casella.proprietario !== null){
        }
        return <div className='text-center' style={style}>
            {/* <div className="" onMouseLeave={this.props.caHover} onMouseEnter={this.props.caHover} aria-disabled={this.props.casella.stato.type === "SocietaIpotecata"}> */}
            <div className="" onMouseLeave={this.props.caHover} onMouseEnter={this.props.caHover}>
                <div className="">{this.props.casella.nome}</div>
                <i className='' />
                <div className="">{this.props.casella.costoBase}</div>
                {this.props.children}
            </div>
        </div>
    }
}