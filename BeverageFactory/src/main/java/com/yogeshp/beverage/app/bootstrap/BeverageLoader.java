package com.yogeshp.beverage.app.bootstrap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yogesh Patil
 * It Loads all the prices and combinations of the bevrages.
 */
public class BeverageLoader {
    // String constants for shop items
    private static final String CHAI = "chai";
    private static final String BANANA_SMOOTHIE = "banana smoothie";
    private static final String STRAWBERRY_SHAKE = "strawberry shake";
    private static final String MOJITO = "mojito";

    // String constants for ingredients
    private static final String SUGAR = "sugar";
    private static final String WATER = "water";
    private static final String COFFEE = "coffee";
    private static final String MILK = "milk";
    private static final String SODA = "soda";
    private static final String MINT = "mint";

    // Price constants for base ingredients
    private static final Double STRAWBERRIES_PRICE = 5.0d;
    private static final Double BANANA_PRICE = 4.0d;
    private static final Double TEA_LEAVES_PRICE = 2.0d;
    private static final Double COFFEE_BEANS_PRICE = 3.0d;
    private static final Double LEMON_PRICE = 5.5d;


    private BeverageLoader() {
    }

    public static Map<String, List<String>> getBeveragesMap() {

        Map<String, List<String>> beveragesMap = new HashMap<>();
        beveragesMap.put(COFFEE, Arrays.asList(MILK, SUGAR, WATER));
        beveragesMap.put(CHAI, Arrays.asList(MILK, SUGAR, WATER));
        beveragesMap.put(BANANA_SMOOTHIE, Arrays.asList(MILK, SUGAR, WATER));
        beveragesMap.put(STRAWBERRY_SHAKE, Arrays.asList(WATER, MILK, SUGAR));
        beveragesMap.put(MOJITO, Arrays.asList(SUGAR, WATER, SODA, MINT));
        return beveragesMap;
    }

    public static Map<String, Double> getItemRates() {

        Map<String, Double> itemRates = new HashMap<>();

        itemRates.put(COFFEE, COFFEE_BEANS_PRICE + getIngredientRates().get(MILK)
                + getIngredientRates().get(WATER) + getIngredientRates().get(SUGAR));

        itemRates.put(CHAI, TEA_LEAVES_PRICE + +getIngredientRates().get(MILK)
                + getIngredientRates().get(WATER) + getIngredientRates().get(SUGAR));

        itemRates.put(BANANA_SMOOTHIE, BANANA_PRICE + getIngredientRates().get(MILK)
                + getIngredientRates().get(WATER) + getIngredientRates().get(SUGAR));

        itemRates.put(STRAWBERRY_SHAKE, STRAWBERRIES_PRICE + getIngredientRates().get(MILK)
                + getIngredientRates().get(WATER) + getIngredientRates().get(SUGAR));

        itemRates.put(MOJITO, LEMON_PRICE + getIngredientRates().get(SODA)
                + getIngredientRates().get(WATER) + getIngredientRates().get(SUGAR)
                + getIngredientRates().get(MINT));


        return itemRates;
    }

    public static Map<String, Double> getIngredientRates() {

        Map<String, Double> ingredientRates = new HashMap<>();
        ingredientRates.put(MILK, 1.0d);
        ingredientRates.put(SUGAR, 0.5d);
        ingredientRates.put(SODA, 0.5d);
        ingredientRates.put(MINT, 0.5d);
        ingredientRates.put(WATER, 0.5d);

        return ingredientRates;
    }

    public  static Map<Integer , String> getMenu(){
        Map<Integer ,String> menu= new HashMap<>();
        //valid orders as per problem statement
        menu.put(1 , "Chai, -sugar");
        menu.put(2, "Chai, -sugar, -milk");
        menu.put(3, "Chai");
        menu.put(4, "chai , -sugar , chai , coffee , -milk");
        menu.put(5,"Chai ,-milk, -water,  Coffee, Mojito");//extra order added
        return menu;
    }


}

