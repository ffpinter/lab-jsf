package dev.pinter;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.FieldMapper;
import java.util.List;

public class DAO {
    private final Jdbi jdbi = Jdbi.create("jdbc:derby:firstdb");

    public DAO() {
        System.setProperty("derby.system.home", "C:/Users/flavi/Documents/DERBYTUTOR/");
    }

    public int updateTable(int id, String jogo) {
        return jdbi.withHandle(handle -> handle.createUpdate("INSERT INTO GAME(ID, JOGO) VALUES (:ID, :JOGO)")
                .bind("ID", id)
                .bind("JOGO", jogo)
                .execute());
    }

    public List<Game> selectTable(String tablename) {
        return jdbi.withHandle(handle -> {
            handle.registerRowMapper(FieldMapper.factory(Game.class));
            return handle.createQuery("SELECT * FROM " + tablename)
                    .mapTo(Game.class)
                    .list();
        });
    }
}
