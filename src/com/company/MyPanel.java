package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class MyPanel extends JPanel implements KeyListener, ActionListener {

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    final int DELAY = 140;
    final int radius = 20;
    int x = 250;
    int y = 250;
    Timer timer;
    Game game = new Game();

    MyPanel(){

        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paint(Graphics g) {

        game.check();
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setPaint(Color.CYAN);

        int snakeLength = game.getLength();

        if(!game.runs)
        {
            g2D.drawString("GAME OVER", 220, 250);
        }

        else {
            g2D.setColor(Color.CYAN);
            ArrayList<Point> points_to_draw = game.getSnake();

            for (int i = 0; i < snakeLength; i++) {
                g2D.drawOval(points_to_draw.get(i).x, points_to_draw.get(i).y, radius, radius);
                g2D.fillOval(points_to_draw.get(i).x, points_to_draw.get(i).y, radius, radius);
            }

            Fruit fruit_to_draw = game.getFruit();

            g2D.setColor(Color.RED);
            g2D.drawOval(fruit_to_draw.x, fruit_to_draw.y, radius, radius);
            g2D.fillOval(fruit_to_draw.x, fruit_to_draw.y, radius, radius);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (game.runs)
            game.run();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyChar()){
            case 'w':
                game.W();
                repaint();
                break;
            case 'a':
                game.A();
                repaint();
                break;
            case 's':
                game.S();
                repaint();
                break;
            case 'd':
                game.D();
                repaint();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
