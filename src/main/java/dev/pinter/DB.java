package dev.pinter;

import javax.inject.Named;
import java.util.List;

@Named("dbAccess")
public class DB {
    DAO dao = new DAO();
    private final List<Game> gamesList;

    public DB(){
        gamesList = dao.selectTable("GAME");
    }

    public List<Game> getGamesList(){
        return gamesList;
    }
}
