import React from 'react';
import {ICasellaImprevisti} from "../../interfaces/caselle/ICasellaImprevisti";

interface State {

}

interface Props {
    casella: ICasellaImprevisti;
    children?: React.ReactNode;
}

export class Imprevisti extends React.Component<Props, State> {
    render() {
        return <div className="text-center">
            <div className="">
                <div className="">{this.props.casella.nome}</div>
                <div className="">&nbsp; </div>
                <i className=""/>
                {this.props.children}
            </div>
        </div>


    }
}