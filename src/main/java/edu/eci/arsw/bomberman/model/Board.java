package edu.eci.arsw.bomberman.model;

import org.javatuples.Pair;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

public class Board implements Serializable {

    ConcurrentHashMap<Pair<Integer, Integer>, Position> Positions = new ConcurrentHashMap<>();
    // probar
    public Board(){
        for (int x = 0; x < 21; x++){
            for (int y = 0; y < 13; y++){
                Positions.put(new Pair<>(x, y), new Position(x, y));
            }
        }
    }

    public Status getStatusPosition(int x, int y){
        return Positions.get(new Pair<>(x,y)).getStatus();
    }

    public void setStatusAndBombPosition(int x, int y){
        if (getStatusPosition(x, y).equals(Status.EMPTY)) {
            Positions.get(new Pair<>(x, y)).placeBomb(new Bomb(x, y));
        }
    }

    public void setStatusAndPlayerPosition(int x, int y, Player player){
        Positions.get(new Pair<>(x, y)).placePlayer(player);
        player.setXY(x, y);
    }

    public void setStatusAndPlayerPositionRight(Player player){
        Positions.get(new Pair<>(player.getX()+1, player.getY())).placePlayer(player);
        Positions.get(new Pair<>(player.getX(), player.getY())).setStatus(Status.EMPTY);
        player.moveRight();
    }

    public void setStatusAndPlayerPositionLeft(Player player){
        Positions.get(new Pair<>(player.getX()-1, player.getY())).placePlayer(player);
        Positions.get(new Pair<>(player.getX(), player.getY())).setStatus(Status.EMPTY);
        player.moveLeft();
    }

    public void setStatusAndPlayerPositionUp(Player player){
        Positions.get(new Pair<>(player.getX(), player.getY()+1)).placePlayer(player);
        Positions.get(new Pair<>(player.getX(), player.getY())).setStatus(Status.EMPTY);
        player.moveUp();

    }

    public void setStatusAndPlayerPositionDown(Player player){
        Positions.get(new Pair<>(player.getX(), player.getY()-1)).placePlayer(player);
        Positions.get(new Pair<>(player.getX(), player.getY())).setStatus(Status.EMPTY);
        player.moveDown();
    }
    public String toString() {
        return "Board{" +
                "Positions=" + Positions +
                '}';
    }
}