package com.yogeshp.beverage.app.exception;

/**
 * @author Yogesh Patil
 * Thrown when duplicate ingredient gets added in the order.
 */
public class DuplicateIngredientException extends RuntimeException {
    public DuplicateIngredientException(String errorMessage) {
        super(errorMessage);
    }
}
