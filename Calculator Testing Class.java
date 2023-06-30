import org.junit.*;
import static org.junit.Assert.*;

/**
 * This is a JUnit Testing class that tests the Number, Variable, CalculatorFunctions, BinaryOp, Polynomial, TrigFunctions, Log, Sin, Cos, and Exp classes.
 * @author Nikhil Jindal
 */
public class HW3Tester {

    /**
     * Test the toString() method that every class should have
     */
    @Test
    public void testToString() {

        /** 
         * Number class test
         */ 
        Number n1 = new Number(1.5);
        Number n2 = new Number(-50.01);

        // Test #1 - positive double value
        assertEquals("positive double", "1.5", n1.toString());

        // Test #2 - negative double value
        assertEquals("negative double", "-50.01", n2.toString());


        /** 
         * Variable class test
         */ 
        Variable v1 = new Variable();

        // Test #3 - no input for constructor --> should always return "x"
        assertEquals("x", v1.toString());


        /** 
         * Polynomial class test
         */ 
        Polynomial p1 = new Polynomial(2.0, n1);
        Polynomial p2 = new Polynomial(3.57, v1);

        // Test #4 - new Polynomial using a Number instance as the base
        assertEquals("1.5^2.0", p1.toString());

        // Test #5 - new Polynomial using a Variable instance as the base
        assertEquals("x^3.57", p2.toString());


        /** 
         * Log class test
         */ 
        Log log1 = new Log(p2);
        Log log2 = new Log(p1);
        Log log3 = new Log(new Number(2.53));

        // Test #6 - new Log using a Polynomial that has a Variable
        assertEquals("Log[x^3.57]", log1.toString());

        // Test #7 - new Log using a Polynomial with Numbers
        assertEquals("Log[1.5^2.0]", log2.toString());

        // Test #8 - new log with just a Number
        assertEquals("Log[2.53]", log3.toString());


        /** 
         * Exp class test
         */ 
        Exp e1 = new Exp(log1);
        Exp e2 = new Exp(p1);
        Exp e3 = new Exp(n2);

        //Test #9 - Exp with Log with Polynomial with Variable
        assertEquals("Exp[Log[x^3.57]]", e1.toString());
        
        // Test #10 - Exp with Polynomial
        assertEquals("Exp[1.5^2.0]", e2.toString());

        // Test #11 - Exp with Number
        assertEquals("Exp[-50.01]", e3.toString());


        /** 
         * Sin class test
         */ 
        Sin s1 = new Sin(e1);
        Sin s2 = new Sin(p2);
        Sin s3 = new Sin(n2);
        Sin s4 = new Sin(log1);

        // Test #12 - Sin with Exp with Log with Polynomial with Variable and Number
        assertEquals("Sin[Exp[Log[x^3.57]]]", s1.toString());
        
        // Test #13 - Sin with Polynomial with Variable and Number
        assertEquals("Sin[x^3.57]", s2.toString());

        // Test #14 - Sin with Number
        assertEquals("Sin[-50.01]", s3.toString());

        // Test #15 - Sin with Log and Polynomial with Variable and Number 
        assertEquals("Sin[Log[x^3.57]]", s4.toString());


        /** 
         * Cos class test
         */ 
        Cos c1 = new Cos(s1);
        Cos c2 = new Cos(e1);
        Cos c3 = new Cos(p2);
        Cos c4 = new Cos(n2);
        Cos c5 = new Cos(log1);

        // Test #16 - Cos with Sin and Exp and Log and Polynomial with Variable and Number
        assertEquals("Cos[Sin[Exp[Log[x^3.57]]]]", c1.toString());

        // Test #17 - Cos with Exp and Log with Polynomial with Variable and Number
        assertEquals("Cos[Exp[Log[x^3.57]]]", c2.toString());

        // Test #18 - Cos with Polynomial with Variable and Number
        assertEquals("Cos[x^3.57]", c3.toString());

        // Test #19 - Cos with Number
        assertEquals("Cos[-50.01]", c4.toString());

        // Test #20 - Cos with Log and Polynomial with Variable and Number
        assertEquals("Cos[Log[x^3.57]]", c5.toString());


        /** 
         * BinaryOp class test
         */ 
        BinaryOp bo1 = new BinaryOp(v1, log3, BinaryOp.Op.MULT);
        BinaryOp bo2 = new BinaryOp(c4, s2, BinaryOp.Op.PLUS);
        BinaryOp bo3 = new BinaryOp(bo1, bo2, BinaryOp.Op.PLUS);
        BinaryOp bo4 = new BinaryOp(bo1, bo2, BinaryOp.Op.DIV);
        BinaryOp bo5 = new BinaryOp(n1, bo1, BinaryOp.Op.MULT);
        BinaryOp bo6 = new BinaryOp(n1, bo1, BinaryOp.Op.SUB);

        // Test #21 - BinaryOp with Variable and Log function with Number
        assertEquals("x * Log[2.53]", bo1.toString());

        // Test #22 - Binary Op with Cos of Number and Sin of Polynomial with Variable
        assertEquals("Cos[-50.01] + Sin[x^3.57]", bo2.toString());

        // Test #23 - BinaryOp with left and right operand as BinaryOps 
        //              right operand not in () bc it has the same operator
        assertEquals("(x * Log[2.53]) + Cos[-50.01] + Sin[x^3.57]", bo3.toString());

        // Test #24 - BinaryOp with left and right operand as BinaryOps 
        //              right operand is in () bc it does not have the same operator
        assertEquals("(x * Log[2.53]) / (Cos[-50.01] + Sin[x^3.57])", bo4.toString());

        // Test #25 - Binary Op with right operand as BinaryOp
        //              right operand not in () bc it has the same operator
        assertEquals("1.5 * x * Log[2.53]", bo5.toString());

        // Test #26 - Binary Op with right operand as BinaryOp
        //              right operand is in () bc does not have the same operator
        assertEquals("1.5 - (x * Log[2.53])", bo6.toString());

    }

