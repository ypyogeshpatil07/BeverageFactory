package com.yogeshp.beverage.app.exception;

/**
 * @author Yogesh Patil
 * Thrown when some exclued ingredients is added in the order.
 */
public class IllegalIngredientsException extends RuntimeException {
    public IllegalIngredientsException(String message) {
        super(message);
    }
}
