package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Snake implements Eat, Move, Death {

    ArrayList<Point> points = new ArrayList<Point>();
    Point head = new Point(250, 250);
    final int radius = 20;
    boolean lives = true;
    boolean up = true; boolean down = false; boolean left = false; boolean right = false;
    int score = 0;

    public Snake() {
        for(int i = 0; i < 3; i++)
        {
            this.points.add(i, new Point(250, 250+i*radius));
        }
    }

    public Point getLast() {
        return new Point(points.get(points.size()-1).x, points.get(points.size()-1).y);
    }

    public void eat(Fruit fruit){

        int difference_x = fruit.getDifference(head.x, head.y).x; int difference_y = fruit.getDifference(head.x, head.y).y;

        if(difference_x < radius && difference_y < radius){
            fruit.respawn();

            Point last = getLast();

            if(up){
                last.y += radius;
                points.add(points.size(), last);
            }
            else if(down){
                last.y -= radius;
                points.add(points.size(), last);
            }
            else if(left){
                last.x += radius;
                points.add(points.size(), last);
            }
            else if(right){
                last.x -= radius;
                points.add(points.size(), last);
            }
            score++;
        }
    }

    public void death(){

        if(head.x + radius > 500 || head.x - radius < 0 || head.y + radius > 500 || head.y - radius < 0)
        {
            lives = false;
        }

        for(int i = 2; i < points.size(); i++)
        {
            if (head.x == points.get(i).x && head.y == points.get(i).y) {
                lives = false;
                break;
            }
        }
    }

    public void moveUP() {
        up = true; down = false; left = false; right = false;
        Point tempW = points.get(0);
        points.set(0, new Point(tempW.x, tempW.y-radius));
        head = points.get(0);

        for (int i = 1; i < points.size(); i++) {
            Point last = points.get(i);
            points.set(i, tempW);
            tempW = last;
        }
    }

    public void moveLEFT(){
        left = true; up = false; down = false; right = false;
        Point tempA = points.get(0);
        points.set(0, new Point(tempA.x-radius, tempA.y));
        head = points.get(0);

        for(int i = 1; i < points.size(); i++)
        {
            Point last = points.get(i);
            points.set(i, tempA);
            tempA = last;
        }
    }

    public void moveDOWN(){
        down = true; up = false; left = false; right = false;
        Point tempS = points.get(0);
        points.set(0, new Point(tempS.x, tempS.y+radius));
        head = points.get(0);

        for(int i = 1; i < points.size(); i++)
        {
            Point last = points.get(i);
            points.set(i, tempS);
            tempS = last;
        }
    }

    public void moveRIGHT(){
        right = true; up = false; down = false; left = false;
        Point tempS = points.get(0);
        points.set(0, new Point(tempS.x+radius, tempS.y));
        head = points.get(0);

        for(int i = 1; i < points.size(); i++)
        {
            Point last = points.get(i);
            points.set(i, tempS);
            tempS = last;
        }
    }
}
