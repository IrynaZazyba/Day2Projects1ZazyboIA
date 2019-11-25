package by.javatr.task1.runner;

import by.javatr.task1.util.Ball;
import by.javatr.task1.util.Basket;
import by.javatr.task1.util.Color;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {

        try {
            Basket basket = new Basket(new Ball(Color.BLUE, 50.8));  /*создание корзины через конструктор с параметром*/
            basket.addBallToBasket(new Ball(Color.BLUE, 40.3));      /*добавление мячей с помощью метода*/
            basket.addBallToBasket(new Ball(Color.RED, 15.3));
            basket.addBallToBasket(new Ball(Color.WHITE, 17.5));
            basket.addBallToBasket(new Ball(Color.BLUE, 91.3));

            Color color = Color.BLUE;

            System.out.println("Вес мячей в корзине: " + basket.getWeightOfBalls());
            System.out.println("Количество мячей цвета " + color.name() + ": " + basket.getCountOfBalls(color));

            ArrayList<Ball> balls = new ArrayList<>();                      /*создание набора мячей*/
            balls.add(new Ball(Color.BLUE, 7.5));
            balls.add(new Ball(Color.BLUE, 8.5));
            balls.add(new Ball(Color.BLACK, 57.5));
            balls.add(new Ball(Color.YELLOW, 7.5));
            balls.add(new Ball(Color.BLUE, 17.9));
            balls.add(new Ball(Color.BLUE, 71.3));
            balls.add(new Ball(Color.BLUE, 19.5));


            Basket newBasket = new Basket(balls);                          /*создание корзины через коснструктор принимающий набор мячей*/

            Color newColor = Color.BLUE;

            System.out.println("\nВес мячей в корзине: " + newBasket.getWeightOfBalls());
            System.out.println("Количество мячей цвета " + newColor.name() + ": " + newBasket.getCountOfBalls(newColor));

        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
