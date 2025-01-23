import React from 'react';
import {ICasellaProbabilita} from "../../interfaces/caselle/ICasellaProbabilita";

interface State {

}

interface Props {
    casella: ICasellaProbabilita;
    children?: React.ReactNode;
}

export class Probabilita extends React.Component<Props, State> {
    render() {
        return <div className="text-center">
            <div className="">
                <div className="">{this.props.casella.nome}</div>
                <div className="">&nbsp; </div>
                <i className=""/>
                <div className=""></div>
                {this.props.children}
            </div>
        </div>

    }
}