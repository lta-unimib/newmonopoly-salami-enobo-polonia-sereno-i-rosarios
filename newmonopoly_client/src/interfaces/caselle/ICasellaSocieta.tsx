import ICasellaProprieta from "./ICasellaProprieta";

export type statoICasellaSocieta = "SocietaAcquistata" | "SocietaIpotecata" | "SocietaNonAcquistata"

export interface ICasellaSocieta extends ICasellaProprieta{
    stato: {
        type: statoICasellaSocieta
    }
}

export default ICasellaSocieta;