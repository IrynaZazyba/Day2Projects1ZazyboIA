package by.javatr.task1.util.service;

import by.javatr.task1.exception.NoSuchProductInBasketException;
import by.javatr.task1.util.entity.Ball;
import by.javatr.task1.util.entity.Color;
import by.javatr.task1.util.entity.ProductInterface;
import by.javatr.task1.util.entity.Basket;

import java.util.Collection;

public class BasketService {


    public Basket createBasket() {
        return new Basket();
    }

    public String addProductsToBasket(Basket basket, ProductInterface... p) {
        int count = 0;
        for (int i = 0; i < p.length; i++) {
            if (basket.addToBasket(p[i])) {
                ++count;
            }
        }
        return  count>1? count+" products added.":count +" product added.";
    }

    public String addProductToBasket(Basket basket, ProductInterface product) {
        if (basket.addToBasket(product)) {
            return "Product added successfully.";
        }
        return "Basket is full.";
    }

    public String removeProductFromBasket(Basket basket, ProductInterface product) {
        if (basket.removeFromBasket(product)) {
            return "Product removed.";
        }
        return "Product wasn't remove.";
    }


    public ProductInterface getProductFromBasket(Basket basket, ProductInterface product) throws NoSuchProductInBasketException {
        Collection<ProductInterface> products = basket.getProducts();

        if (products.contains(product)) {
            for (ProductInterface p : products
            ) {
                if (product.equals(p)) return product;
            }

        }
        throw new NoSuchProductInBasketException("No such product!");
    }


    public Collection<ProductInterface> getAllProductsFromBasket(Basket basket) {
        return basket.getProducts();
    }

    public int getCountOfBalls(Basket basket, Color color) {

        int count = 0;

        for (ProductInterface p : basket.getProducts()) {
            if (p.getClass() == Ball.class) {
                Ball ball = (Ball) p;
                if (ball.getColor() == color) {
                    count++;
                }
            }
        }
        return count;
    }


    public double getWeightOfBalls(Basket basket) {

        double weight = 0.0;
        for (ProductInterface p : basket.getProducts()) {
            if (p.getClass() == Ball.class) {
                Ball ball = (Ball) p;
                weight += ball.getWeight();
            }

        }
        return weight;
    }

}
