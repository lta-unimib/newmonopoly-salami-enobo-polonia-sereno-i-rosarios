import {ICasella} from "./ICasella";
import ICasellaProprieta from "./ICasellaProprieta";

export type statoICasellaStazione = "StazioneAcquistata" | "StazioneIpotecata" | "StazioneNonAcquistata"

export interface ICasellaStazione extends ICasellaProprieta{
    stato: {
        type: statoICasellaStazione
    }
}

export default ICasellaStazione;