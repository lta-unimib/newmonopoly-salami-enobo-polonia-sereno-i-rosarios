import ICasella from "./caselle/ICasella";
import IBanconota from "./IBanconota";
import ICasellaProprieta from "./caselle/ICasellaProprieta";

export default interface IGiocatore {
    nome: string;
    conto: Map<number, IBanconota>;
    casellaCorrente: ICasella;
    proprietaPossedute: ICasellaProprieta[];
    puntiFedelta: number;
}
