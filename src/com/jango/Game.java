package com.jango;

import javax.swing.JFrame;

public class Game {
  public static void main(String[] args) {
    JFrame window = new JFrame("Jango and the Janitors");
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setContentPane(new GamePanel());
    window.pack();
    window.setVisible(true);
  }
}
