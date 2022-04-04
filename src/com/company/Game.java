package com.company;

import java.util.ArrayList;

public class Game {

    Snake snake = new Snake();
    Fruit fruit = new Fruit();
    boolean runs = true;

    public ArrayList<Point> getSnake() {
        return snake.points;
    }
    public Fruit getFruit() { return fruit; }
    public int getLength() { return snake.points.size(); }

    public void check() {
        snake.eat(fruit);
        snake.death();
        if (!snake.lives)
            runs = false;
    }

    public void run() {
        if (snake.left)
            snake.moveLEFT();
        else if (snake.right)
            snake.moveRIGHT();
        else if (snake.up)
            snake.moveUP();
        else if (snake.down)
            snake.moveDOWN();
    }

    public void W() {
        snake.moveUP();
    }
    public void S() {
        snake.moveDOWN();
    }
    public void A() {
        snake.moveLEFT();
    }
    public void D() {
        snake.moveRIGHT();
    }
}
