import IBanconota from "./IBanconota";

export enum Difficolta {
    EASY = "EASY",
    MEDIUM = "MEDIUM",
    HARD = "HARD"
}

export default interface IConfigurazione {
    admin: string,
    difficolta: Difficolta,
    numeroGiocatori: number,
}