package dev.pinter;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.JdbiException;
import org.jdbi.v3.core.mapper.reflect.FieldMapper;

import java.util.List;

public class DAO {
    private final Jdbi jdbi = Jdbi.create("jdbc:derby:firstdb");

    public DAO() {
        System.setProperty("derby.system.home", "E:/Users/flavio/Documents/DERBYTUTOR/");
    }

    public int insertGame(int id, String jogo) throws DataAccessException {
        try {
            return jdbi.withHandle(handle -> handle.createUpdate("INSERT INTO GAME(ID, JOGO) VALUES (:ID, :JOGO)")
                    .bind("ID", id)
                    .bind("JOGO", jogo)
                    .execute());
        } catch (JdbiException e){
            throw new DataAccessException("Error ao inserir");
        }
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
