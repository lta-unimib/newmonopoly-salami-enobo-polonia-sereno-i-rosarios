package com.newmonopoly.newmonopoly.model.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newmonopoly.newmonopoly.model.gamer.Giocatore;
import com.newmonopoly.newmonopoly.interfacce.IMazzo;
import com.newmonopoly.newmonopoly.interfacce.ICasellaSubscriber;
import com.newmonopoly.newmonopoly.model.AbstractGame;
import com.newmonopoly.newmonopoly.model.Config;
import com.newmonopoly.newmonopoly.model.Game;
import com.newmonopoly.newmonopoly.model.tabellone.casella.Casella;
import com.newmonopoly.newmonopoly.model.tabellone.Tabellone;
import com.newmonopoly.newmonopoly.model.tabellone.carte.Carta;
import com.newmonopoly.newmonopoly.model.tabellone.carte.Mazzo;
import com.newmonopoly.newmonopoly.model.tabellone.strategy.FluttuazioneStrategy;
import com.newmonopoly.newmonopoly.state.game.LobbyState;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FactoryGame {

    private static FactoryGame instance;

    public static synchronized FactoryGame getInstance() {
        if (instance == null)
            instance = new FactoryGame();
        return instance;
    }

    public Tabellone creaTabellone(Config config) throws IOException {
        if(config.getDifficolta() == Config.Difficolta.HARD)
            return Tabellone.builder().caselle(creaCaselle(config)).economia(FluttuazioneStrategy.builder().build()).build();
        return Tabellone.builder().caselle(creaCaselle(config)).build();
    }

    public List<Casella> creaCaselle(Config config) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] data = FileCopyUtils.copyToByteArray(new ClassPathResource("caselle.json").getInputStream());
        String json = new String(data, StandardCharsets.UTF_8);
        Casella[] arrayCaselle = mapper.readValue(json, Casella[].class);

        ArrayList<Casella> listaCaselle = new ArrayList<>(List.of(arrayCaselle));
        Casella via = listaCaselle.get(0);
        Casella prigione = listaCaselle.get(10);
        Casella parking = listaCaselle.get(20);
        Casella vaiPrigione = listaCaselle.get(30);
        if(config.getDifficolta() == Config.Difficolta.HARD) {
            Collections.shuffle(listaCaselle);
            Collections.swap(listaCaselle, 0, listaCaselle.indexOf(via));
            Collections.swap(listaCaselle, 10, listaCaselle.indexOf(prigione));
            Collections.swap(listaCaselle, 20, listaCaselle.indexOf(parking));
            Collections.swap(listaCaselle, 30, listaCaselle.indexOf(vaiPrigione));
        }

        return listaCaselle;
    }

    public Mazzo creaMazzo(Tabellone tabellone, Config config) throws IOException {
        Mazzo mazzo = Mazzo.builder().build();
        if(config.getDifficolta() == Config.Difficolta.HARD) {
            mazzo = Mazzo.builder().economia(FluttuazioneStrategy.builder().build()).build();
        }
        mazzo.setImprevisto(new LinkedList<>(List.of(creaCarte("imprevisti.json"))));
        mazzo.setProbabilita(new LinkedList<>(List.of(creaCarte("probabilita.json"))));
        mazzo.getImprevisto().forEach(i -> i.setTabellone(tabellone));
        mazzo.getProbabilita().forEach(p -> p.setTabellone(tabellone));
        return mazzo;
    }

    public Carta[] creaCarte(String nomeFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        byte[] data = FileCopyUtils.copyToByteArray(new ClassPathResource(nomeFile).getInputStream());
        String json = new String(data, StandardCharsets.UTF_8);
        return mapper.reader().readValue(json, Carta[].class);
    }

    public AbstractGame creaPartita(Config config) throws IOException {
        Tabellone tabellone = creaTabellone(config);
        Giocatore giocatore = config.getAdmin();
        IMazzo mazzo = creaMazzo(tabellone, config);

        AbstractGame game = Game.builder()
                .tabellone(tabellone)
                .players(new ArrayList<>(List.of(giocatore)))
                .mazzo(mazzo)
                .config(config)
                .build();
        List<Casella> caselle = tabellone.getCaselle();
        for(Casella casella : caselle) {
            casella.addEventListener((ICasellaSubscriber) game);
        }
        game.setState(LobbyState.builder().build());
        return game;
    }
}
