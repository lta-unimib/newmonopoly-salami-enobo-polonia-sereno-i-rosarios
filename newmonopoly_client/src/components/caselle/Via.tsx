import React from 'react';
import ICasellaPrigione from "../../interfaces/caselle/ICasellaPrigione";


interface State {
}

interface Props {
    casella: ICasellaPrigione
    children?: React.ReactNode;
}

export default class Via extends React.Component<Props, State>{
    render(){
        return <div className="text-center">
            <div className="">
                <div className="">Ritira 200 al passaggio</div>
                <div className="">VIA!</div>
                {this.props.children}
            </div>
            <div className=""/>
        </div>
    }
}