    /**
     * Tests the equals() method that every class should have
     */
    @Test
    public void testEquals() {

        /** 
         * Number class test
         */ 
        Number n1 = new Number(1.5);
        Number n2 = new Number(-3.14);
        Number n3 = new Number(1.5);
        Polynomial p1 = new Polynomial(1, n1);

        // Test #27 - Compares to a Number with a different parameter
        assertEquals(false, n1.equals(n2));

        // Test #28 - Compares to a Number with the same parameter
        assertEquals(true, n1.equals(n3));

        //Test #29 - Compares Number to a Polynomial
        assertEquals(false, n1.equals(p1));


        /**
         * Variable class test
         */ 
        Variable v1 = new Variable();
        Variable v2 = new Variable();
        Number n4 = new Number(0.0);

        // Test #30 - Compares a Variable to a Variable
        assertEquals(true, v1.equals(v2));

        // Test #31 - Compares a Variable to a Number
        assertEquals(false, v1.equals(n4));


        /**
         * Polynomial class test
         */  
        Polynomial p2 = new Polynomial(4, n2);
        Polynomial p3 = new Polynomial(4, n2);
        Polynomial p4 = new Polynomial(3, n2);
        Polynomial p5 = new Polynomial(4, n1);
        Exp e1 = new Exp(n2);

        // Test #32 - Compares a Polynomial to a Polynomial with the same power and operand
        assertEquals(true, p2.equals(p3));
        
        // Test #33 - Compares a Polynomial to a Polynomial with the operand
        assertEquals(false, p2.equals(p4));

        // Test #34 - Compares a Polynomial to a Polynomial with the same power
        assertEquals(false, p2.equals(p5));

        // Test #35 - Compares a Polynomial to an Exp
        assertEquals(false, p2.equals(e1));
        

        /**
         * Log class test
         */ 
        Log l1 = new Log(p2);
        Log l2 = new Log(p2);
        Log l3 = new Log(p5);
        Exp e2 = new Exp(p2);

        // Test #36 - Compares a Log to a Log with the same operand
        assertEquals(true, l1.equals(l2));

        // Test #37 - Compares a Log to a Log with different operand
        assertEquals(false, l1.equals(l3));

        // Test #38 - Compares a Log to an Exp
        assertEquals(false, l1.equals(e2));


        /**
         * Exp class test
         */ 
        Exp e3 = new Exp(v1);
        Exp e4 = new Exp(v1);
        Exp e5 = new Exp(n1);
        Number n5 = new Number(6.92);

        // Test #39 - Compares an Exp to an Exp with the same operand
        assertEquals(true, e3.equals(e4));

        // Test #40 - Compares an Exp to an Exp with different operand
        assertEquals(false, e3.equals(e5));

        // Test #41 - Copmares an Exp to a Number
        assertEquals(false, e3.equals(n5));


        /**
         * Sin class test
         */ 
        Sin s1 = new Sin(n5);
        Sin s2 = new Sin(n5);
        Sin s3 = new Sin(p2);
        Cos c1 = new Cos(n5);

        // Test #42 - Compares a Sin to a Sin with the same operand
        assertEquals(true, s1.equals(s2));

        // Test #43 - Compares a Sin to a Sin with a different operand
        assertEquals(false, s1.equals(s3));

        // Test #44 - Compares a Sin to a Cos
        assertEquals(false, s1.equals(c1));


        /**
         * Cos class test
         */
        Cos c2 = new Cos(p2);
        Cos c3 = new Cos(p2);
        Cos c4 = new Cos(n2);
        Exp e6 = new Exp(p2);

        // Test #45 - Compares a Cos to a Cos with the same operand
        assertEquals(true, c2.equals(c3));

        // Test #46 - Compares a Cos to a Cos with different operand
        assertEquals(false, c2.equals(c4));

        // Test #47 - Compares a Cos to an Exp
        assertEquals(false, c2.equals(e6));


        /**
         * BinaryOp class test
         */ 
        BinaryOp bo1 = new BinaryOp(s1, c1, BinaryOp.Op.MULT);
        BinaryOp bo2 = new BinaryOp(s1, c1, BinaryOp.Op.MULT);
        BinaryOp bo3 = new BinaryOp(p2, c1, BinaryOp.Op.MULT);
        BinaryOp bo4 = new BinaryOp(s1, n3, BinaryOp.Op.MULT);
        BinaryOp bo5 = new BinaryOp(s1, c1, BinaryOp.Op.PLUS);
        Cos c5 = new Cos(bo1);

        // Test #48 - Compares a BinaryOp to a BinaryOp with the same operands and operator
        assertEquals(true, bo1.equals(bo2));

        // Test #49 - Compares a BinaryOp to a BinaryOp with different left operands
        assertEquals(false, bo1.equals(bo3));

        // Test #50 - Compares a BinaryOp to a BinaryOp with different right operands
        assertEquals(false, bo1.equals(bo4));

        // Test #51 - Compares a BinaryOp to a BinaryOp with different operator
        assertEquals(false, bo1.equals(bo5));

        // Test #52 - Compares a BinaryOp to a Cos that has the first BinaryOp as its parameter
        assertEquals(false, bo1.equals(c5));

    }

