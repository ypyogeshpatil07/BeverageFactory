package com.yogeshp.beverage.app.factory;

import com.yogeshp.beverage.app.bootstrap.BeverageLoader;
import com.yogeshp.beverage.app.exception.DuplicateIngredientException;
import com.yogeshp.beverage.app.exception.IllegalIngredientsException;
import com.yogeshp.beverage.app.exception.InvalidOrderException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Yogesh Patil
 * Bevrage Factory class provides customized order with invoiced price.
 */

public class BeverageFactory {

    //      This stores the combination of Items with allowed exclusions
    Map<String, List<String>> beveragesStock = BeverageLoader.getBeveragesMap();

    //      This stores the price of Items
    Map<String, Double> itemRates = BeverageLoader.getItemRates();

    //      This stores the price of exclusions
    Map<String, Double> ingredientRates = BeverageLoader.getIngredientRates();

    //      get cost of each item in order and total them
    public double getFinalCostForSelectedOrder(String order) {
        double cost = 0.0d;
        List<String> orderItems = getItemsFromOrder(order.trim());
        for (String item : orderItems) {
            List<String> itemWithIngredients = getIngredientFromItem(item);
            //validation of the item
            validateOrder(item);
            cost = cost + calculateInvoice(itemWithIngredients);
        }
        return cost;
    }

    //     if ordered item not present in BeverageLoader or empty order returns false
    private void validateOrder(String item) {
        List<String> itemIngredients = getIngredientFromItem(item);

        //case: if order does not contains valid menu item
        if (!beveragesStock.containsKey(itemIngredients.get(0)))
            throw new InvalidOrderException("Invalid item ordered -> " + item + " .Order again with valid menu item..!!");

        List<String> allIngredients = beveragesStock.get(itemIngredients.get(0)); // Beverage name is always at index 0
        // check to ensure items are there in list

        // case: when duplicate ingredients are present in order like Chai,  -water,-water, Coffee, Mojito
        Optional<String> duplicateIngredient = itemIngredients.stream().filter(i -> Collections.frequency(itemIngredients, i) > 1).findFirst();
        if (duplicateIngredient.isPresent())
            throw new DuplicateIngredientException("Duplicate ingredient not allowed -> " + duplicateIngredient.get());

        List<String> ingredients = itemIngredients.subList(1, itemIngredients.size());
        boolean validIngredients = ingredients.stream().allMatch(t -> allIngredients.stream().anyMatch(t::contains));

        // it checks if an invalid ingredient is passed to the order
        if (!validIngredients)
            throw new IllegalIngredientsException("Invalid ingredient in order.Please check and order again..!!");

        // order has no typo, now check if all ingredients are not excluded in an order
        // logic is to compare the order items and { (total exclusions + 1) +1} for main including main item,
        if (itemIngredients.size() == allIngredients.size() + 1)
            throw new InvalidOrderException("Invalid Order..!! You cannot exclude all items from " + item);

    }

    //     get Item and exclusion prices from DataLoader and return cost for each item in order
    private Double calculateInvoice(List<String> itemWithIngredients) {
        Double itemValue = itemRates.get(itemWithIngredients.get(0));
        Double ingredientsValue = 0.0d;
        if (itemWithIngredients.size() > 1)
            for (int i = 1; i < itemWithIngredients.size(); i++) {
                ingredientsValue = ingredientsValue + ingredientRates.get(itemWithIngredients.get(i));
            }
        return itemValue - ingredientsValue;
    }

    //     this returns a List which has order with exclusions at each index, all in Lower cases
    private List<String> getItemsFromOrder(String order1) {
        return Arrays.stream(order1.split("(?!,\\s*-),")).map(String::trim).map(String::toLowerCase).collect(Collectors.toList());
    }

    //     Similar to getItemsFromOrder(), but this replaces '-' from the order
    private List<String> getIngredientFromItem(String item) {
        return Arrays.stream(item.split(",")).map(s -> s.replace("-", "")).map(String::trim).collect(Collectors.toList());
    }

}
