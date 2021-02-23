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
    private final List<Game> gamesList;

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
    }

    public List<Game> getGamesList() {
        return gamesList;
    }

    public void updateGamesList(ActionEvent event) {
        try {
            dao.updateTable(newId, newJogo);
        } catch (DataAccessException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao inserir", null));
            e.printStackTrace();
        }
    }
}
