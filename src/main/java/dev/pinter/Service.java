/*
 * Copyright (C) 2021 - Flavio Freitas Pinter
 */

package dev.pinter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Service {
    DAO dao = new DAO();
    SpotifyAPI spotifyAPI = new SpotifyAPI();

    public Service() {
    }

    public List<Game> getGameList() {
        List<Game> games = dao.selectGame();
        for (Game g : games) {
            File file = new File(System.getProperty("user.dir") + "/JsfGamesImages/" + g.getId() + ".png");
            if (file.isFile()) {
                try {
                    InputStream is = Files.newInputStream(file.toPath(), StandardOpenOption.READ);
                    g.setImg(is.readAllBytes());
                } catch (IOException ignored) {

                }
            }
        }
        return games;
    }

    public void createGame(int id, String jogo) throws DataAccessException {
        dao.insertGame(id, jogo);
    }
    
    public AccessTokenResponse getAccesssToken() {
        String encodedAuth = spotifyAPI.getEncodedIds();
        return spotifyAPI.getAccessToken(encodedAuth);
    }

    public Album getAlbum(String authToken, String id) {
        return spotifyAPI.getAlbum(authToken, id);
    }

    public Artist getArtist(String authToken, String id){
        return spotifyAPI.getArtist(authToken, id);
    }
}
