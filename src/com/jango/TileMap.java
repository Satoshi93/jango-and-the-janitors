package com.jango;

import java.io.*;
import java.awt.*;

public class TileMap {
  private int x;
  private int y;

  private int tileSize;
  private int[][] map;
  private int mapWidth;
  private int mapHeight;

  // Constructor
  public TileMap(String s, int tileSize) {
    this.tileSize = tileSize;

    try {
      BufferedReader br = new BufferedReader(new FileReader(s));
      // Parse the first two lines and get the width and height
      mapWidth = Integer.parseInt(br.readLine());
      mapHeight = Integer.parseInt(br.readLine());
      map = new int[mapHeight][mapWidth];

      // Whitespaces
      String delimiters = " ";

      for (int row=0; row < mapHeight; row++) {
        String line = br.readLine();
        System.out.println(line);
        // Split each line by delimiters
        String[] tokens = line.split(" ");
        // Fill the array with the parsed tokens
        for (int column=0; column < mapWidth; column++) {
          map[row][column] = Integer.parseInt(tokens[column]);
        }
      }
    } catch(Exception e) {
      System.out.println(e);
    }
  }

  public void update() {

  }

  public void draw(Graphics2D g) {
    for (int row=0; row < mapHeight; row++) {
      for (int column=0; column < mapWidth; column++) {
        int rc = map[row][column];

        // assign token graphic
        if (rc == 0) {
          g.setColor(Color.BLACK);
        }
        if (rc == 1) {
          g.setColor(Color.WHITE);
        }

        g.fillRect(x + column*tileSize, y + row*tileSize, tileSize, tileSize);
      }
    }
  }
}
