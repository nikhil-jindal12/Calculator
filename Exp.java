/**
 * Class that represents a natural exponential function.
 * @author Nikhil Jindal
 */
public class Exp extends TrigFunctions {
    
    /** Field that has the operand of the natural exponential function */
    private CalculatorFunctions operand;

    /**
     * Constructor that creates a new instance of Exp using the parameter as the operand
     * @param operand  the operand of the natural exponential function
     */
    public Exp(CalculatorFunctions operand) {
        this.operand = operand;
    }

    /**
     * Overrides the getOperand() method of TrigFunctions
     * Returns the operand of the function
     * @return the operand of the function
     */
    @Override
    public CalculatorFunctions getOperand() {
        return this.operand;
    }

    /**
     * Overrides the toString() method of TrigFunctions
     * Returns a String representation of the function
     * @return a String representation of the function
     */
    @Override
    public String toString() {
        return "Exp[" + getOperand().toString() + "]";
    }

    /**
     * Overrides the equals() method of TrigFunctions
     * Returns true if the parameters of the two functions are the same
     * @param functions  the function to compare to this instance of Exp
     * @return true if the parameters of the two functions are the same
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Exp) {
            return ((Exp) o).getOperand().equals(getOperand());
        }
        else {
            return false;
        }
    }

    /**
     * Overrides the value() method of CalculatorFunctions
     * Calculates the natural exponential function if there are no variables in the function
     * @return the calculation of the natural exponential function if there are no variables in the function
     */
    @Override
    public double value() {
        return Math.exp(getOperand().value());
    }

    /**
     * Overrides the value(double d) method of CalculatorFunctions
     * Calculates the natural exponential function by substituting the parameter value for any variables 
     * @return the calculation of the natural exponential function by substituting the parameter value for any variables
     */
    @Override
    public double value(double d) {
        return Math.exp(getOperand().value(d));
    }

    /**
     * Overrides the derivative() method of CalculatorFunctions
     * Returns the derivative of the natural exponential function using it's derivative rule
     * @return the derivative of the natural exponential function using it's derivative rule
     */
    @Override
    public CalculatorFunctions derivative() {
        // derivative = e^f(x) * f'(x)
        return new BinaryOp(new Exp(this.getOperand()), this.getOperand().derivative(), BinaryOp.Op.MULT);
    }

}
