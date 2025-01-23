import React from 'react';
import {ICasellaTassa} from "../../interfaces/caselle/ICasellaTassa";

interface State {

}

interface Props {
    casella: ICasellaTassa;
    children?: React.ReactNode;
}

export class Tassa extends React.Component<Props, State> {
    render() {
        return <div className="text-center">
            <div className="">
                <div className="">{this.props.casella.nome}</div>
                <div className=""/>
                <div className="">{this.props.casella.importo}</div>
                {this.props.children}
            </div>
        </div>

    }
}