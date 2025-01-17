import React from 'react'

const CreaPartita = () => {

    const difficolta = ["Facile", "Medio", "Difficile"]
    const token = ["pedina1", "pedina2", "pedina3", "pedina4"]

  return (
    <div>CreaPartita
        <form>
            <div className="flex flex-col gap-4 mt-6">
                Inserisci il tuo nickame <input type='text' required/>
                <div className="">
                    <span>Seleziona la difficoltà:</span> <select id="dropdown">
                        {difficolta.map(( i ) => (
                            <option value={i}>{i}</option>
                        ))}
                    </select>
                </div>
                <div className="">
                    <span>Scegli la pedina:</span> <select id="dropdown">
                        {token.map(( tk ) => (
                            <option value={tk}>{tk}</option>
                        ))}
                    </select>
                </div>
                <button type='submit'>Crea  Partita</button>
            </div>
        </form>

    </div>
  )
}

export default CreaPartita