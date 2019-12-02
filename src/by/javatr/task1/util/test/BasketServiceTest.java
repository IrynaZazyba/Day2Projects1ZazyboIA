package by.javatr.task1.util.test;

import by.javatr.task1.exception.BasketSizeExceededException;
import by.javatr.task1.exception.NegativeWeightException;
import by.javatr.task1.exception.NoSuchProductInBasketException;
import by.javatr.task1.util.entity.Ball;
import by.javatr.task1.util.entity.Basket;
import by.javatr.task1.util.entity.Color;
import by.javatr.task1.util.service.BallService;
import by.javatr.task1.util.service.BasketService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class BasketServiceTest {

    private static Basket basket;
    private static BasketService basketService;
    private static BallService ballService;

    @BeforeClass
    public static void createTestData() throws NegativeWeightException, BasketSizeExceededException {
        basketService = new BasketService();
        ballService=new BallService();
        basket = basketService.createBasket();

        basketService.addProductToBasket(basket, ballService.createBall(Color.BLUE,4.5));
        basketService.addProductToBasket(basket, ballService.createBall(Color.RED, 15.3));
        basketService.addProductToBasket(basket, ballService.createBall(Color.WHITE, 7.5));
        basketService.addProductToBasket(basket, ballService.createBall(Color.BLUE, 9.3));
        basketService.addProductToBasket(basket, ballService.createBall(Color.BLACK, 87.6));
        basketService.addProductToBasket(basket, ballService.createBall(Color.YELLOW, 7.5));
        basketService.addProductToBasket(basket, ballService.createBall(Color.BLACK, 97.6));
        basketService.addProductToBasket(basket, ballService.createBall(Color.RED,94.8));
        basketService.addProductToBasket(basket, ballService.createBall(Color.YELLOW,5.7));
        basketService.addProductToBasket(basket, ballService.createBall(Color.BLACK,57.9));
        basketService.addProductToBasket(basket, ballService.createBall(Color.BLACK,74.8));

    }


    @Test
    public void addProductToBasketTest() throws NegativeWeightException,BasketSizeExceededException {

        Ball someBall = new Ball(Color.BLUE, 78.4);

        basketService.addProductToBasket(basket, someBall);

        Assert.assertTrue(basketService.getAllProductsFromBasket(basket).contains(someBall));

    }


    @Test
    public void removeProductFromBasketTest_Remove_Exist_Ball() throws NegativeWeightException,BasketSizeExceededException{

        Ball someBall = new Ball(Color.BLUE, 4.5);
        basketService.addProductToBasket(basket, someBall);

        basketService.removeProductFromBasket(basket, someBall);

        Assert.assertTrue(basketService.getAllProductsFromBasket(basket).contains(someBall));
    }

    @Test
    public void removeProductFromBasketTest_Remove_Not_Exist_Ball() throws NegativeWeightException {

        Ball someBall = new Ball(Color.BLUE, 9.7);

        basketService.removeProductFromBasket(basket, someBall);

        Assert.assertFalse(basketService.getAllProductsFromBasket(basket).contains(someBall));
    }

    @Test
    public void createBasketTest() {

        Basket newBasket = basketService.createBasket();

        Assert.assertTrue(newBasket != null);
    }

    @Test
    public void getProductFromBasketTest() throws NoSuchProductInBasketException, NegativeWeightException {

        Ball expectedBall=ballService.createBall(Color.BLUE,4.5);
        Ball actualBall=(Ball)basketService.getProductFromBasket(basket,expectedBall);

        Assert.assertEquals(expectedBall,actualBall);

    }

    @Test(expected = NoSuchProductInBasketException.class)
    public void getBallFromBasketTest_No_Product() throws NoSuchProductInBasketException, NegativeWeightException {

        Ball expectedBall=ballService.createBall(Color.BLUE,4.1);
        Ball actualBall=(Ball)basketService.getProductFromBasket(basket,expectedBall);

    }


    @Test
    public void getWeightOfBallsTest() {

        double expected = 462.5;
        double actual = basketService.getWeightOfBalls(basket);

        Assert.assertEquals(expected, actual, .1);

    }

    @Test
    public void getCountOfBallsTest_Blue_Color() {

        Color color = Color.BLUE;
        int expected = 2;
        int actual = basketService.getCountOfBalls(basket,color);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCountOfBallsTest_Red_Color() {

        Color color = Color.RED;
        int expected = 2;
        int actual = basketService.getCountOfBalls(basket,color);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCountOfBallsTest_Black_Color() {

        Color color = Color.BLACK;
        int expected = 4;
        int actual = basketService.getCountOfBalls(basket,color);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCountOfBallsTest_White_Color() {

        Color color = Color.WHITE;
        int expected = 1;
        int actual = basketService.getCountOfBalls(basket,color);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCountOfBallsTest_Yellow_Color() {

        Color color = Color.YELLOW;
        int expected = 2;
        int actual = basketService.getCountOfBalls(basket,color);

        Assert.assertEquals(expected, actual);

    }




}
