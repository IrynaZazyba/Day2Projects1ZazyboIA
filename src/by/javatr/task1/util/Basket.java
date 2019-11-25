package by.javatr.task1.util;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Ball> balls;

    public Basket() {
    }

    public Basket(Ball ball) {
        balls = new ArrayList<>();
        balls.add(ball);
    }

    public Basket(ArrayList<Ball> balls) {

        this.balls = balls;
    }

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public void addBallToBasket(Ball ball) {
        if(balls==null){
            balls=new ArrayList<>();
        }
        this.balls.add(ball);
    }

    public int getCountOfBalls(Color color) {

        int count = 0;

        for (Ball ball : balls) {
            if (ball.getColor() == color) {

                count++;
            }
        }
        return count;
    }

    public double getWeightOfBalls() {

        double weight = 0.0;

        for (Ball ball : this.balls) {
            weight += ball.getWeight();
        }

        return weight;
    }

}
