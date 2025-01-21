import React from 'react';
import {ICasellaImprevisto} from "../../interfaces/caselle/ICasellaImprevisto";

interface State {

}

interface Props {
    casella: ICasellaImprevisto;
    children?: React.ReactNode;
}

export class Imprevisto extends React.Component<Props, State> {
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