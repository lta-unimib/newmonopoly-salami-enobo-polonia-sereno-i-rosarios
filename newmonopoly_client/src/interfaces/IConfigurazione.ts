import IAdmin from "./IAdmin";
import IBanconota from "./IBanconota";

export enum Difficolta {
    EASY = "EASY",
    MEDIUM = "MEDIUM",
    HARD = "HARD"
}

export default interface IConfigurazione {
    admin: IAdmin,
    difficolta: Difficolta,
    numeroGiocatori: number,
}