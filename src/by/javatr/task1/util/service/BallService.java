package by.javatr.task1.util.service;

import by.javatr.task1.exception.NegativeWeightException;
import by.javatr.task1.util.entity.Color;
import by.javatr.task1.util.entity.Ball;

public class BallService {

    public Ball createBall(Color color, double weight) throws NegativeWeightException {
        return new Ball(color, weight);
    }
}


