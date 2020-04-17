package com.yogeshp.beverage.app.exception;

/**
 * @author Yogesh Patil
 *  Thrown when all the ingredients are excluded from an item in order
 */
public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String errorMessage) {
        super(errorMessage);
    }
}
