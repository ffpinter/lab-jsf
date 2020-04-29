package dev.pinter;

import javax.inject.Named;
import java.util.List;

@Named("dbAccess")
public class DB {
    private final List<Game> gamesList;

    public DB(){
        DAO dao = new DAO();
        gamesList = dao.selectTable("GAME");
    }

    public List<Game> getGamesList(){
        return gamesList;
    }
}
