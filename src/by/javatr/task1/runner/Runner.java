package by.javatr.task1.runner;

import by.javatr.task1.exception.NegativeWeightException;
import by.javatr.task1.exception.NoSuchProductInBasketException;
import by.javatr.task1.util.entity.Ball;
import by.javatr.task1.util.entity.Basket;
import by.javatr.task1.util.entity.Color;
import by.javatr.task1.util.entity.ProductInterface;
import by.javatr.task1.util.service.BallService;
import by.javatr.task1.util.service.BasketService;


public class Runner {
    public static void main(String[] args) {

        try {

            BasketService basketService = new BasketService();
            BallService ballService = new BallService();
            Basket basket = basketService.createBasket();

            Ball b1 = ballService.createBall(Color.BLUE, 5.3);
            Ball b2 = ballService.createBall(Color.RED, 8.4);
            Ball b3 = ballService.createBall(Color.YELLOW, 7.8);
            Ball b4 = ballService.createBall(Color.BLUE, 5.5);
            Ball b5 = ballService.createBall(Color.BLUE, 3.8);

            System.out.println(basketService.addProductsToBasket(basket, b1, b2, b3, b4, b5));

            Color color = Color.BLUE;

            System.out.println("Basket: ");
            System.out.println("Weight of balls in the basket: " + basketService.getWeightOfBalls(basket));
            System.out.println("Number of " + color.name() + " balls: " + basketService.getCountOfBalls(basket, color));

            ProductInterface product = basketService.getProductFromBasket(basket, ballService.createBall(Color.BLUE, 5.3));
            basketService.removeProductFromBasket(basket, product);

            System.out.println("\nBasket after deleting some product: ");
            System.out.println("Weight of balls in the basket: " + basketService.getWeightOfBalls(basket));
            System.out.println("Number of " + color.name() + " balls: " + ": " + basketService.getCountOfBalls(basket, color));


        } catch (NegativeWeightException | NoSuchProductInBasketException ex) {
            System.out.println(ex.getMessage());
        } catch (UnsupportedOperationException ex) {
            System.out.println("You can't modify the basket!");
        }

    }
}