    /**
     * Tests the getOperand() method that is in Polynomial, Log, Exp, Sin, & Cos
     */
    @Test
    public void testGetOperand() {

        // Initializing an instance of every class
        Number n1 = new Number(1.5);
        Cos c1 = new Cos(n1);
        Sin s1 = new Sin(c1);
        Variable v1 = new Variable();
        Polynomial p1 = new Polynomial(1, v1);
        Exp e1 = new Exp(s1);
        Log l1 = new Log(e1);
        BinaryOp bo1 = new BinaryOp(s1, c1, BinaryOp.Op.MULT);

        /**
         * Polynomial class test
         */
        Polynomial p2 = new Polynomial(4, n1);
        Polynomial p3 = new Polynomial(4, c1);
        Polynomial p4 = new Polynomial(4, bo1);
        Polynomial p5 = new Polynomial(4, s1);
        Polynomial p6 = new Polynomial(4, v1);
        Polynomial p7 = new Polynomial(4, e1);
        Polynomial p8 = new Polynomial(4, l1);
        Polynomial p9 = new Polynomial(4, p1);

        // Test #53 - Polynomial with Variable operand
        assertEquals(v1, p1.getOperand());

        // Test #54 - Polynomial with Number operand
        assertEquals(n1, p2.getOperand());

        // Test #55 - Polynomial with Cos operand
        assertEquals(c1, p3.getOperand());

        // Test #56 - Polynomial with BinaryOp operand
        assertEquals(bo1, p4.getOperand());

        // Test #57 - Polynomial with Sin operand
        assertEquals(s1, p5.getOperand());

        // Test #58 - Polynomial with Variable operand
        assertEquals(v1, p6.getOperand());

        // Test #59 - Polynomial with Exp operand
        assertEquals(e1, p7.getOperand());

        // Test #60 - Polynomial with Log operand
        assertEquals(l1, p8.getOperand());

        // Test #61 - Polynomial with Polynomial operand
        assertEquals(p1, p9.getOperand());


        /**
         * Log class test
         */
        Log l2 = new Log(n1);
        Log l3 = new Log(c1);
        Log l4 = new Log(bo1);
        Log l5 = new Log(s1);
        Log l6 = new Log(v1);
        Log l7 = new Log(e1);
        Log l8 = new Log(l1);
        Log l9 = new Log(p1);

        // Test #62 - Log with Variable operand
        assertEquals(e1, l1.getOperand());

        // Test #63 - Log with Number operand
        assertEquals(n1, l2.getOperand());

        // Test #64 - Log with Cos operand
        assertEquals(c1, l3.getOperand());

        // Test #65 - Log with BinaryOp operand
        assertEquals(bo1, l4.getOperand());

        // Test #66 - Log with Sin operand
        assertEquals(s1, l5.getOperand());

        // Test #67 - Log with Variable operand
        assertEquals(v1, l6.getOperand());

        // Test #68 - Log with Exp operand
        assertEquals(e1, l7.getOperand());

        // Test #69 - Log with Log operand
        assertEquals(l1, l8.getOperand());

        // Test #70 - Log with Polynomial operand
        assertEquals(p1, l9.getOperand());

        /**
         * Exp class test
         */
        Exp e2 = new Exp(n1);
        Exp e3 = new Exp(c1);
        Exp e5 = new Exp(s1);
        Exp e6 = new Exp(v1);
        Exp e7 = new Exp(e1);
        Exp e8 = new Exp(l1);
        Exp e9 = new Exp(p1);
        Exp e4 = new Exp(bo1);

        // Test #71 - Exp with Variable operand
        assertEquals(s1, e1.getOperand());

        // Test #72 - Exp with Number operand
        assertEquals(n1, e2.getOperand());

        // Test #73 - Exp with Cos operand
        assertEquals(c1, e3.getOperand());

        // Test #74 - Exp with Sin operand
        assertEquals(s1, e5.getOperand());

        // Test #75 - Exp with Variable operand
        assertEquals(v1, e6.getOperand());

        // Test #76 - Exp with Exp operand
        assertEquals(e1, e7.getOperand());

        // Test #77 - Exp with Log operand
        assertEquals(l1, e8.getOperand());

        // Test #78 - Exp with Polynomial operand
        assertEquals(p1, e9.getOperand());

        // Test #79 - Exp with BinaryOp operand
        assertEquals(bo1, e4.getOperand());


        /** 
         * Sin class test
         */
        Sin s2 = new Sin(n1);
        Sin s3 = new Sin(c1);
        Sin s5 = new Sin(s1);
        Sin s6 = new Sin(v1);
        Sin s7 = new Sin(e1);
        Sin s8 = new Sin(l1);
        Sin s9 = new Sin(p1);
        Sin s4 = new Sin(bo1);

        // Test #80 - Sin with Variable operand
        assertEquals(c1, s1.getOperand());

        // Test #81 - Sin with Number operand
        assertEquals(n1, s2.getOperand());

        // Test #82 - Sin with Cos operand
        assertEquals(c1, s3.getOperand());

        // Test #83 - Sin with Sin operand
        assertEquals(s1, s5.getOperand());

        // Test #84 - Sin with Variable operand
        assertEquals(v1, s6.getOperand());

        // Test #85 - Sin with Exp operand
        assertEquals(e1, s7.getOperand());

        // Test #86 - Sin with Log operand
        assertEquals(l1, s8.getOperand());

        // Test #87 - Sin with Polynomial operand
        assertEquals(p1, s9.getOperand());

        // Test #88 - Sin with BinaryOp operand
        assertEquals(bo1, s4.getOperand());

        /**
         * Cos class test
         */
        Cos c2 = new Cos(n1);
        Cos c3 = new Cos(c1);
        Cos c5 = new Cos(s1);
        Cos c6 = new Cos(v1);
        Cos c7 = new Cos(e1);
        Cos c8 = new Cos(l1);
        Cos c9 = new Cos(p1);
        Cos c4 = new Cos(bo1);

        // Test #89 - Cos with Variable operand
        assertEquals(n1, c1.getOperand());

        // Test #90 - Cos with Number operand
        assertEquals(n1, c2.getOperand());

        // Test #91 - Cos with Cos operand
        assertEquals(c1, c3.getOperand());

        // Test #92 - Cos with Sin operand
        assertEquals(s1, c5.getOperand());

        // Test #93 - Cos with Variable operand
        assertEquals(v1, c6.getOperand());

        // Test #94 - Cos with Exp operand
        assertEquals(e1, c7.getOperand());

        // Test #95 - Cos with Log operand
        assertEquals(l1, c8.getOperand());

        // Test #96 - Cos with Polynomial operand
        assertEquals(p1, c9.getOperand());

        // Test #97 - Cos with BinaryOp operand
        assertEquals(bo1, c4.getOperand());

    }

    /**
     * Tests the getVal() method of Number
     */
    @Test
    public void testGetVal() {

        /** 
         * Constructor only takes double values as input so no other types
         *   will be tested
         * Delta value will be 0.0001, as that is the smallest decimal place 
         *   that exists in any of the tests 
         */
        Number n1 = new Number(1.5);
        Number n2 = new Number(-3.1);
        Number n3 = new Number(108.5679);
        Number n4 = new Number(-321.1415);
        Number n5 = new Number(0.0);
        Number n6 = new Number(0.0069);
        double delta = 0.0001;

        // Test #98 - Number with positive single digit decimal
        assertEquals(1.5, n1.getVal(), delta);

        // Test #99 - Number with negative single digit decimal
        assertEquals(-3.1, n2.getVal(), delta);

        // Test #100 - Number with positive multiple digit decimal
        assertEquals(108.5679, n3.getVal(), delta);

        // Test #101 - Number with negative multiple digit decimal
        assertEquals(-321.1415, n4.getVal(), delta);
        
        // Test #102 - Number with zeros
        assertEquals(0.0, n5.getVal(), delta);

        // Test #103 - Number with positive multiple digit decimal less than 1
        assertEquals(0.0069, n6.getVal(), delta);

    }

    /**
     * Tests the getLeftOperand() method in BinaryOp
     */
    @Test
    public void testGetLeftOperand() {
        
        // Initialize an instance of every class
        Number n1 = new Number(1.5);
        Cos c1 = new Cos(n1);
        Sin s1 = new Sin(c1);
        Variable v1 = new Variable();
        Polynomial p1 = new Polynomial(1, v1);
        Exp e1 = new Exp(s1);
        Log l1 = new Log(e1);
        BinaryOp bo1 = new BinaryOp(s1, c1, BinaryOp.Op.MULT);

        // Create the instances to be tested
        BinaryOp bo2 = new BinaryOp(n1, n1, BinaryOp.Op.DIV);
        BinaryOp bo3 = new BinaryOp(c1, n1, BinaryOp.Op.DIV);
        BinaryOp bo4 = new BinaryOp(s1, n1, BinaryOp.Op.DIV);
        BinaryOp bo5 = new BinaryOp(v1, n1, BinaryOp.Op.DIV);
        BinaryOp bo6 = new BinaryOp(p1, n1, BinaryOp.Op.DIV);
        BinaryOp bo7 = new BinaryOp(e1, n1, BinaryOp.Op.DIV);
        BinaryOp bo8 = new BinaryOp(l1, n1, BinaryOp.Op.DIV);
        BinaryOp bo9 = new BinaryOp(bo1, n1, BinaryOp.Op.DIV);

        // Test #104 - BinaryOp with a left operand of type Number
        assertEquals(n1, bo2.getLeftOperand());

        // Test #105 - BinaryOp with a left operand of type Cos
        assertEquals(c1, bo3.getLeftOperand());

        // Test #106 - BinaryOp with a left operand of type Sin
        assertEquals(s1, bo4.getLeftOperand());

        // Test #107 - BinaryOp with a left operand of type Variable
        assertEquals(v1, bo5.getLeftOperand());

        // Test #108 - BinaryOp with a left operand of type Polynomial
        assertEquals(p1, bo6.getLeftOperand());

        // Test #109 - BinaryOp with a left operand of type Exp
        assertEquals(e1, bo7.getLeftOperand());

        // Test #110 - BinaryOp with a left operand of type Log
        assertEquals(l1, bo8.getLeftOperand());

        // Test #111 - BinaryOp with a left operand of type BinaryOp
        assertEquals(bo1, bo9.getLeftOperand());

    }
    
