import React from 'react';
import ICasellaParcheggio from "../../interfaces/caselle/ICasellaParcheggio";

interface State {

}

interface Props {
    casella: ICasellaParcheggio;
    children?: React.ReactNode;
}

export class Parcheggio extends React.Component<Props, State> {
    render() {
        return <div className="text-center">
            <div className="">
                <div className="">Free</div>
                <i className=""/>
                <div className="">Parking</div>
                {this.props.children}
            </div>
        </div>

    }
}