/** 
 * This class represents a singular number that has a decimal point
 * @author Nikhil Jindal
 */
public class Number extends CalculatorFunctions{
  
  /** Stores a value that is a double */
  private double val;
  
  /**
   * Constructor that takes a singular decimal number as input
   * @param d  a singular decimal value that represents the number
   */
  public Number(double d) {
      this.val = d;
  }

  /**
   * Returns the value of the Number as a double value
   * @return the value of the Number as a double value
   */
  public double getVal() {
      return this.val;
  }
  
  /**
   * Overrides the value() method from CalculatorFunctions
   * Returns the value of the Number as a double
   * @return the value of the Number as a double
   */
  @Override
  public double value() {
    return getVal();
  }
  
  /**
   * Overrides the value(double d) method from CalculatorFunctions
   * Returns the value of the Number as a double when given an input
   * @param d  double value that does not affect the Number's value
   * @return the value of the Number as a double
   */
  @Override
  public double value(double d) {
    return getVal();
  }
  
  /** 
   * Overrides the derivative() method from CalculatorFunctions
   * Returns the derivative of a number (which will always be 0.0)
   * @return 0.0 which will always be the derivative of a number 
   */
  @Override
  public CalculatorFunctions derivative() {
    return new Number(0.0);
  }

  /** 
   * Overrides the toString() method from Object
   * Returns a String representation of the Number's double value
   * @return a String representation of Number's double value
   */
  @Override
  public String toString() {
      return String.valueOf(getVal());
  }

  /** 
   * Overrides the equals() method from Object
   * Checks to see if the parameter has the same value as this instance
   * @param o  an Object that will be compared to this instance of Number
   * @return true if the number values that are compared are the same
   */
  @Override
  public boolean equals(Object o) {
      if (o instanceof Number) {
        return ((Number) o).getVal() == getVal();
      }
      else {
        return false;
      }
  }
}
