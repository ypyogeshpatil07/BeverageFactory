# Project Title - BeverageFactory
# Description
It is a simple java application which calculates the cost of items ordered as per problem statement mentioned at the end.

#Validation & Exception Handling
If order string contains invalid input appropriate exceptions will be thrown by the program.

## Getting Started

Just clone this project from github and import it.

### Prerequisites
Java 1.8 or more and maven
 
### Running Application

Go to BeverageApp.java in package "com.yogeshp.beverage.app", there will be a String order,
copy your order in this and run the program as Java application.
     
       
### Running Test cases
Go to BeverageAppTest in package "com.yogeshp.beverage.test" and run by right click and Run'All Test' or Ctrl+Shift+F10(in IntelliJ)

## Example Input
First it will show the Menu with order No and menu item as per problem statement.
The order to be placed to the shop is always a String concatenated by exclusions.
1. &quot;Chai, -sugar&quot;
2. &quot;Chai, -sugar, -milk&quot;
3. &quot;Chai&quot;
4. [&quot;Chai, -sugar&quot;, &quot;Chai&quot;, &quot;Coffee, -milk&quot;] <br />
// Chai and Tea are menu items
are all valid orders.

Customer just need to select order No.

## Example Output
Your total cost will be calculated as per your order placed.


## Problem Statement
Beverage Factory:
We are the owners of a beverage factory which serves a variety of drinks, juices etc to the customers
from its pre-defined set of menu Items.
We offer the customers a choice to customize their drinks in case they want to avoid some specific
ingredients from their drinks,
e.g. a person ordering &quot;Chai Latte&quot; which has ingredients as &quot;tea leaves, milk, water, sugar,
condiments&quot; a person can order a chai latter without sugar and condiments.
The order value is recalculated based on the actual price of the menu minus the price of the
removed ingredient.
So if 1 Cup Chai costed 5 $ and sugar costed 0.5 $ and milk costed 1$ the order: &quot;Chai, - sugar, -milk&quot;
would charge
5 - 0.5 - 1.0=3.5$ for the order.

As a part of this exercise you have to write a program should be able to compute the total price of
the order placed. Remember the order can only be a String.

Below are the Menu Items with their respective ingredients and prices:<br />
Coffee: &quot;Coffee, milk, sugar, water&quot; Price: 5$<br />
Chai: &quot;Tea, milk, sugar, water&quot; Price: 4$<br />
Banana Smoothie: &quot;banana, milk, sugar, water&quot; Price: 6$<br />
Strawberry Shake: &quot;Strawberries, sugar, milk, water&quot; Price: 7 $<br />
Mojito: &quot;Lemon, sugar, water, soda, mint&quot; Price 7.5 $<br />

Ingredients prices:<br />
Milk: 1 $<br />
Sugar: 0.5 $<br />
Soda: 0.5 $<br />
mint: 0.5 $<br />
water: 0.5 $<br />

Remember corner cases like:
- Each order should have at least one menu item
- An order can exist without exclusion
- An order cannot have all the ingredients in exclusion for a menu item.
A simple Java program or rest implementation anything would work, make sure there are ample tests to cover all the scenarios that can exist in the problem. 
Use in memory collections/structures to create the seed data.
