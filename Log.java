/**
 * Class that represents a natural logarithmic function.
 * @author Nikhil Jindal
 */
public class Log extends TrigFunctions {
 
    /** Field that is the operand of the logarithmic function */
    private CalculatorFunctions operand;

    /**
     * Constructor that creates a new instance of Log with the parameter as the operand
     * @param operand  the function that is the operand of the logarithmic function
     */
    public Log(CalculatorFunctions operand) {
        this.operand = operand;
    }

    /**
     * Overrides the getOperand() method from TrigFunctions
     * Returns the operand of the logarithmic function
     * @return the operand of the logarithmic function
     */
    @Override
    public CalculatorFunctions getOperand() {
        return this.operand;
    }

    /**
     * Overrides the toString() method from TrigFunctions
     * Returns a String representation of the logarithmic function
     * @return a String representation of the logarithmic function
     */
    @Override
    public String toString() {
        return "Log[" + getOperand().toString() + "]";
    }

    /**
     * Overrides the equals() method from TrigFunctions
     * Returns true if the comparison function has the same parameters
     * @param function  the function to compare to this instance of Log
     * @return true if the comparison function has the same parameters
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Log) {
            return ((Log) o).getOperand().equals(this.getOperand());
        }
        else {
            return false;
        }
    }

    /**
     * Overrides the value() method from CalculatorFunctions
     * Returns the calculation of the Log function if there are no variables present
     * @return the calculation of the Log function if there are no variables present
     */
    @Override
    public double value() {
        return Math.log(getOperand().value());
    }

    /**
     * Overrides the value(double d) method from CalculatorFunctions
     * Returns the calculation of the Log function by substituting the parameter for any variables present
     * @param d  value to substitute if there are any variables present
     * @return the calculation of the Log function by substituting the parameter for any variables present
     */
    @Override
    public double value(double d) {
        return Math.log(getOperand().value(d));
    }

    /**
     * Overrides the derivative() method from CalculatorFunctions
     * Returns the derivative of the Log function using the formula for the derivative of a natual logarithm
     * @return the derivative of the Log function using the formula for the derivative of a natual logarithm
     */
    @Override
    public CalculatorFunctions derivative() {
        // derivative = (1.0/f(x)) * f'(x)
        return new BinaryOp(new BinaryOp(new Number(1.0), getOperand(), BinaryOp.Op.DIV), getOperand().derivative(), BinaryOp.Op.MULT);
    }

}
