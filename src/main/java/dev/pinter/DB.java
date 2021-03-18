/*
 * Copyright (C) 2021 - Flavio Freitas Pinter
 */

package dev.pinter;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.List;

@Named("dbAccess")
@ViewScoped
public class DB implements Serializable {
    Service service = new Service();
    private List<Game> gamesList;

    private int newId;
    private String newJogo;

    public int getNewId() {
        return newId;
    }

    public void setNewId(int newId) {
        this.newId = newId;
    }

    public String getNewJogo() {
        return newJogo;
    }

    public void setNewJogo(String newJogo) {
        this.newJogo = newJogo;
    }

    public DB() {
        gamesList = service.getGameList();
        int max = 0;
        for (Game g : gamesList) {
            if (g.getId() > max) {
                max = g.getId();
                newId = max + 1;
            }
        }
    }

    public List<Game> getGamesList() {
        return gamesList;
    }

    public void insertGamesList(ActionEvent event) {
        try {
            service.createGame(newId, newJogo);
            gamesList = service.getGameList();
            newId = 0;
            newJogo = "";
        } catch (DataAccessException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir", null));
            e.printStackTrace();
        }
    }

    public StreamedContent getImageStream(int id) {
        Game game = gamesList.stream().filter(f -> f.getId() == id).findFirst().orElse(null);
        if (game == null || game.getImg() == null) {
            return null;
        }
        try {
            String mimeType = URLConnection.guessContentTypeFromStream(new ByteArrayInputStream(game.getImg()));
            return DefaultStreamedContent.builder()
                    .contentType(mimeType).stream(() -> new ByteArrayInputStream(game.getImg())).
                            build();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }
//
//    public Album requestAlbum(String id){
//        AccessTokenResponse accessToken = service.getAccesssToken();
//        return service.getAlbum(accessToken.getAccessToken(), id);
//    }
//
}
