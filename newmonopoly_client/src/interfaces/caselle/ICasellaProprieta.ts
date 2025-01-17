import {ICasella} from "./ICasella";

export interface ICasellaProprieta extends ICasella{
    proprietario: string;
    costo: number;
    ipoteca: number;
    affitto: number;
}

export default ICasellaProprieta;