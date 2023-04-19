package com.cglearning.mainprogs.tutorial1;

import com.cglearning.interfaces.CalculationInterface;

import static com.cglearning.constants.Constants.LINE_DELIMITER;

public class CalculationMain {

    public static void main(String[] args) {
        /*
            Since we have defined CalculationInterface as a functional interface
            We can use lambda expression to invoke the method
            Data type of the parameters is taken from the functional interface
         */
        CalculationInterface calculationExpanded = (num1, num2) -> {
            return num1 + num2;
        };
        CalculationInterface calculationSimplified = ((num1, num2) -> num1 + num2);

        System.out.println("Expanded call");
        System.out.println(calculationExpanded.addition(101.11, 98.11));
        System.out.println(LINE_DELIMITER);

        System.out.println("Simplified call");
        System.out.println(calculationSimplified.addition(101.33, 98.33));
        System.out.println(LINE_DELIMITER);

    }
}
