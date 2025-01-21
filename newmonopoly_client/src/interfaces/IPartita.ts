import ICasella from "./caselle/ICasella";
import IConfigurazione from "./IConfigurazione";
import IGiocatore from "./IGiocatore";

export default interface IPartita{
    // admin: string,
    tabellone: {
        caselle: ICasella[],
        probabilita: [],
        imprevisti: []
    },
    config: IConfigurazione,
    giocatori: IGiocatore[],
}