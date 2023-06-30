/**
 * An abstract class that represents the methods that can find derivatives and the values of certain functions
 * @author Nikhil Jindal
 */
public abstract class CalculatorFunctions {
  
  /**
   * returns the calculated value of the function if no variables are present
   * @return a double value that represents the answer of a function that has no variables
   */
  public abstract double value();
  
  /**
   * returns the calculated value of the function by substituting the parameter for any variables
   * @param d  the value to substitute for any variables
   * @return a double value that represents the answer of a function by substituting the parameter for any variables
   */
  public abstract double value(double d);
  
  /**
   * returns the derivative of the function
   * @return the derivative of the function
   */
  public abstract CalculatorFunctions derivative();
    
}