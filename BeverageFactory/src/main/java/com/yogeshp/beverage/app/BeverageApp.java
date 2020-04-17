package com.yogeshp.beverage.app;


import com.yogeshp.beverage.app.bootstrap.BeverageLoader;
import com.yogeshp.beverage.app.exception.InvalidOrderException;
import com.yogeshp.beverage.app.factory.BeverageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.Scanner;

/**
 * @author Yogesh Patil
 * Main class which takes an order and invokes Beverage Factory.
 */
public class BeverageApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeverageApp.class);

    public static void main(String[] args) {

        BeverageFactory factory = new BeverageFactory();
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream
        LOGGER.info("Todays Menu Card For Beverage Lovers ::");
        //menu as per problem statement
        Map<Integer , String> menu = BeverageLoader.getMenu();
        menu.entrySet().forEach(m ->LOGGER.info(m.toString()));
        //place an order
        Integer orderNo = placeOrder(sc, menu);
        final double cost = factory.getInvoiceFromOrder(menu.get(orderNo));

        LOGGER.info("Your total cost is ${}", cost);

    }

    private static Integer placeOrder(Scanner sc, Map<Integer, String> menu) {
        LOGGER.info("Enter a Order Number You have selected from the Menu: ");
        Integer orderNo= sc.nextInt();
        switch(orderNo)
        {
            case 1:
                LOGGER.info("You Have Ordered : "+menu.get(orderNo));
                break;
            case 2:
                LOGGER.info("You Have Ordered : "+menu.get(orderNo));
                break;
            case 3:
                LOGGER.info("You Have Ordered : "+menu.get(orderNo));
                break;
            case 4:
                LOGGER.info("You Have Ordered : "+menu.get(orderNo));
                break;
            case 5:
                LOGGER.info("You Have Ordered : "+menu.get(orderNo));
                break;
            default:
                LOGGER.error("You have entered a incorrect order No....");
                throw new InvalidOrderException("Invalid Order Number " +orderNo);
        }
        return orderNo;
    }


}
