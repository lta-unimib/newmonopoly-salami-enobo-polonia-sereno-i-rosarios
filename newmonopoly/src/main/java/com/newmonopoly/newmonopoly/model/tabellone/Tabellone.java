package com.newmonopoly.newmonopoly.model.tabellone;

import com.newmonopoly.newmonopoly.model.gamer.Token;

import java.util.ArrayList;

import static com.newmonopoly.newmonopoly.model.tabellone.Via.getVia;

public class Tabellone {
    private static Tabellone tabellone = null;

    private int difficolta = 1;
    private ArrayList<Casella> caselle;
    private ArrayList<Token> pedine;

    //Tabellone è Singleton, quando viene chiamata la prima volta getTabellone viene inizializzato
    //inserendo nell'arrayList pedine i token dei giocatori in gioco.
    //i giocatori scelgono il loro token quando si sta creando la partita, una volta premuto start game allora
    //si inizializza il tabellone con le pedine scelte(secondo me la logica dovrebbe essere questa)

    public Tabellone (ArrayList<Token> tokensInGame){
        caselle = new ArrayList<Casella>(40);
        pedine = tokensInGame;
        inizializzaPosizioni(pedine);
    }

    public static synchronized Tabellone getTabellone(ArrayList<Token> tokensInGame) {
        if (tabellone == null) {
            tabellone = new Tabellone(tokensInGame);
        }
        return tabellone;
    }

    public void inizializzaPosizioni(ArrayList<Token> pedine)
    {
        for(Token token : pedine) {
            token.setCasella(getVia());
        }
    }

    /// per settaggio difficoltà
    public void setTabellone(int difficolta) {
        switch (difficolta){
            case 1:
                ///
        }
    }


    public ArrayList<Casella> getCaselle() {
        return caselle;
    }
}
