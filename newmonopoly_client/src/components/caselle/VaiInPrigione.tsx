import React from 'react';
import {ICasellaVaiInPrigione} from "../../interfaces/caselle/ICasellaVaiInPrigione";

interface State {

}

interface Props {
    casella: ICasellaVaiInPrigione
    children?: React.ReactNode;
}

export class VaiInPrigione extends React.Component<Props, State> {
    render() {
        return <div className="text-center">
            <div className="">
                <div className="">Vai in</div>
                <i className=""/>
                <div className="">Prigione</div>
                {this.props.children}
            </div>
        </div>

    }
}