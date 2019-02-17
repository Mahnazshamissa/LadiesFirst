package com.ladiesfirst;

import java.awt.*;

public class Game {


    public static void main(String[] args) {

          EventQueue.invokeLater(() -> {
            Pacman ex = new Pacman();
            ex.setVisible(true);
        });
    }


}
