package by.javatr.task1.util.test;


import by.javatr.task1.exception.BasketSizeExceededException;
import by.javatr.task1.exception.NegativeWeightException;
import by.javatr.task1.util.entity.Ball;
import by.javatr.task1.util.service.BallService;
import by.javatr.task1.util.entity.Basket;
import by.javatr.task1.util.service.BasketService;
import by.javatr.task1.util.entity.Color;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BallServiceTest {

    private static Basket basket;
    private static BasketService basketService;
    private static BallService ballService;

    @BeforeClass
    public static void createTestData() throws NegativeWeightException, BasketSizeExceededException {
        basketService = new BasketService();
        ballService = new BallService();
        basket = basketService.createBasket();

        basketService.addProductToBasket(basket, ballService.createBall(Color.BLUE, 4.3));
        basketService.addProductToBasket(basket, ballService.createBall(Color.RED, 15.3));
        basketService.addProductToBasket(basket, ballService.createBall(Color.WHITE, 7.5));
        basketService.addProductToBasket(basket, ballService.createBall(Color.BLUE, 9.3));
        basketService.addProductToBasket(basket, ballService.createBall(Color.YELLOW, 84.6));
        basketService.addProductToBasket(basket, ballService.createBall(Color.YELLOW, 7.5));
        basketService.addProductToBasket(basket, ballService.createBall(Color.BLUE, 98.6));
        basketService.addProductToBasket(basket, ballService.createBall(Color.RED, 94.8));
        basketService.addProductToBasket(basket, ballService.createBall(Color.YELLOW, 5.7));
        basketService.addProductToBasket(basket, ballService.createBall(Color.RED, 57.9));
        basketService.addProductToBasket(basket, ballService.createBall(Color.BLACK, 74.8));

    }


    @Test
    public void createBallTest() throws NegativeWeightException {

        Color expectedColor = Color.BLUE;
        double expectedWeight = 4.5;

        Ball ball = ballService.createBall(expectedColor,expectedWeight);

        Color actualColor = ball.getColor();
        double actualWeight = ball.getWeight();

        Assert.assertEquals(expectedColor,actualColor);
        Assert.assertEquals(expectedWeight,actualWeight,.1);

    }

    @Test(expected = NegativeWeightException.class)
    public void createBallTest_Negative_Weight() throws NegativeWeightException {

        ballService.createBall(Color.BLUE,-4.5);

    }

}


