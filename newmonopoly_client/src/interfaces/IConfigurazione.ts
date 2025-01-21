import IBanconota from "./IBanconota";

export enum Difficolta {
    FACILE = "Facile",
    MEDIA = "Medio",
    DIFFICILE = "Difficile"
}

export default interface IConfigurazione {
    admin: string,
    difficolta: Difficolta,
    numeroGiocatori: number,
}