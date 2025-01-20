import ICasella from "./caselle/ICasella";
import IConfigurazione from "./IConfigurazione";
import IGiocatore from "./IGiocatore";

export default interface IPartita{
    tabellone: {
        caselle: ICasella[],
        probabilita: [],
        imprevisti: []
    },
    config: IConfigurazione,
    giocatori: IGiocatore[],
}