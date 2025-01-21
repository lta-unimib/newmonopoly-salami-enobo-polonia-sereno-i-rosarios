import {ICasellaProprieta} from "./ICasellaProprieta";

export enum Colore {
    ROSSO = "red",
    BLU = "blue",
    AZZURRO = "lightblue",
    GIALLO = "yellow",
    ARANCIONE = "orange",
    MARRONE = "brown",
    VIOLA = "purple",
    VERDE = "green"
} 


export type statoICasellaStrada = "StradaAcquistata" | "StradaIpotecata" | "StradaNonAcquistata"

export interface ICasellaStrada extends ICasellaProprieta{
    type: "Strada",
    affitti: number[],
    colore: Colore,
    costoAlbergo: number,
    costoCasa: number,
    hasAlbergo: boolean,
    numeroCase: number,
    stato: {
        type: statoICasellaStrada
    }
}

export default ICasellaStrada;