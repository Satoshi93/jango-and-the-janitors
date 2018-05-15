package com.jango;

import javax.swing.JPanel;

import com.jango.GameStateManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable, KeyListener {
  public static final int WIDTH = 320;
  public static final int HEIGHT = 240;
  public static final int SCALE = 3;

  private Thread thread;
  private boolean running;

  private BufferedImage image;
  private BufferedImage background;
  private BufferedImage run_1;
  private BufferedImage run_2;
  private BufferedImage jump;
  private BufferedImage stand_1;
  private BufferedImage stand_2;
  private Graphics2D g;


	private int FPS = 60;
	private long targetTime = 1000 / FPS;

  private GameStateManager gsm;

  private TileMap tileMap;
  private FileReader rf;

  private Player player;

  public GamePanel() {
    super();
    setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
    setFocusable(true);
    requestFocus();
  }

  public void addNotify() {
    super.addNotify();
    if (thread == null) {
      thread = new Thread(this);
      addKeyListener(this);
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
			draw();
			drawToScreen();
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

    gsm = new GameStateManager();
  }

  private void update() {
    gsm.update();
  }

  private void draw() {
    gsm.draw(g);
  }

  private void drawToScreen() {
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0,
				WIDTH * SCALE, HEIGHT * SCALE,
				null);
		g2.dispose();
  }

	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {
		gsm.keyPressed(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key) {
		gsm.keyReleased(key.getKeyCode());
	}
}
