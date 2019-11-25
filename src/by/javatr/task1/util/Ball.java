package by.javatr.task1.util;

import by.javatr.task1.validator.Validator;

public class Ball {

    private Color color;
    private double weight;

    public Ball(Color color, double weight) {
        if (Validator.validatePositiveDouble(weight)) {
            this.color = color;
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Weight should be positive number!");
        }
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
        if (weight != ball.getWeight())
            return false;
        if (color != ball.getColor())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime=31;
        int result=1;
        result=prime*result+Double.valueOf(weight).hashCode();
        result=prime*result+color.hashCode();
        return result;
    }
}
