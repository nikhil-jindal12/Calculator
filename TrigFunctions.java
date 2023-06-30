/**
 * An abstract class representing the necessary functions for sine, cosine, natural logarithm, and natural exponential function
 * @author Nikhil Jindal
 */
public abstract class TrigFunctions extends CalculatorFunctions{
    
    /**
     * Returns the operand of each function
     * @return the operand of each function
     */
    public abstract CalculatorFunctions getOperand();

    /**
     * Overrides the toString() method from Object
     * Returns a String representation of the function
     * @return a String representation of the function
     */
    @Override
    public abstract String toString();

    /**
     * Override the equals() method from Object
     * Checks if the function and the parameter are equal to each other if their parameters are equal
     * @param function  the function to compare this instance to
     * @return  true if the functions have the same parameters
     */
    public abstract boolean equals(Object o);
}
