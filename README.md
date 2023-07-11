# Calculator

The following classes are part of the calculator project:
- BinaryOp
- CalculatorFunctions
- Cos
- Exp
- Log
- Number
- Polynomial
- Sin
- TrigFunctions
- Variable

There are 8 main kinds of functions and mathematical objects:<br>
_Variable, Number, BinaryOp, Polynomial, Log, Exp, Sin, and Cos_<br>
The value and derivative can be found for each of these 8 types of functions and mathematical objects. Attempting to find the value of a function with a variable in it will throw an `UnsupportedOperationException`.

These are descriptions for each of the 8 main functions and mathematical objects:
- Variable: represents the variable `x`
- Number: represents a number as a `double`
- BinaryOp: represents a binary operator (+, -, *, /) and two function operands
- Polynomial: represents a function raised to a power
- Log: represents the natural logarithm function
- Exp: represents the natural exponential function
- Sin: represents the sine function
- Cos: represents the cosine function

The two files that relate to the JUnit testing of this project are:
- Calculator Classes Testing Document
- Calculator Testing Class

The testing class contains 230+ JUnit tests for the calculator's functions, ensuring that it has incredible functionality. The testing document gives short descriptions of every JUnit test that I ran.
