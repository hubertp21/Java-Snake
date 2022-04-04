package com.company;

public class Fruit {

    int x;
    int y;
    final int max = 480;
    final int min = 20;
    boolean eaten = false;

    Fruit() {
        this.x = (int)(Math.random()*(max-min+1)+min);
        this.y = (int)(Math.random()*(max-min+1)+min);
    }

    public Point getDifference(int x, int y) {

        int difference_x; int difference_y;

        if(x - this.x > 0)
            difference_x = x - this.x;
        else
            difference_x = this.x - x;
        if(y - this.y > 0)
            difference_y = y - this.y;
        else
            difference_y = this.y - y;

        return new Point(difference_x, difference_y);
    }

    public void respawn() {
        x = (int)(Math.random()*(max-min+1)+min);
        y = (int)(Math.random()*(max-min+1)+min);
    }
}
