import ICasella from "../../interfaces/caselle/ICasella";

export default class CasellaSingleton {
    static casellaGiocatore: { [index: number]: string[] } = {}; // Mantiene la lista dei giocatori per ogni casella
    static pedinaGiocatore: { [key: string]: string } = {}; // Pedine per ogni giocatore

    // Aggiungi un giocatore a una casella con la sua pedina
    static addGiocatore(nome: string, casella: ICasella, pedina: string): void {
        // Assegna la pedina al giocatore se non ce l'ha già
        if (this.pedinaGiocatore[nome] === undefined) {
            this.pedinaGiocatore[nome] = pedina;
        }

        // Aggiungi il giocatore alla casella (identificata dal suo indice nell'array delle caselle)
        if (this.casellaGiocatore[casella.id]) {
            // Se la casella ha già dei giocatori, aggiungi il nuovo giocatore
            this.casellaGiocatore[casella.id].push(nome);
        } else {
            // Se la casella non ha giocatori, crea una lista con il nuovo giocatore
            this.casellaGiocatore[casella.id] = [nome];
        }
    }
}
