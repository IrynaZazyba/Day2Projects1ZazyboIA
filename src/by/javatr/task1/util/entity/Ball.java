package by.javatr.task1.util.entity;

import by.javatr.task1.exception.NegativeWeightException;
import by.javatr.task1.validator.Validator;

public class Ball implements ProductInterface {

    private final String TITLE = "Ball";

    private final Color color;
    private final double weight;

    public Ball() {
        this.color = Color.BLUE;
        this.weight = 1;
    }

    public Ball(Color color, double weight) throws NegativeWeightException {
        if (!Validator.validatePositiveDouble(weight)) {
            throw new NegativeWeightException("Weight should be positive number.");
        }
        this.weight = weight;
        this.color = color;
    }


    public Color getColor() {
        return color;
    }


    public double getWeight() {
        return weight;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ball ball = (Ball) obj;
        if (Double.doubleToLongBits(weight) !=
                Double.doubleToLongBits(ball.getWeight()))
            return false;
        if (color == null) {
            if (ball.color != null)
                return false;
        } else if (!color.equals(ball.color))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + TITLE.hashCode();
        result = prime * result + Double.valueOf(weight).hashCode();
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@"
                + "TITLE=" + TITLE + ", color=" + color + ", weight=" + weight;
    }

    @Override
    public String getTitle() {
        return TITLE;
    }
}