    /**
     * Tests the getRightOperand() method in BinaryOp
     */
    @Test
    public void testGetRightOperand() {
        
        // Initialize an instance of every class
        Number n1 = new Number(1.5);
        Cos c1 = new Cos(n1);
        Sin s1 = new Sin(c1);
        Variable v1 = new Variable();
        Polynomial p1 = new Polynomial(1, v1);
        Exp e1 = new Exp(s1);
        Log l1 = new Log(e1);
        BinaryOp bo1 = new BinaryOp(s1, c1, BinaryOp.Op.MULT);

        // Create the instances to be tested
        BinaryOp bo2 = new BinaryOp(n1, n1, BinaryOp.Op.DIV);
        BinaryOp bo3 = new BinaryOp(n1, c1, BinaryOp.Op.DIV);
        BinaryOp bo4 = new BinaryOp(n1, s1, BinaryOp.Op.DIV);
        BinaryOp bo5 = new BinaryOp(n1, v1, BinaryOp.Op.DIV);
        BinaryOp bo6 = new BinaryOp(n1, p1, BinaryOp.Op.DIV);
        BinaryOp bo7 = new BinaryOp(n1, e1, BinaryOp.Op.DIV);
        BinaryOp bo8 = new BinaryOp(n1, l1, BinaryOp.Op.DIV);
        BinaryOp bo9 = new BinaryOp(n1, bo1, BinaryOp.Op.DIV);

        // Test #112 - BinaryOp with a right operand of type Number
        assertEquals(n1, bo2.getRightOperand());

        // Test #113 - BinaryOp with a right operand of type Cos
        assertEquals(c1, bo3.getRightOperand());

        // Test #114 - BinaryOp with a right operand of type Sin
        assertEquals(s1, bo4.getRightOperand());

        // Test #115 - BinaryOp with a right operand of type Variable
        assertEquals(v1, bo5.getRightOperand());

        // Test #116 - BinaryOp with a right operand of type Polynomial
        assertEquals(p1, bo6.getRightOperand());

        // Test #117 - BinaryOp with a right operand of type Exp
        assertEquals(e1, bo7.getRightOperand());

        // Test #118 - BinaryOp with a right operand of type Log
        assertEquals(l1, bo8.getRightOperand());

        // Test #119 - BinaryOp with a right operand of type BinaryOp
        assertEquals(bo1, bo9.getRightOperand());
    }

    /**
     * Tests the getOperator() method in BinaryOp
     */
    @Test
    public void testGetOperator() {

        // Initialize an operand for the BinaryOp testing instances
        Number n1 = new Number(1.5);

        // Create the BinaryOp testing instances
        BinaryOp bo1 = new BinaryOp(n1, n1, BinaryOp.Op.DIV);
        BinaryOp bo2 = new BinaryOp(n1, n1, BinaryOp.Op.MULT);
        BinaryOp bo3 = new BinaryOp(n1, n1, BinaryOp.Op.PLUS);
        BinaryOp bo4 = new BinaryOp(n1, n1, BinaryOp.Op.SUB);

        // Test #120 - BinaryOp with an operator of DIV (/)
        assertEquals(BinaryOp.Op.DIV, bo1.getOperator());

        // Test #121 - BinaryOp with an operator of MULT (*)
        assertEquals(BinaryOp.Op.MULT, bo2.getOperator());

        // Test #122 - BinaryOp with an operator of PLUS (+)
        assertEquals(BinaryOp.Op.PLUS, bo3.getOperator());

        // Test #123 - BinaryOp with an operator of SUB (-)
        assertEquals(BinaryOp.Op.SUB, bo4.getOperator());
    }

    /**
     * Tests the getPower() method in Polynomial
     */
    @Test
    public void testGetPower() {

        // Create an instance of Number to be the operand for all testing examples
        Number n1 = new Number(1.5);

        /** 
         * Constructor only takes double values as input so no other types
         *   will be tested
         * Delta value will be 0.0001, as that is the smallest decimal place 
         *   that exists in any of the tests 
         */
        Polynomial p1 = new Polynomial(1.5, n1);
        Polynomial p2 = new Polynomial(-3.1, n1);
        Polynomial p3 = new Polynomial(108.5679, n1);
        Polynomial p4 = new Polynomial(-321.1415, n1);
        Polynomial p5 = new Polynomial(0.0, n1);
        Polynomial p6 = new Polynomial(0.0069, n1);
        double delta = 0.0001;

        // Test #124 - Number with positive single digit decimal
        assertEquals(1.5, p1.getPower(), delta);

        // Test #125 - Number with negative single digit decimal
        assertEquals(-3.1, p2.getPower(), delta);

        // Test #126 - Number with positive multiple digit decimal
        assertEquals(108.5679, p3.getPower(), delta);

        // Test #127 - Number with negative multiple digit decimal
        assertEquals(-321.1415, p4.getPower(), delta);
        
        // Test #128 - Number with zeros
        assertEquals(0.0, p5.getPower(), delta);

        // Test #129 - Number with positive multiple digit decimal less than 1
        assertEquals(0.0069, p6.getPower(), delta);
    }

