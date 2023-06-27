/* This code was created by me in the course "Java SE 17 Fundamentals at Pluralsight
   Joao Carlos Pinto
   It's a simple calculator that can be executed by command line passing parameters or the word "interactive"
   that will ask for the function and numbers.
 */
package com.pluralsight.calcengine;

// Used to scan the input from command line
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // If no argument was passed, perform the calculation from variables in the program
        if (args.length == 0) {
            performCalculations();
        // if only one argument was passed and it's "interactive" means that was executed in command line and the
        // program will ask for the parameters to execute the calcultation
        } else if(args.length == 1 && args[0].equals("interactive"))
            executeInteractive();
        // If there are 3 args, it do the calculation with the parameters passed.
        else if(args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("Please provide an operation and 2 numeric values");
    }

    static void performCalculations(){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for (MathEquation equation: equations) {
            equation.execute();
            System.out.println("result :" + equation.result);
        }
    }

    static void executeInteractive(){
        System.out.println("Enter an operation and two numbers");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[2]);
        double result = execute(opCode, leftVal, rightVal);
        displayResult(opCode, leftVal, rightVal, result);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        char symbol = symbolFromOpCode(opCode);
        StringBuilder builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        String output = builder.toString();
        System.out.println(output);
    }

    private static char symbolFromOpCode(char opCode) {
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for(int index = 0; index < opCodes.length; index++) {
            if (opCode == opCodes[index]) {
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }

    private static void handleCommandLine(String[] args) {
        char opCode = args[0].charAt(0);
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal) {
        double result;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = leftVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid OpCode:" + opCode);
                result = 0.0d;
                break;
        }
        return result;
    }

    static char opCodeFromString(String operationName) {
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word) {
        String[] numberWords = {"zero", "one", "two", "three", "four",
                                "five", "six", "seven", "eight", "nine"};
        double value = 0d;
        for(int index = 0; index < numberWords.length; index++ ) {
            if (word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        return value;
    }
}
