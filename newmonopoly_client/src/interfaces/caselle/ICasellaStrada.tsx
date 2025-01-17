import {ICasellaProprieta} from "./ICasellaProprieta";

export enum Colore {
    ROSSO = "red",
    BLU = "blue",
    AZZURRO = "light-blue",
    GIALLO = "yellow",
    ARANCIONE = "orange",
    MARRONE = "brown",
    VIOLA = "purple",
    VERDE = "green"
}

export interface ICasellaStrada extends ICasellaProprieta{
    type: "Strada",
    affitti: number[],
    colore: Colore,
    costoAlbergo: number,
    costoCasa: number,
    hasAlbergo: boolean,
    numeroCase: number
}

export default ICasellaStrada;