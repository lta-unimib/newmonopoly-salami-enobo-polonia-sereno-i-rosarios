import IBanconota from "./IBanconota";

export enum Difficolta {
    FACILE = "FACILE",
    MEDIA = "MEDIA",
    DIFFICILE = "DIFFICILE"
}

export default interface IConfigurazione {
    admin: string,
    difficolta: Difficolta,
    numeroGiocatori: number,
}