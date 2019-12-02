package by.javatr.task1.runner;

import by.javatr.task1.exception.BasketSizeExceededException;
import by.javatr.task1.exception.NegativeWeightException;
import by.javatr.task1.exception.NoSuchProductInBasketException;
import by.javatr.task1.util.entity.Basket;
import by.javatr.task1.util.entity.Color;
import by.javatr.task1.util.entity.ProductInterface;
import by.javatr.task1.util.service.BallService;
import by.javatr.task1.util.service.BasketService;


public class Runner {
    public static void main(String[] args) {

       try {

           BasketService basketService=new BasketService();
           BallService ballService=new BallService();
           Basket basket=basketService.createBasket();

           basketService.addProductToBasket(basket,ballService.createBall(Color.BLUE,5.3));
           basketService.addProductToBasket(basket,ballService.createBall(Color.RED,8.4));
           basketService.addProductToBasket(basket,ballService.createBall(Color.YELLOW,7.8));
           basketService.addProductToBasket(basket,ballService.createBall(Color.BLUE,5.5));
           basketService.addProductToBasket(basket,ballService.createBall(Color.BLUE,3.8));

           Color color=Color.BLUE;

           System.out.println("Корзина: ");
           System.out.println("Вес мячей в корзине: " + basketService.getWeightOfBalls(basket));
           System.out.println("Количество мячей цвета " + color.name() + ": " + basketService.getCountOfBalls(basket,color));

           ProductInterface product=basketService.getProductFromBasket(basket,ballService.createBall(Color.BLUE,5.3));
           basketService.removeProductFromBasket(basket,product);

           System.out.println("\nКорзина после удаления элемента: ");
           System.out.println("Вес мячей в корзине: " + basketService.getWeightOfBalls(basket));
           System.out.println("Количество мячей цвета " + color.name() + ": " + basketService.getCountOfBalls(basket,color));


        } catch (NegativeWeightException | NoSuchProductInBasketException | BasketSizeExceededException ex) {
           System.out.println(ex.getMessage());
        }
    }
}
