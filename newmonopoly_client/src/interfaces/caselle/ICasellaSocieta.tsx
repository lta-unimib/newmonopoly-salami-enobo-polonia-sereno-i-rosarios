import ICasellaProprieta from "./ICasellaProprieta";

export type statoICasellaSocieta = "SocietaAcquistata" | "SocietaIpotecata" | "SocietaNonAcquistata"

export interface ICasellaSocieta extends ICasellaProprieta{
    type: "Societa",
    stato: {
        type: statoICasellaSocieta
    }
}

export default ICasellaSocieta;