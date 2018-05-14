package com.jango;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class GamePanel extends JPanel implements Runnable {
  private static final int WIDTH = 800;
  private static final int HEIGHT = 400;

  private Thread thread;
  private boolean running;

  private BufferedImage image;
  private BufferedImage background;
  private Graphics2D g;

  private int FPS = 30;
  private int targetTime = 1000/FPS;

  public GamePanel() {
    super();
    setPreferredSize(new Dimension(WIDTH, HEIGHT));
    setFocusable(true);
    requestFocus();
  }

  public void addNotify() {
    super.addNotify();
    if (thread == null) {
      thread = new Thread(this);
      thread.start();
    }
  }

  public void run() {
    init();

    long startTime;
    long urdTime;
    long waitTime;

    while (running) {
      startTime = System.nanoTime();
      update();
      render();
      draw();
      urdTime = (System.nanoTime() - startTime / 1000000);
      waitTime = targetTime - urdTime;

      try {
        Thread.sleep(waitTime);
      } catch (Exception e) {
        // Error Handling
      }
    }
  }

  private void init() {
    running = true;
    image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    g = (Graphics2D) image.getGraphics();

    try {
      background = ImageIO.read(this.getClass().getResource("assets/background.png"));
      System.out.println("background");
    } catch(Exception e) {
      // Check for Errors
      System.out.println(e);
    }

  }

  private void update() {
  }

  private void draw() {
    Graphics g2 = getGraphics();
    g2.drawImage(background, 0, 0, 200, 200, null);
    g2.dispose();
  }

  private void render() {

  }
}
