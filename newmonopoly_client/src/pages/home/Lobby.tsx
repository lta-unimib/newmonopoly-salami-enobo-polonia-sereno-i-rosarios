import React, { useEffect, useState } from "react";
import { useLocation, Link, useNavigate } from "react-router-dom";
import IGiocatore from "../../interfaces/IGiocatore";
import IAdmin from "../../interfaces/IAdmin";
import IConfigurazione, { Difficolta } from "../../interfaces/IConfigurazione";
import StompController from "../../application/stompController";
import { Observer } from "../../application/Observer";
import IPartita from "../../interfaces/IPartita";


interface Props {
  setGiocatore: (nick: string, isImprenditore: boolean) => void;
}

const Lobby: React.FC<Props> = ({ setGiocatore }) => {
  const { state } = useLocation();
  const token = ["pedina1", "pedina2", "pedina3", "pedina4"];

  const [giocatori, setGiocatori] = useState<any[]>([]);
  const [isImprenditori, setIsImprenditori] = useState<boolean[]>([]);
  const [creatore, setCreatore] = useState<IAdmin | null>(null);
  const [selectedToken, setSelectedToken] = useState(token[0]);
  // const [isImprenditore, setIsImprenditore] = useState<boolean>(false);
  const [difficolta, setDifficolta] = useState<Difficolta>(Difficolta.EASY);
  const [lobbyCreata, setLobbyCreata] = useState(() => {
    // Recupera il valore da localStorage o usa un valore di default
    const saved = localStorage.getItem("lobbyCreata");
    return saved ? JSON.parse(saved) : false;
  });
  const [partitaCreata, setPartitaCreata] = useState(false);
  const [ready, setReady] = useState(false)

  const { nickname, admin, difficolta: difficoltaFromState } = state || {};

const navigate = useNavigate();

  useEffect(() => {
    localStorage.setItem("lobbyCreata", JSON.stringify(lobbyCreata));
    
  }, [lobbyCreata]);

  // useEffect(() => {
  //   localStorage.setItem("partitaCreata", JSON.stringify(partitaCreata));

  // }, [])

  // useEffect(() => {
  
  //   if (partitaCreata) {
  //     console.log("Partita creata, reindirizzamento in corso...");
  //     navigate("/partita", { state: { nickname, giocatori } });
  //   }
  // }, [partitaCreata])


  useEffect(() => {
    if (difficoltaFromState) {
      setDifficolta(difficoltaFromState);
    }
  }, [difficoltaFromState]);

  useEffect(() => {
    if (!nickname) return;

    if (admin) {
      const adminPlayer: IAdmin = {
        nome: nickname,
        conto: new Map([[1, { valore: 500, quantita: 1 }]]),
        casellaCorrente: { type: 'Via', nome: "Partenza", id: 1 },
        proprietaPossedute: [],
        puntiFedelta: 10,
      };
      setCreatore(adminPlayer);
      setLobbyCreata(true);
      StompController.entraLobby(nickname, (giocatori) => {
        setGiocatori(giocatori);
      });
    } else {
      if (lobbyCreata) {
        StompController.entraLobby(nickname, (giocatori) => {
          setGiocatori(giocatori);
        });
      }
    }
  }, [nickname, lobbyCreata, admin]);

  const handleSvuotaLobby = () => {
    if(admin) {
      localStorage.removeItem("lobbyCreata")

      StompController.svuotaLobby((giocatoriAggiornati) => {
          setGiocatori(giocatoriAggiornati); // Aggiorna con la lista vuota
      });
    } else {
      StompController.esciLobby(nickname, (giocatoriAggiornati) => {
        setGiocatori(giocatoriAggiornati);
      })
    }
};

  const handleAvviaPartita = () => {
    if (!nickname || !creatore) return;

    const configurazione: IConfigurazione = {
      admin: creatore,
      difficolta: difficolta as Difficolta,
      numeroGiocatori: giocatori.length,
    };
    // console.log("Request Body:", JSON.stringify(configurazione, null, 2));
    
    // Invia al server il comando per iniziare la partita
    setPartitaCreata(true)
    navigate("/partita", { state: { nickname, giocatori } });

    // StompController.creaPartita(configurazione)
    
    // navigate("/partita", { state: { nickname, giocatori } });

  console.log("Partita avviata con configurazione:", configurazione);
};

  useEffect(() => {
    
    if(ready) {
      StompController.onPartitaCreata((isCreata) => {
        setPartitaCreata(isCreata);
      });
      navigate("/partita", { state: { nickname, giocatori } });
    }
  }, [partitaCreata, ready]);

  // useEffect(() => {
  //   if (partitaCreata) {
  //       console.log("Partita creata, reindirizzamento in corso...");
  //   }
  // }, [partitaCreata, navigate, nickname, giocatori]);
  

  return (
    <div className="max-w-2xl mx-auto p-6 bg-white shadow-lg rounded-lg mt-8">
      <h1 className="text-3xl font-bold text-center mb-6 text-blue-600">
        Lobby
      </h1>

      <div className="mb-6">
        <h2 className="text-xl font-semibold mb-4">Giocatori:</h2>
        <ul className="list-disc pl-6 space-y-2">
          {giocatori.map((g) => (
            <li
              key={g}
              className="text-lg bg-blue-100 px-4 py-2 rounded-lg shadow-sm"
            >
              {g}
            </li>
          ))}
        </ul>
      </div>

      <form
        onSubmit={(e) => {
          e.preventDefault();
          handleAvviaPartita();
        }}
        className="space-y-4"
      >
        <div>
          <label
            htmlFor="tokenDropdown"
            className="block text-lg font-medium text-gray-700 mb-2"
          >
            Scegli la tua pedina:
          </label>
          <select
            id="tokenDropdown"
            value={selectedToken}
            onChange={(e) => setSelectedToken(e.target.value)}
            className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
          >
            {token.map((tk, index) => (
              <option key={index} value={tk}>
                {tk}
              </option>
            ))}
          </select>
        </div>
            {/* {partitaCreata ? "TRUE" : (
              <div>FALSE</div>
            )} */}
        {/* {difficolta === Difficolta.HARD && (
          <div className="imprenditore_checkbox">
            <label className="flex items-center space-x-2">
              <input
                type="checkbox"
                value="Imprenditore"
                checked={isImprenditore}
                onChange={handleSetImprenditore}
                className="w-5 h-5 text-blue-600 border-gray-300 rounded focus:ring-blue-500"
              />
              <span className="text-gray-700">Imprenditore</span>
            </label>
          </div>
        )} */}

        { admin ? (
          <button
            type="submit"
            className="w-full py-3 px-4 bg-green-500 text-white font-bold rounded-lg hover:bg-green-600 transition duration-200"
          >
            Avvia Partita
          </button>
        ) : (
          <button onClick={(() => (setReady(!ready)))} className="w-full py-3 px-4 bg-blue-500 text-white font-bold rounded-lg hover:bg-blue-600 transition duration-200">
            Pronto
          </button>
        )}
      </form>

      <div className="mt-4">
        <Link
          to="/"
          onClick={() => (handleSvuotaLobby())}
          className="w-full py-3 px-4 bg-gray-500 text-white font-bold rounded-lg hover:bg-gray-600 transition duration-200 block text-center"
        >
          Torna Indietro
        </Link>
      </div>
    </div>
  );
};

export default Lobby;
