import IBanconota from "./IBanconota";

export enum Difficolta {
    EASY = "EASY",
    MEDIUM = "MEDIUM",
    HARD = "HARD"
}

export default interface IConfigurazione {
    difficolta: Difficolta,
    soldiIniziali: Map<number, IBanconota>;
    numeroGiocatori: number,
    // countDadiUguali: number,
}