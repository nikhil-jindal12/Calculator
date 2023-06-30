/**
 * This class represents a set of two operands with an operator in between.
 * @author Nikhil Jindal
 */
public class BinaryOp extends CalculatorFunctions {
  
  /** Field that stores the operand on the left hand side of the operator */
  private CalculatorFunctions leftOperand;

  /** Field that stores the operand on the right hand side of the operator */
  private CalculatorFunctions rightOperand;

  /** Field that stores the operator between the two operands */
  private Op operator;

  /**
   * Constructor that takes the left and right operands, as well as the operator
   * @param leftOperand  the function that is on the left side of the operator
   * @param rightOperand  the function that is on the right side of the operator
   * @param operator  the operator that should be in between the two opeands
   */
  public BinaryOp(CalculatorFunctions leftOperand, CalculatorFunctions rightOperand, Op operator) {
    this.leftOperand = leftOperand;
    this.rightOperand = rightOperand;
    this.operator = operator;
  }

  /**
   * Returns the operand to the left of the operator
   * @return the operand to the left of the operator
   */
  public CalculatorFunctions getLeftOperand() {
    return this.leftOperand;
  }

  /**
   * Returns the operand to the right of the operator
   * @return the operand to the right of the operator
   */
  public CalculatorFunctions getRightOperand() {
    return this.rightOperand;
  }

  /**
   * Returns the operator between the two operands
   * @return the operator between the two operands
   */
  public Op getOperator() {
    return this.operator;
  }

  /**
   * Overrides the equals() method from Object
   * Checks to see whether two BinaryOp's have the left and right operator and operand
   * @param functions  the function to be compared to this instance of the BinaryOp
   * @return true if the two BinaryOp's have the same left and right operator and operand
   */
  @Override
  public boolean equals(Object o) {
    
    // checks to see if the parameter is an instance of BinaryOp
    if (o instanceof BinaryOp) {

      // compare the operands and operators if it is a BinaryOp
      if (getLeftOperand().equals(((BinaryOp)o).getLeftOperand()) && getRightOperand().equals(((BinaryOp)o).getRightOperand()) && getOperator() == ((BinaryOp)o).getOperator()) {
        return true;
      }
      else {
        return false;
      }
    }
    
    else {
      return false;
    }
  }

  /**
   * Override the toString() method of Object
   * Returns a String representation of the BinaryOp
   *    left operand will be placed inside parentheses if it is an instance of BinaryOp
   *    right operand will be placed inside parentheses if it is an instance of BinaryOp and has a different operator
   * @return a String representation of the BinaryOp
   */
  @Override
  public String toString() {

    // checks to see if the left operand is an instance of BinaryOp
    if (getLeftOperand() instanceof BinaryOp) {

      // check to see if the right operand is an instance of BinaryOp and whether it has the same operator
      if (getRightOperand() instanceof BinaryOp && ((BinaryOp) getRightOperand()).getOperator() == this.getOperator()) {
        return "(" + getLeftOperand().toString() + ") " + getOperator().getOperatorString() + " " + getRightOperand().toString();
      }
      else {
        return "(" + getLeftOperand().toString() + ") " + getOperator().getOperatorString() + " (" + getRightOperand().toString() + ")";
      }
    }

    // check to see if only the right operand is an instance of BinaryOp
    else if (getRightOperand() instanceof BinaryOp) {

      // check to see if the right operand is an instance of BinaryOp and whether it has the same operator
      if (((BinaryOp) getRightOperand()).getOperator() == this.getOperator()) {
        return getLeftOperand().toString() + " " + getOperator().getOperatorString() + " " + getRightOperand().toString();
      }
      else {
        return getLeftOperand().toString() + " " + getOperator().getOperatorString() + " (" + getRightOperand().toString() + ")";
      }
    }

    // if neither of the operands are instances of BinaryOp, then don't add any parentheses
    else {
      return getLeftOperand().toString() + " " + getOperator().getOperatorString() + " " + getRightOperand().toString();
    }
  }

  /**
   * Overrides the value() method from CalculatorFunctions
   * Returns the calculated value of the BinaryOp if it has no variables
   * @return the calculated value of the BinaryOp if it has no variables
   */
  @Override
  public double value() {
    if (this.getOperator() == Op.PLUS) {
      return getLeftOperand().value() + getRightOperand().value();
    }
    else if (this.getOperator() == Op.SUB) {
      return getLeftOperand().value() - getRightOperand().value();
    }
    else if (this.getOperator() == Op.MULT) {
      return getLeftOperand().value() * getRightOperand().value();
    }
    else {
      return getLeftOperand().value() / getRightOperand().value();
    }
  }
  
  /** 
   * Overrides the value(double d) method from CalculatorFunctions
   * Returns the calculated value of the BinaryOp when the parameter is substituted in for any variables
   * @param d  the value to substitute for each variable
   * @return the calculated value of the BinaryOp when the parameter is substituted in for any variables
   */
  @Override
  public double value(double d) {
    if (this.getOperator() == Op.PLUS) {
      return getLeftOperand().value(d) + getRightOperand().value(d);
    }
    else if (this.getOperator() == Op.SUB) {
      return getLeftOperand().value(d) - getRightOperand().value(d);
    }
    else if (this.getOperator() == Op.MULT) {
      return getLeftOperand().value(d) * getRightOperand().value(d);
    }
    else {
      return getLeftOperand().value(d) / getRightOperand().value(d);
    }
  }
  
  /**
   * Overrides the derivative() method from CalculatorFunctions
   * Utilizes the Product Rule and the Quotient Rule to determine the derivative of a BinaryOp
   * @return the derivative of the BinaryOp
   */
  @Override
  public CalculatorFunctions derivative() {
    if (this.getOperator() == Op.PLUS) {
      // derivative = f'(x) + g'(x)
      return new BinaryOp(getLeftOperand().derivative(), getRightOperand().derivative(), Op.PLUS);
    }
    else if (this.getOperator() == Op.SUB) {
      // derivative = f'(x) - g'(x)
      return new BinaryOp(getLeftOperand().derivative(), getRightOperand().derivative(), Op.SUB);
    }
    else if (this.getOperator() == Op.MULT) {
      // (product rule): derivative = f(x)*g'(x) + f'(x)*g(x)
      return new BinaryOp(new BinaryOp(getLeftOperand(), getRightOperand().derivative(), Op.MULT), new BinaryOp(getLeftOperand().derivative(), getRightOperand(), Op.MULT), Op.PLUS);
    }
    else {
      // (quotient rule): derivative = (g(x)*f'(x) - f(x)*g'(x))/(g(x))^2
      return new BinaryOp(new BinaryOp(new BinaryOp(getRightOperand(), getLeftOperand().derivative(), Op.MULT), new BinaryOp(getLeftOperand(), getRightOperand().derivative(), Op.MULT), Op.SUB), new Polynomial(2, getRightOperand()), Op.DIV);
    }
  }
  
  /**
   * Class that represents the four different operators (+, -, *, /)
   */
  enum Op {

    /** Fields set to instances of the Op class */
    PLUS("+"), SUB("-"), MULT("*"), DIV("/");
    
    /** Field that stores the String representation of each operator */
    private String operatorString;

    /** 
     * Constructor that creates a new instance of an operator
     * @param operandString  the String representation of an instance of a new operator
     */
    private Op(String operatorString) {
      this.operatorString = operatorString;
    }

    /**
     * Returns the String stored in the instance's field
     * @return the String stored in the instance's field
     */
    public String getOperatorString() {
      return this.operatorString;
    }
  }

}