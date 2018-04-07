package ch.hslu.ad.sw05.ex04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

public class SwingGui extends JFrame implements Runnable {

    private ArrayList<Ball> balls;

    public SwingGui() throws HeadlessException {
        super("Ball Game");

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        this.add(panel);
        this.pack();
        balls = new ArrayList<>();

        panel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //printBall(e.getX(), e.getY());

            }

            @Override
            public void mousePressed(MouseEvent e) {
                printBall(e.getX(), e.getY());

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        panel.setDoubleBuffered(true);
        this.setSize(600, 400);
        this.setVisible(true);
        Thread t = new Thread(this);
        t.start();

    }

    private void printBall(final int x, final int y) {
        Ball b = new Ball(x, y);
        Thread t = new Thread(b);
        t.start();
        balls.add(b);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Iterator<Ball> iterator = balls.iterator();
        while (iterator.hasNext()) {
            Ball ball = iterator.next();
            if (!ball.isAlive()) {
                iterator.remove();
            }

            g.setColor(ball.getColor());
            g.fillArc(ball.getX(), ball.getY(), ball.getDiameter(), ball.getDiameter(), 0, 360);
        }
    }

    @Override
    public void run() {
        while (true) {
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException iex) {
                iex.printStackTrace();
            }
        }
    }
}
