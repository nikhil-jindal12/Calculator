/** 
 * Class that represents the variable "x"
 * @author Nikhil Jindal
 */
public class Variable extends CalculatorFunctions {
  
  /**
   * Overrides the value() method from CalculatorFunctions
   * @throws UnsupportedOperationException since a value is needed to replace the variable and no value is provided
   */
  @Override
  public double value() {
    throw new UnsupportedOperationException();
  }
  
  /** 
   * Overrides the value(double d) method from CalculatorFunctions
   * Replaces the variable with a double value
   * @param d  the value that should replace the variable "x"
   * @return the parameter value that is inputted
   */
  @Override
  public double value(double d) {
    return d;
  }
  
  /**
   * Overrides the derivative() method from CalculatorFunctions
   * Calculates the derivative of the variable "x"
   * @return the Number 1.0 because the derivative of "x" will always be 1.0
   */
  @Override
  public CalculatorFunctions derivative() {
    return new Number(1.0);
  }
  
  /** 
   * Overrides the toString() method from Object
   * Returns a String representation of the variable
   * @return the String "x" since that will always be the variable
   */
  @Override
  public String toString() {
    return "x";
  }
  
  /**
   * Overrides the equals() method from Object
   * Checks to see if the parameter is compared to another Variable
   * @param o  an Object that will be compared to this instance of Variable
   * @return a boolean that tells whether the parameter is an instance of Variable
   */
  @Override  
  public boolean equals(Object o) {
    if (o instanceof Variable) {
      return true;
    }
    else {
      return false;
    }
  }
}