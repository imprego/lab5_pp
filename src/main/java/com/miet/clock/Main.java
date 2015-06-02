package com.miet.clock;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;


public class Main extends JFrame{
    private static ArrowHand arrowSec;
    private static ArrowPanel arrPan;
    /**
     * Class constructor.
     */
    public Main() {
        setTitle("Clock");
        setSize(400, 400);
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        add(mainPanel);

        arrPan = new ArrowPanel();
        mainPanel.add(arrPan);
    }
    /**
     * Getting panel with drawing arrows.
     * @return panel of frame
     * @see ArrowPanel
     */
    public static ArrowPanel getArrowPanel() {
        return arrPan;
    }

    public static void main(String[] args) {
        Main frame = new Main();

        arrowSec = new ArrowHand();
        arrowSec.setTime(13, 30, 45);
        Timer timer = new Timer(1000, arrowSec );
        timer.start();
        System.out.println(arrowSec.getTime());
    }
}

