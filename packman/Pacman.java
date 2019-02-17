package com.ladiesfirst;

import javax.swing.JFrame;
import java.awt.*;

public class Pacman extends JFrame {

    private final int width = 380;
    private final int height = 420;
    private final String titleOfGame = "Pacman";


    public Pacman() {initUI();}

    private void initUI() {

        add(new Board());
        setTitle(titleOfGame);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
    }


}
