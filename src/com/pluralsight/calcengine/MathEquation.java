package com.pluralsight.calcengine;

public class MathEquation {
    private double leftVal;
    private double rightVal;
    private MathOperation opCode;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation() {}

    public MathEquation(MathOperation opCode) {
        this.opCode = opCode;
    }

    public MathEquation(MathOperation opCode, double leftVal, double rightVal) {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;
    }

    void execute() {
        switch (opCode) {
            case ADD:
                result = leftVal + rightVal;
                break;
            case SUBTRACT:
                result = leftVal - rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
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

    @Override
    public String toString() {
        char symbol = opCode.getSymbol();

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


    public double getLeftVal() { return leftVal; }

    public void setLeftVal(double leftVal) {this.leftVal = leftVal; }

    public double getRightVal() { return rightVal; }

    public void setRightVal(double righVal) {this.rightVal = righVal; }

    public MathOperation getOpCode() { return opCode; }

    public void setOpCode(MathOperation opCode) {this.opCode = opCode; }

    public double getResult() { return result; }

}
