package com.company.test.game;

import com.company.test.ailogic.Logic;

public class Player {

    enum PlayerType {
        USER,
        PC
    }

    private String name;
    private PlayerType playerType;
    private Logic logic;

    public Player(String name, PlayerType playerType, Logic logic) {
        this.name = name;
        this.playerType = playerType;
        this.logic = logic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Logic getLogic() {
        return logic;
    }
}
