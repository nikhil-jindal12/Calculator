/** 
 * This class represents a polynomial.
 * @author Nikhil Jindal
 */
public class Polynomial extends CalculatorFunctions {
    
    /** Field that stores the polynomial's power */
    private double power;

    /** Field that stores the polynomials's operand */
    private CalculatorFunctions operand;

    /**
     * Constructor that creates an instance of Polynomial with a new operand and power
     * @param power  double that represents the exponent of the polynomial
     * @param operand  function that is the base of the polynomial
     */
    public Polynomial(double power, CalculatorFunctions operand) {
        this.power = power;
        this.operand = operand;
    }

    /**
     * Returns the polynomial's power
     * @return the polynomial's power
     */
    public double getPower() {
        return this.power;
    }

    /**
     * Returns the polynomial's operand
     * @return the polynomial's operand
     */
    public CalculatorFunctions getOperand() {
        return this.operand;
    }

    /** 
     * Overrides the toString() method from Object
     * Returns a String representation of the polynomial
     * @return a String representation of the polynomial
     */
    @Override
    public String toString() {
        if (getOperand() instanceof BinaryOp) {
            return "(" + getOperand().toString() + ")^" + getPower();
        }
        else {
            return getOperand().toString() + "^" + getPower();
        }
    }

    /** 
     * Overrides the equals() method from Object
     * Checks to see if the parameter has the same value as this instance
     * @param o  an Object that will be compared to this instance of Polynomial
     * @return true if the power and operands that are compared are the same
     */
  @Override
  public boolean equals(Object o) {
      if (o instanceof Polynomial) {
        return (((Polynomial) o).getPower() == this.getPower() && ((Polynomial) o).getOperand().equals(this.getOperand()));
      }
      else {
        return false;
      }
  }

    /**
     * Overrides the value() method from CalculatorFunctions
     * Returns the calculated value of the polynomial if there are no variables
     * @return the calculated value of the polynomial if there are no variables
     */
    @Override
    public double value() {
        return Math.pow(getOperand().value(), getPower());
    }
    
    /**
     * Overrides the value(double d) method from CalculatorFunctions
     * Returns the calculated value of the polynomial by substituting the parameter for any variables
     * @param d  substitute value for any variables in the function
     * @return the calculated value of the polynomial by substituting the parameter for any variables
     */
    @Override
    public double value(double d) {
        return Math.pow(getOperand().value(d), getPower());
    }
    
    /**
     * Overrides the derivative() method from CalculatorFunctions
     * Returns the derivative of the polynomial using the Power Rule
     * @return the derivative of the polynomial using the Power Rule
     */
    @Override
    public CalculatorFunctions derivative() {
        // (power rule): derivative = (power) * f(x)^(power - 1)
        return new BinaryOp(new Number(this.getPower()), new Polynomial(this.getPower() - 1.0, getOperand()), BinaryOp.Op.MULT);
    }

}
