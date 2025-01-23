import React from 'react';
import ICasellaPrigione from "../../interfaces/caselle/ICasellaPrigione";


interface State {
}

interface Props {
    casella: ICasellaPrigione;
    children?: React.ReactNode;
}

export default class Prigione extends React.Component<Props, State>{
    render(){
        return <div className="text-center">
            <div className="">
                {this.props.children}
                <div className="">Prigione/</div>
                <div className="">Transito</div>
            </div>
        </div>
    }
}