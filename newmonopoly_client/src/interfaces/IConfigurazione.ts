import IBanconota from "./IBanconota";

export enum Difficolta {
    FACILE = "FACILE",
    MEDIA = "MEDIA",
    DIFFICILE = "DIFFICILE"
}

export default interface IConfigurazione {
    difficolta: Difficolta,
    numeroGiocatori: number,
    caselleCasuali: boolean,
    fluttuazioneEconomica: boolean,
    // banconote = HashMap<>();
}