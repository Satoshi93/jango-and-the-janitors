package com.jango;

import javax.swing.JFrame;

public class Game {
  public static void main(String[] args) {
    JFrame window = new JFrame("Jango and the Janitors");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setContentPane(new GamePanel());
    window.setSize(640, 480);
    window.pack();
    window.setVisible(true);
  }
}
