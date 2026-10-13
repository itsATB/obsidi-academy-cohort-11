package com.bptn.course.__Team_Activities.Day11;

import java.util.Optional;
import java.util.function.DoubleUnaryOperator;
// added meaningful class naming
public class OrderProcessingService {
     //made the constants final so that no change will happen during the code execution
    private static final double DISCOUNT_QUALIFIED = 100.0;
    private static final double DISCOUNT_RATE = 0.10;
  // Updated the naming of variables to meaningful names
    public void processOrder(String name, int stock, double price) {
        // used obtional to handle any name that might be null
        Optional<String> customer = Optional.ofNullable(name);
        // Guard clause: stop if the name is null or empty and the next one stop if the stock is 0 or negative
        if (customer.isEmpty() || customer.get().isEmpty()) return;
        if (stock <= 0) {
            System.out.println("Invalid stock");
            return;
        }
        // Guard clause: stop if the price is 0 or negative
        if (price <= 0) {
            System.out.println("Invalid price");
            return;
        }
        // if everything is valid we process the order
        printOrder(customer.get(), price);
    }
 // using lambda, calculated the discount
    private void printOrder(String name, double price) {
        DoubleUnaryOperator discount = amount ->
                amount > DISCOUNT_QUALIFIED ? amount * DISCOUNT_RATE : 0.0;
        System.out.println("Processing " + name);
        System.out.println("Discount: " + discount.applyAsDouble(price));
    }
}