    /**
     * Tests the derivative() method that every class should have
     */
    @Test
    public void testDerivative() {
        
        /**
         * Number class test
         * Only double will be tested because that is the only input that Number's constructor allows
         * Derivative of a Number should always return 0.0
         * 
         */
        Number n1 = new Number(1.5);
        Number n2 = new Number(-3.1);
        Number n3 = new Number(108.5679);
        Number n4 = new Number(-321.1415);
        Number n5 = new Number(0.0);
        Number n6 = new Number(0.0069);

        // Test #130 - Derivative of Number with positive single digit decimal
        assertEquals("0.0", n1.derivative().toString());

        // Test #131 - Derivative of Number with negative single digit decimal
        assertEquals("0.0", n2.derivative().toString());

        // Test #132 - Derivative of Number with positive multiple digit decimal
        assertEquals("0.0", n3.derivative().toString());

        // Test #133 - Derivative of Number with negative multiple digit decimal
        assertEquals("0.0", n4.derivative().toString());
        
        // Test #134 - Derivative of Number with zeros
        assertEquals("0.0", n5.derivative().toString());

        // Test #135 - Derivative of Number with positive multiple digit decimal less than 1
        assertEquals("0.0", n6.derivative().toString());

        /**
         * Polynomial class test
         * Constructor only takes double values as input so no other types
         *   will be tested
         */
        Variable v1 = new Variable();
        Polynomial p1 = new Polynomial(1.5, v1);
        Polynomial p2 = new Polynomial(-3.1, v1);
        Polynomial p3 = new Polynomial(108.5679, v1);
        Polynomial p4 = new Polynomial(-321.1415, v1);
        Polynomial p5 = new Polynomial(0.0, v1);
        Polynomial p6 = new Polynomial(0.0069, v1);

        // Test #136 - Derivative of Polynomial with positive single digit decimal
        assertEquals("1.5 * x^0.5", p1.derivative().toString());

        // Test #137 - Derivative of Polynomial with negative single digit decimal
        assertEquals("-3.1 * x^-4.1", p2.derivative().toString());

        // Test #138 - Derivative of Polynomial with positive multiple digit decimal
        assertEquals("108.5679 * x^107.5679", p3.derivative().toString());

        // Test #139 - Derivative of Polynomial with negative multiple digit decimal
        assertEquals("-321.1415 * x^-322.1415", p4.derivative().toString());
        
        // Test #140 - Derivative of Polynomial with zeros
        assertEquals("0.0 * x^-1.0", p5.derivative().toString());

        // Test #141 - Derivative of Polynomial with positive multiple digit decimal less than 1
        assertEquals("0.0069 * x^-0.9931", p6.derivative().toString());

        /**
         * Variable class testing
         * Only one instance will be tested since the class's constructor takes no inputs
         * Should always return 1.0
         */
        Variable v2 = new Variable();

        // Test #142 - Derivative of Variable
        assertEquals("1.0", v2.derivative().toString());

        /**
         * Log class testing
         */

        // Create an instance of every class
        Number n7 = new Number(1.5);
        Cos c1 = new Cos(n7);
        Sin s1 = new Sin(n7);
        Variable v3 = new Variable();
        Polynomial p7 = new Polynomial(1, n7);
        Exp e1 = new Exp(n7);
        Log l1 = new Log(n7);
        BinaryOp bo1 = new BinaryOp(v3, n7, BinaryOp.Op.PLUS);

        // Create testing instances of Log
        Log l2 = new Log(n7);
        Log l3 = new Log(c1);
        Log l4 = new Log(s1);
        Log l5 = new Log(v3);
        Log l6 = new Log(p7);
        Log l7 = new Log(e1);
        Log l8 = new Log(l1);
        Log l9 = new Log(bo1);

        // Test #143 - Derivative of Log with Number as an operand
        assertEquals("(1.0 / 1.5) * (0.0)", l2.derivative().toString());
        
        // Test #144 - Derivative of Log with Cos as an operand
        assertEquals("(1.0 / Cos[1.5]) * (-1.0 * Sin[1.5]) * (0.0)", l3.derivative().toString());

        // Test #145 - Derivative of Log with Sin as an operand
        assertEquals("(1.0 / Sin[1.5]) * Cos[1.5] * 0.0", l4.derivative().toString());

        // Test #146 - Derivative of Log with Variable as an operand
        assertEquals("(1.0 / x) * (1.0)", l5.derivative().toString());

        // Test #147 - Derivative of Log with Polynomial as an operand
        assertEquals("(1.0 / 1.5^1.0) * 1.0 * 1.5^0.0", l6.derivative().toString());

        // Test #148 - Derivative of Log with Exp as an operand
        assertEquals("(1.0 / Exp[1.5]) * Exp[1.5] * 0.0", l7.derivative().toString());

        // Test #149 - Derivative of Log with Log as an operand
        assertEquals("(1.0 / Log[1.5]) * (1.0 / 1.5) * (0.0)", l8.derivative().toString());

        // Test #150 - Derivative of Log with BinaryOp as an operand
        assertEquals("(1.0 / (x + 1.5)) * (1.0 + 0.0)", l9.derivative().toString());

        /**
         * Exp class testing
         */

        // Create testing instances of Exp using the previous class instances
        Exp e2 = new Exp(n7);
        Exp e3 = new Exp(c1);
        Exp e4 = new Exp(s1);
        Exp e5 = new Exp(v3);
        Exp e6 = new Exp(p7);
        Exp e7 = new Exp(e1);
        Exp e8 = new Exp(l1);
        Exp e9 = new Exp(bo1);

        // Test #151 - Derivative of Exp with Number as an operand
        assertEquals("Exp[1.5] * 0.0", e2.derivative().toString());
        
        // Test #152 - Derivative of Exp with Cos as an operand
        assertEquals("Exp[Cos[1.5]] * (-1.0 * Sin[1.5]) * (0.0)", e3.derivative().toString());

        // Test #153 - Derivative of Exp with Sin as an operand
        assertEquals("Exp[Sin[1.5]] * Cos[1.5] * 0.0", e4.derivative().toString());

        // Test #154 - Derivative of Exp with Variable as an operand
        assertEquals("Exp[x] * 1.0", e5.derivative().toString());

        // Test #155 - Derivative of Exp with Polynomial as an operand
        assertEquals("Exp[1.5^1.0] * 1.0 * 1.5^0.0", e6.derivative().toString());

        // Test #156 - Derivative of Exp with Exp as an operand
        assertEquals("Exp[Exp[1.5]] * Exp[1.5] * 0.0", e7.derivative().toString());

        // Test #157 - Derivative of Exp with Log as an operand
        assertEquals("Exp[Log[1.5]] * (1.0 / 1.5) * (0.0)", e8.derivative().toString());

        // Test #158 - Derivative of Exp with BinaryOp as an operand
        assertEquals("Exp[x + 1.5] * (1.0 + 0.0)", e9.derivative().toString());

        /**
         * Sin class testing
         */

        // Create testing instances of Sin using the previous class instances
        Sin s2 = new Sin(n7);
        Sin s3 = new Sin(c1);
        Sin s4 = new Sin(s1);
        Sin s5 = new Sin(v3);
        Sin s6 = new Sin(p7);
        Sin s7 = new Sin(e1);
        Sin s8 = new Sin(l1);
        Sin s9 = new Sin(bo1);

        // Test #159 - Derivative of Sin with Number as an operand
        assertEquals("Cos[1.5] * 0.0", s2.derivative().toString());
        
        // Test #160 - Derivative of Sin with Cos as an operand
        assertEquals("Cos[Cos[1.5]] * (-1.0 * Sin[1.5]) * (0.0)", s3.derivative().toString());

        // Test #161 - Derivative of Sin with Sin as an operand
        assertEquals("Cos[Sin[1.5]] * Cos[1.5] * 0.0", s4.derivative().toString());

        // Test #162 - Derivative of Sin with Variable as an operand
        assertEquals("Cos[x] * 1.0", s5.derivative().toString());

        // Test #163 - Derivative of Sin with Polynomial as an operand
        assertEquals("Cos[1.5^1.0] * 1.0 * 1.5^0.0", s6.derivative().toString());

        // Test #164 - Derivative of Sin with Exp as an operand
        assertEquals("Cos[Exp[1.5]] * Exp[1.5] * 0.0", s7.derivative().toString());

        // Test #165 - Derivative of Sin with Log as an operand
        assertEquals("Cos[Log[1.5]] * (1.0 / 1.5) * (0.0)", s8.derivative().toString());

        // Test #166 - Derivative of Sin with BinaryOp as an operand
        assertEquals("Cos[x + 1.5] * (1.0 + 0.0)", s9.derivative().toString());

        /**
         * Cos class testing
         */

        // Create testing instances of Cos using the previous class instances
        Cos c2 = new Cos(n7);
        Cos c3 = new Cos(c1);
        Cos c4 = new Cos(s1);
        Cos c5 = new Cos(v3);
        Cos c6 = new Cos(p7);
        Cos c7 = new Cos(e1);
        Cos c8 = new Cos(l1);
        Cos c9 = new Cos(bo1);

        // Test #167 - Derivative of Cos with Number as an operand
        assertEquals("(-1.0 * Sin[1.5]) * (0.0)", c2.derivative().toString());
        
        // Test #168 - Derivative of Cos with Cos as an operand
        assertEquals("(-1.0 * Sin[Cos[1.5]]) * (-1.0 * Sin[1.5]) * (0.0)", c3.derivative().toString());

        // Test #169 - Derivative of Cos with Sin as an operand
        assertEquals("(-1.0 * Sin[Sin[1.5]]) * Cos[1.5] * 0.0", c4.derivative().toString());

        // Test #170 - Derivative of Cos with Variable as an operand
        assertEquals("(-1.0 * Sin[x]) * (1.0)", c5.derivative().toString());

        // Test #171 - Derivative of Cos with Polynomial as an operand
        assertEquals("(-1.0 * Sin[1.5^1.0]) * 1.0 * 1.5^0.0", c6.derivative().toString());

        // Test #172 - Derivative of Cos with Exp as an operand
        assertEquals("(-1.0 * Sin[Exp[1.5]]) * Exp[1.5] * 0.0", c7.derivative().toString());

        // Test #173 - Derivative of Cos with Log as an operand
        assertEquals("(-1.0 * Sin[Log[1.5]]) * (1.0 / 1.5) * (0.0)", c8.derivative().toString());

        // Test #174 - Derivative of Cos with BinaryOp as an operand
        assertEquals("(-1.0 * Sin[x + 1.5]) * (1.0 + 0.0)", c9.derivative().toString());

        /**
         * BinaryOp class testing
         * There are 2 tests regarding each of the 4 operators
         */

        // Create instances of BinaryOps to use for testing
        BinaryOp bo2 = new BinaryOp(v3, n7, BinaryOp.Op.PLUS);
        BinaryOp bo3 = new BinaryOp(v3, c1, BinaryOp.Op.PLUS);
        BinaryOp bo4 = new BinaryOp(v3, s1, BinaryOp.Op.SUB);
        BinaryOp bo5 = new BinaryOp(v3, v3, BinaryOp.Op.SUB);
        BinaryOp bo6 = new BinaryOp(v3, p7, BinaryOp.Op.MULT);
        BinaryOp bo7 = new BinaryOp(v3, e1, BinaryOp.Op.MULT);
        BinaryOp bo8 = new BinaryOp(v3, l1, BinaryOp.Op.DIV);
        BinaryOp bo9 = new BinaryOp(v3, bo1, BinaryOp.Op.DIV);

        // Test #175 - Derivative of BinaryOp with Number as an operand
        assertEquals("1.0 + 0.0", bo2.derivative().toString());
        
        // Test #176 - Derivative of BinaryOp with Cos as an operand
        assertEquals("1.0 + ((-1.0 * Sin[1.5]) * (0.0))", bo3.derivative().toString());

        // Test #177 - Derivative of BinaryOp with Sin as an operand
        assertEquals("1.0 - (Cos[1.5] * 0.0)", bo4.derivative().toString());

        // Test #178 - Derivative of BinaryOp with Variable as an operand
        assertEquals("1.0 - 1.0", bo5.derivative().toString());

        // Test #179 - Derivative of BinaryOp with Polynomial as an operand
        assertEquals("(x * 1.0 * 1.5^0.0) + (1.0 * 1.5^1.0)", bo6.derivative().toString());

        // Test #180 - Derivative of BinaryOp with Exp as an operand
        assertEquals("(x * Exp[1.5] * 0.0) + (1.0 * Exp[1.5])", bo7.derivative().toString());

        // Test #181 - Derivative of BinaryOp with Log as an operand
        assertEquals("((Log[1.5] * 1.0) - (x * (1.0 / 1.5) * (0.0))) / (Log[1.5]^2.0)", bo8.derivative().toString());

        // Test #182 - Derivative of BinaryOp with BinaryOp as an operand
        assertEquals("(((x + 1.5) * (1.0)) - (x * (1.0 + 0.0))) / ((x + 1.5)^2.0)", bo9.derivative().toString());
        
    }

