package by.javatr.task1.util.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class Basket {

    private final int MAX_SIZE = 100;

    private Collection<ProductInterface> products;

    public Basket() {
        this.products = new ArrayList<>();
    }

    public Collection<ProductInterface> getProducts() {
        return Collections.unmodifiableCollection(products);
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public boolean addToBasket(ProductInterface product)  {

        if (products.size() > MAX_SIZE) {
            return false;
        }
        if (product != null) {
            return this.products.add(product);
        }
        return true;
    }

    public boolean removeFromBasket(ProductInterface product) {
        if (product != null&&products.contains(product)) {
           return products.remove(product);
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Basket basket = (Basket) obj;
        if (!this.products.equals(basket.products))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + MAX_SIZE;
        for (ProductInterface p : products
        ) {
            result = prime * result + p.hashCode();
        }
        return result;
    }


    @Override
    public String toString() {
        return getClass().getName() + "@"
                + "MAX_SIZE=" + MAX_SIZE
                + ", products=" + products;
    }
}
