package by.javatr.task1.util.test;

import by.javatr.task1.util.Ball;
import by.javatr.task1.util.Basket;
import by.javatr.task1.util.Color;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class BasketTest {

    private static Basket basket;

    @BeforeClass
    public static void createTestData() {
        basket = new Basket(new Ball(Color.BLUE, 51.8));
        basket.addBallToBasket(new Ball(Color.BLUE, 4.3));
        basket.addBallToBasket(new Ball(Color.RED, 15.3));
        basket.addBallToBasket(new Ball(Color.WHITE, 7.5));
        basket.addBallToBasket(new Ball(Color.BLUE, 9.3));
        basket.addBallToBasket(new Ball(Color.BLACK, 84.6));
        basket.addBallToBasket(new Ball(Color.YELLOW, 7.5));
        basket.addBallToBasket(new Ball(Color.BLACK, 98.6));
        basket.addBallToBasket(new Ball(Color.RED, 94.8));
        basket.addBallToBasket(new Ball(Color.YELLOW, 5.7));
        basket.addBallToBasket(new Ball(Color.RED, 57.9));
        basket.addBallToBasket(new Ball(Color.BLACK, 74.8));
    }


    @Test
    public void getCountOfBallsTest_Blue_Color() {

        Color color = Color.BLUE;
        int expected = 3;
        int actual = basket.getCountOfBalls(color);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCountOfBallsTest_Red_Color() {

        Color color = Color.RED;
        int expected = 3;
        int actual = basket.getCountOfBalls(color);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCountOfBallsTest_Black_Color() {

        Color color = Color.BLACK;
        int expected = 3;
        int actual = basket.getCountOfBalls(color);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCountOfBallsTest_White_Color() {

        Color color = Color.WHITE;
        int expected = 1;
        int actual = basket.getCountOfBalls(color);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCountOfBallsTest_Yellow_Color() {

        Color color = Color.YELLOW;
        int expected = 2;
        int actual = basket.getCountOfBalls(color);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getWeightOfBallsTest() {

        double expected = 512.1;
        double actual = basket.getWeightOfBalls();

        Assert.assertEquals(expected, actual, .1);

    }

    @Test
    public void addBallToBasketTest_Add_In_Empty_Basket() {

        Ball someBall = new Ball(Color.BLUE, 78.4);

        Basket newBasket = new Basket();
        newBasket.addBallToBasket(someBall);

        Assert.assertEquals(someBall, newBasket.getBalls().get(0));


    }

    @Test
    public void addBallToBasketTest_Add_In_Exist_Basket() {

        Ball firstBall = new Ball(Color.BLUE, 78.4);
        Ball secondBall = new Ball(Color.YELLOW, 7.9);

        Basket newBasket = new Basket(firstBall);
        newBasket.addBallToBasket(secondBall);

        Assert.assertEquals(firstBall, newBasket.getBalls().get(0));
        Assert.assertEquals(secondBall, newBasket.getBalls().get(1));

    }


}
