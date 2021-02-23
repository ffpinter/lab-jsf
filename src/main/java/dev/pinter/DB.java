package dev.pinter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("dbAccess")
@ViewScoped
public class DB implements Serializable {
    DAO dao = new DAO();
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
        gamesList = dao.selectTable("GAME");
        int max = 0;
        for (Game g: gamesList) {
            if(g.getId() > max){
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
            dao.insertGame(newId, newJogo);
            gamesList = dao.selectTable("GAME");
            newId = 0;
            newJogo = "";
        } catch (DataAccessException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir", null));
            e.printStackTrace();
        }
    }
}
