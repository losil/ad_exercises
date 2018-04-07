package ch.hslu.ad.sw05.ex04;

import java.awt.*;
import java.util.Random;

public class Ball implements Runnable {

    private int x, y;
    private int diameter;
    private int rateOfFall;
    private Color color;
    private boolean isAlive;

    public Ball(final int x, final int y) {
        this.x = x;
        this.y = y;
        this.diameter = new Random().nextInt(50 - 20 + 1) + 20;
        this.generateRandomColor();
        this.setRateOfFall();
    }

    private void generateRandomColor() {
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        this.color = new Color(r, g, b);
    }

    private void setRateOfFall() {
        this.rateOfFall = new Random().nextInt(10 - 1 + 1) + 1;

    }

    private int getRateOfFall() {
        return this.rateOfFall;
    }

    public int getX() {
        return this.x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getDiameter() {
        return this.diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    @Override
    public void run() {
        this.isAlive = true;
        int end = 398 - getDiameter();
        for (int i = this.y; i < end; i++) {
            this.y = i;
            try {
                Thread.sleep(this.rateOfFall);
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
        while (this.color.getRGB() != -1) {
            this.color = this.color.brighter();
            try {
                Thread.sleep(500);
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
        this.isAlive = false;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
