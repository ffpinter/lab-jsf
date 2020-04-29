package dev.pinter;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class Game {
    @ColumnName("ID")
    private int id;

    @ColumnName("JOGO")
    private String jogo;

    public Game(){}

    public Game(int id, String jogo){
        this.id = id;
        this.jogo = jogo;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getJogo(){
        return jogo;
    }

    public void setJogo(String jogo){
        this.jogo = jogo;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", jogo='" + jogo + '\'' +
                '}';
    }
}