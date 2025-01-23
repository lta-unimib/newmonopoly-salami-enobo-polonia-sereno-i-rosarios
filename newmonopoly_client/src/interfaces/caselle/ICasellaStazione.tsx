import ICasellaProprieta from "./ICasellaProprieta";

export type statoICasellaStazione = "StazioneAcquistata" | "StazioneIpotecata" | "StazioneNonAcquistata"

export interface ICasellaStazione extends ICasellaProprieta{
    type: "Stazione",
    affitti: number[],
    stato: {
        type: statoICasellaStazione
    }
}

export default ICasellaStazione;