package com.jango;

import java.awt.*;

public class Player {
  private double x;
  private double y;
  private double dy;
  private double dx;

  private int width;
  private int height;

  private boolean left;
  private boolean right;
  private boolean jumping;
  private boolean falling;

  private double maxSpeed;
  private double moveSpeed;
  private double maxFallingSpeed;
  private double stopSpeed;
  private double jumpStart;
  private double gravity;

  private TileMap tileMap;

  public Player(TileMap tm) {
    tileMap = tm;
    width = 20;
    height = 20;
    moveSpeed = 0.6;
    maxSpeed = 4.2;
    maxFallingSpeed = 12;
    stopSpeed = 0.30;
    jumpStart = -11.0;
    gravity = 0.64;
  }

  public void setLeft(boolean b) {
    left = b;
  }

  public void setRight(boolean b) {
    right = b;
  }

  public void setJumping(boolean b) {
    if (!falling) {
      jumping = true;
    }
  }

  public void update() {

  }

  public void draw(Graphics2D g) {
    int tx = tileMap.getx();
    int ty = tileMap.gety();
    g.setColor(Color.RED);
    g.fillRect(
      (int) (tx + x - width/2),
      (int) (ty + y - height/2),
      width,
      height
    );
  }
}