    /** 
     * Tests the value() method that every class should have
     */
    @Test
    public void testValue() {

        /** Any variance between the expected and actual value should be less than 0.0001 */
        double delta = 0.0001;

        /**
         * Number class testing
         */

        // Create testing instances of Number
        Number n1 = new Number(1.5);
        Number n2 = new Number(-58.34);

        // Test #183 - Value of a positive Number
        assertEquals(1.5, n1.value(), delta);
        
        // Test #184 - Value of a negative Number
        assertEquals(-58.34, n2.value(), delta);

        /**
         * Variable class testing
         * Any tests here should throw an exception because a value is needed for substitution
         */

        // Create testing instances of Variable
        Variable v1 = new Variable();

        // Test #185 - Value of a Variable
        boolean throwsError = false;
        try {
            v1.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

        /**
         * Polynomial class testing
         */

        // Create testing instances of Polynomial
        Polynomial p1 = new Polynomial(0.5, new Number(9.0));
        Polynomial p2 = new Polynomial(3, new Number(3.0));
        Polynomial p3 = new Polynomial(5, v1);

        // Test #186 - Value of a Polynomial that has a Power less than 1
        assertEquals(3.0, p1.value(), delta);

        // Test #187 - Value of a Polynomial that has a Power greater than 1
        assertEquals(27.0, p2.value(), delta);

        // Test #188 - Value of a Polynomial with a Variable
        //      Should throw an UnsupportedOperationException error
        throwsError = false;
        try {
            p3.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

        /**
         * Log class testing
         *      All inputs must be positive since you cannot take the logarithm of a number less than 0
         */

        // Create testing instances of Log
        Log l1 = new Log(new Number(1.0));
        Log l2 = new Log(p2);
        Log l3 = new Log(v1);
        Log l4 = new Log(new Number(-1.0));

        // Test #189 - Value of a Log that has a small operand
        assertEquals(0.0, l1.value(), delta);

        // Test #190 - Value of a Log that has a larger operand
        assertEquals(Math.log(27.0), l2.value(), delta);

        // Test #191 - Value of a Log with a Variable
        //      Should throw an UnsupportedOperationException error
        throwsError = false;
        try {
            l3.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

        // Test #192 - Value of a Log with a negative Number
        //      Should return a NaN value
        boolean isNaN = Double.isNaN(l4.value()); 
        assertTrue(isNaN);

        /**
         * Exp class testing
         */

        // Create testing instances of Exp
        Exp e1 = new Exp(new Number(-3.14));
        Exp e2 = new Exp(p2);
        Exp e3 = new Exp(l1);
        Exp e4 = new Exp(v1);

        // Test #193 - Value of an Exp that has an operand of a negative Number
        assertEquals(Math.exp(-3.14), e1.value(), delta);

        // Test #194 - Value of an Exp that has an operand of a positive Number
        assertEquals(Math.exp(27.0), e2.value(), delta);

        // Test #195 - Value of an Exp that has an operand of zero
        assertEquals(1.0, e3.value(), delta);

        // Test #196 - Value of an Exp with a Variable
        //      Should throw an UnsupportedOperationException error
        throwsError = false;
        try {
            e4.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

        /**
         * Sin class testing
         */

        // Create testing instances of Sin
        Sin s1 = new Sin(new Number(-Math.PI));
        Sin s2 = new Sin(new Number(4.0));
        Sin s3 = new Sin(l1);
        Sin s4 = new Sin(p2);
        Sin s5 = new Sin(new BinaryOp(new Number(2.0), v1, BinaryOp.Op.MULT));

        // Test #197 - Value of Sin that has a negative operand
        assertEquals(0.0, s1.value(), delta);

        // Test #198 - Value of Sin that has a positive operand
        assertEquals(Math.sin(4.0), s2.value(), delta);

        // Test #199 - Value of Sin that has an operand of zero
        assertEquals(0.0, s3.value(), delta);

        // Test #200 - Value of Sin that has a Polynomial operand
        assertEquals(Math.sin(27), s4.value(), delta);

        // Test #201 - Value of Sin with a Variable
        //      Should throw an UnsupportedOperationException error
        throwsError = false;
        try {
            s5.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

        /**
         * Cos class testing
         */

        // Create testing instances of Cos
        Cos c1 = new Cos(new Number(-Math.PI));
        Cos c2 = new Cos(new Number(4.0));
        Cos c3 = new Cos(l1);
        Cos c4 = new Cos(p2);
        Cos c5 = new Cos(new BinaryOp(new Number(2.0), v1, BinaryOp.Op.MULT));

        // Test #202 - Value of Cos that has a negative operand
        assertEquals(-1.0, c1.value(), delta);

        // Test #203 - Value of Cos that has a positive operand
        assertEquals(Math.cos(4.0), c2.value(), delta);

        // Test #204 - Value of Cos that has an operand of zero
        assertEquals(1.0, c3.value(), delta);

        // Test #205 - Value of Cos that has a Polynomial operand
        assertEquals(Math.cos(27), c4.value(), delta);

        // Test #206 - Value of Cos with a Variable
        //      Should throw an UnsupportedOperationException error
        throwsError = false;
        try {
            c5.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

        /**
         * BinaryOp class testing
         * 3 testing instances for each operator
         */

        // Create testing instances of BinaryOp
        BinaryOp bo1 = new BinaryOp(new Number(2.0), new Number(27.3), BinaryOp.Op.PLUS);
        BinaryOp bo2 = new BinaryOp(new Polynomial(3.0, new Number(1.85)), new Polynomial(-5.5, new Number(4.53)), BinaryOp.Op.PLUS);
        BinaryOp bo3 = new BinaryOp(new Log(new Number(4.78)), new Log(new Number(3.141591)), BinaryOp.Op.SUB);
        BinaryOp bo4 = new BinaryOp(new Exp(new Number(0.01)), new Exp(new Number(-6.93)), BinaryOp.Op.SUB);
        BinaryOp bo5 = new BinaryOp(new Sin(new Number(Math.PI)), new Sin(new Log(new Number(4.78))), BinaryOp.Op.MULT);
        BinaryOp bo6 = new BinaryOp(new Cos(new Polynomial(3.0, new Number(1.85))), new Cos(new Number(27.3)), BinaryOp.Op.MULT);
        BinaryOp bo7 = new BinaryOp(new Polynomial(2.0, new Number(Math.PI)), new Number(27.3), BinaryOp.Op.DIV);
        BinaryOp bo8 = new BinaryOp(new Exp(new Number(-6.93)), new Log(new Number(4.78)), BinaryOp.Op.DIV);
        BinaryOp bo9 = new BinaryOp(new Number(2.0), new Exp(v1), BinaryOp.Op.PLUS);
        BinaryOp bo10 = new BinaryOp(new Number(2.0), new Exp(v1), BinaryOp.Op.SUB);
        BinaryOp bo11 = new BinaryOp(new Number(2.0), new Exp(v1), BinaryOp.Op.MULT);
        BinaryOp bo12 = new BinaryOp(new Number(2.0), new Exp(v1), BinaryOp.Op.DIV);

        // Test #207 - Value of BinaryOp that has Number operands
        assertEquals(29.3, bo1.value(), delta);

        // Test #208 - Value of BinaryOp that has Polynomial operands
        assertEquals(6.331871297, bo2.value(), delta);

        // Test #209 - Value of BinaryOp that has Log operands
        assertEquals(0.419711187, bo3.value(), delta);

        // Test #210 - Value of BinaryOp that has Exp operands
        assertEquals(1.009072166, bo4.value(), delta);

        // Test #211 - Value of BinaryOp that has Sin operands
        assertEquals(0.0, bo5.value(), delta);

        // Test #212 - Value of BinaryOp that has Cos operands
        assertEquals(-0.5610603946, bo6.value(), delta);

        // Test #213 - Value of BinaryOp that has Polynomial and Number operands
        assertEquals(0.3615239707, bo7.value(), delta);

        // Test #214 - Value of BinaryOp that has Exp and Log operands
        assertEquals(0.0006251442, bo8.value(), delta);

        // Test #215 - Value of BinaryOp with a Variable when added
        //      Should throw an UnsupportedOperationException error
        throwsError = false;
        try {
            bo9.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

        // Test #216 - Value of BinaryOp with a Variable when subtracted
        //      Should throw an UnsupportedOperationException error
        throwsError = false;
        try {
            bo10.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

        // Test #217 - Value of BinaryOp with a Variable when multiplied
        //      Should throw an UnsupportedOperationException error
        throwsError = false;
        try {
            bo11.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

        // Test #218 - Value of BinaryOp with a Variable when divided
        //      Should throw an UnsupportedOperationException error
        throwsError = false;
        try {
            bo12.value();
        }
        catch (UnsupportedOperationException e) {
            throwsError = true;
        }
        assertTrue(throwsError);

    }

    /**
     * Tests the value(double d) method that every class should have
     */
    @Test
    public void testValueWithInputs() {

        // Create a new Variable instance to use in the following tests
        Variable v1 = new Variable();

        /** Any variance between the expected and actual value should be less than 0.0001 */
        double delta = 0.0001;

        /**
         * Number class testing
         * Only accepts doubles as constructor values
         */

        // Create testing instances of Number
        Number n1 = new Number(1.5);

        // Test #219 - Value of Number with Variable substitution
        assertEquals(1.5, n1.value(2.0), delta);

        /**
         * Variable class testing
         * Constructor takes no inputs so only one unique instance of Variable
         *      can be created
         */

        // Create testing instances of Variable
        Variable v2 = new Variable();

        // Test #220 - Value of Variable with Variable substitution
        assertEquals(2.0, v2.value(2.0), delta);

        /**
         * Polynomial class testing
         */

        // Create testing instances of Polynomial
        Polynomial p1 = new Polynomial(3.0, v2);

        // Test #221 - Value of Polynomial with Variable substitution
        assertEquals(64.0, p1.value(4.0), delta);

        /**
         * Log class testing
         */

        // Create testing instances of Log
        Log l1 = new Log(v1);
        Log l2 = new Log(p1);

        // Test #222 - Value of Log with Variable substitution
        assertEquals(1.609437912, l1.value(5.0), delta);

        // Test #223 - Value of Log with Variable substitution
        assertEquals(4.828313737, l2.value(5.0), delta);

        /**
         * Exp class testing
         */

        // Create testing instances of Exp
        Exp e1 = new Exp(v1);
        Exp e2 = new Exp(p1);
        
        // Test #224 - Value of Exp with Variable substitution
        assertEquals(12.18249396, e1.value(2.5), delta);

        // Test #225 - Value of Exp with Variable substitution
        assertEquals(6107328.4908967, e2.value(2.5), delta);

        /**
         * Sin class testing
         */

        // Create testing instances of Sin
        Sin s1 = new Sin(v1);
        Sin s2 = new Sin(p1);

        // Test #226 - Value of Sin with Variable substitution
        assertEquals(0.0, s1.value(Math.PI), delta);

        // Test #227 - Value of Sin with Variable substitution
        assertEquals(-0.3982881788, s2.value(Math.PI), delta);

        /**
         * Cos class testing
         */

        // Create testing instances of Cos
        Cos c1 = new Cos(v1);
        Cos c2 = new Cos(p1);
        
        // Test #228 - Value of Cos with Variable substitution
        assertEquals(1.0, c1.value(2 * Math.PI), delta);

        // Test #229 - Value of Cos with Variable substitution
        assertEquals(-0.9908195617, c2.value(2 * Math.PI), delta);

        /**
         * BinaryOp class testing
         */

        // Create testing instances of BinaryOp
        BinaryOp bo1 = new BinaryOp(new BinaryOp(new Number(2.0), v1, BinaryOp.Op.PLUS), new Number(27.3), BinaryOp.Op.PLUS);
        BinaryOp bo2 = new BinaryOp(new Polynomial(3.0, new Number(1.85)), new Polynomial(-5.5, new BinaryOp(new Number(4.53), v1, BinaryOp.Op.PLUS)), BinaryOp.Op.PLUS);
        BinaryOp bo3 = new BinaryOp(new Log(new BinaryOp(v1, new Number(4.78), BinaryOp.Op.SUB)), new Log(new Number(3.141591)), BinaryOp.Op.SUB);
        BinaryOp bo4 = new BinaryOp(new Exp(new BinaryOp(v1, new Number(0.01), BinaryOp.Op.SUB)), new Exp(new Number(-6.93)), BinaryOp.Op.SUB);
        BinaryOp bo5 = new BinaryOp(new Sin(new Number(Math.PI)), new Sin(new Log(new BinaryOp(new Number(4.78), v1, BinaryOp.Op.MULT))), BinaryOp.Op.MULT);
        BinaryOp bo6 = new BinaryOp(new Cos(new Polynomial(3.0, new BinaryOp(new Number(1.85), v1, BinaryOp.Op.MULT))), new Cos(new Number(27.3)), BinaryOp.Op.MULT);
        BinaryOp bo7 = new BinaryOp(new Polynomial(2.0, new Number(Math.PI)), new BinaryOp(new Number(27.3), v1, BinaryOp.Op.DIV), BinaryOp.Op.DIV);
        BinaryOp bo8 = new BinaryOp(new Exp(new Number(-6.93)), new Log(new BinaryOp(v1, new Number(4.78), BinaryOp.Op.DIV)), BinaryOp.Op.DIV);
        
        // Test #230 - Value of BinaryOp with Variable substitution
        assertEquals(38.1, bo1.value(8.8), delta);

        // Test #231 - Value of BinaryOp with Variable substitution
        assertEquals(6.331625651, bo2.value(8.8), delta);

        // Test #232 - Value of BinaryOp with Variable substitution
        assertEquals(0.2465525431, bo3.value(8.8), delta);

        // Test #233 - Value of BinaryOp with Variable substitution
        assertEquals(6568.231197, bo4.value(8.8), delta);

        // Test #234 - Value of BinaryOp with Variable substitution
        assertEquals(0.0, bo5.value(8.8), delta);

        // Test #235 - Value of BinaryOp with Variable substitution
        assertEquals(0.0852515425, bo6.value(8.8), delta);

        // Test #236 - Value of BinaryOp with Variable substitution
        assertEquals(3.181410942, bo7.value(8.8), delta);

        // Test #237 - Value of BinaryOp with Variable substitution
        assertEquals(0.0016024627, bo8.value(8.8), delta);

    }


}
