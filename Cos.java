/**
 * A class that represents a Cosine function.
 * @author Nikhil Jindal
 */
public class Cos extends TrigFunctions {
    
    /** Field that stores the operand of the cosine function */
    private CalculatorFunctions operand;

    /**
     * Constructor that creates a new instance of Cos using the parameter as the operand
     * @param operand  the operand that should be used as the operand of the cos function
     */
    public Cos(CalculatorFunctions operand) {
        this.operand = operand;
    }

    /**
     * Overrides the getOperand() method from TrigFunctions
     * Returns the operand of the function
     * @return the operand of the function 
     */
    @Override
    public CalculatorFunctions getOperand() {
        return this.operand;
    }
    
    /**
     * Overrides the toString() method from TrigFunctions
     * Returns a String representation of the function
     * @return a String representation of the function
     */
    @Override
    public String toString() {
        return "Cos[" + getOperand().toString() + "]";
    }

    /**
     * Overrides the equals() method from TrigFunctions
     * Returns true if the two functions have the same parameters
     * @param functions  the function to compare to this instance of Cos 
     * @return true if the two functions have the same parameters
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Cos) {
            return ((Cos) o).getOperand().equals(this.getOperand());
        }
        else {
            return false;
        }
    }

    /**
     * Overrides the value() method of CalculatorFunction
     * Returns the calculated value of the function if there are no variables
     * @return the calculated value of the function if there are no variables
     */
    @Override
    public double value() {
        return Math.cos(getOperand().value());
    }

    /**
     * Overrides the value(double d) method of CalculatorFunction
     * Returns the calculated value of the function by subtituting the parameter for any variables
     * @param d  the parameter to substitute for any variables in the function
     * @return the calculated value of the function by subtituting the parameter for any variables
     */
    @Override
    public double value(double d) {
        return Math.cos(getOperand().value(d));
    }

    /**
     * Overrides the derivative() method of CalculatorFunction
     * Returns the derivative of the Cos function using the trigonometric derivative rules
     * @return the derivative of the Cos function using the trigonometric derivative rules
     */
    @Override
    public CalculatorFunctions derivative() {
        // derivative = -sin(f(x)) * f'(x)
        return new BinaryOp(new BinaryOp(new Number(-1.0), new Sin(getOperand()), BinaryOp.Op.MULT), getOperand().derivative(), BinaryOp.Op.MULT);
    }

}
