package dev.pinter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Service {
    DAO dao = new DAO();

    public Service() {
    }

    public List<Game> getList(String table) {
        return dao.selectTable(table);
    }

    public void setList(int id, String jogo) throws DataAccessException {
        dao.insertGame(id, jogo);
    }


}
