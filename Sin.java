/**
 * Class that represents a Sine function.
 * @author Nikhil Jindal
 */
public class Sin extends TrigFunctions {
    
    /** Field that stores the operand of the sine function */
    private CalculatorFunctions operand;

    /**
     * Constructor that creates a new instance of Sin using the parameter as the operand
     * @param operand  the function that should be used as the operand of a sin function
     */
    public Sin(CalculatorFunctions operand) {
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
        return "Sin[" + getOperand().toString() + "]";
    }

    /**
     * Overrides the equals() method from TrigFunctions
     * Compares the parameter to this instance of Sin to see if its parameters match
     * @return true if the parameters of the two functions match
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Sin) {
            return ((Sin) o).getOperand().equals(this.getOperand());
        }
        else {
            return false;
        }
    }

    /**
     * Overrides the value() method from CalculatorFunctions
     * Calculates the value of the function if there are no variables present
     * @return the value of the function if there are no variables present
     */
    @Override
    public double value() {
        return Math.sin(getOperand().value());
    }

    /**
     * Overrides the value(double d) method from CalculatorFunctions
     * Calculates the value of the function by substituting the parameter for any variables in the function
     * @return the value of the function by substituting the parameter for any variables in the function
     */
    @Override
    public double value(double d) {
        return Math.sin(getOperand().value(d));
    }

    /**
     * Overrides the derivative() method from CalculatorFunctions
     * Returns the derivative of the Sin function using the trigonometry derivative rules
     * @return the derivative of the Sin function using the trigonometry derivative rules
     */
    @Override
    public CalculatorFunctions derivative() {
        // derivative = cos(f(x)) * f'(x)
        return new BinaryOp(new Cos(getOperand()),getOperand().derivative() , BinaryOp.Op.MULT);
    }

}
