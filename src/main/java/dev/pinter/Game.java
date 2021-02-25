package dev.pinter;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Game {
    @ColumnName("ID")
    private int id;

    @ColumnName("JOGO")
    private String jogo;

    @ColumnName("DESCRICAO")
    private String desc;

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", jogo='" + jogo + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

}