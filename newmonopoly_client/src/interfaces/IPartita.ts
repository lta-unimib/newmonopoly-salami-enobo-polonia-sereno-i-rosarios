import ICasella from "./caselle/ICasella";
import IConfigurazione from "./IConfigurazione";
import IGiocatore from "./IGiocatore";

export default interface IPartita{
    // admin: string,
    tabellone: {
        caselle: ICasella[],
        probabilita: ICasella[],
        imprevisti: ICasella[]
    },
    config: IConfigurazione,
    giocatori: IGiocatore[],
}