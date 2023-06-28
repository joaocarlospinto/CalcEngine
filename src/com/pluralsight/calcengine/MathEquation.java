package com.pluralsight.calcengine;

public class MathEquation {
    double leftVal;
    double rightVal;
    char opCode;
    double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation() {}

    public MathEquation(char opCode) {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute() {
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

        numberOfCalculations++;
        sumOfResults +=result;
    }

    public void execute(double leftVal, double rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();
    }

    public void execute(int leftVal, int rightVal) {
        this.leftVal = leftVal;
        this.rightVal = rightVal;

        execute();

        result = (int)result;
    }

    public static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }

    public String toString() {
        char symbol = symbolFromOpcode();

        StringBuilder builder = new StringBuilder(20);
        builder.append(leftVal);
        builder.append(" ");
        builder.append(symbol);
        builder.append(" ");
        builder.append(rightVal);
        builder.append(" = ");
        builder.append(result);
        return builder.toString();
    }

    public char symbolFromOpcode () {
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


    public double getLeftVal() { return leftVal; }

    public void setLeftVal(double leftVal) {this.leftVal = leftVal; }

    public double getRightVal() { return rightVal; }

    public void setRightVal(double righVal) {this.rightVal = righVal; }

    public double getOpCode() { return opCode; }

    public void setOpCode(char opCode) {this.opCode = opCode; }

    public double getResult() { return result; }

}
