package coe318.lab2;
/**
 * ComplexNumber models a complex number expressed
 * in rectangular form (real and imaginary parts).
 * It is an <em>immutable</em> object.
 *
 * @author Jules Gammad
 */

public class ComplexNumber {
  private double re, im; //variable names corresponding to real and imaginary
  
  public ComplexNumber(double re, double im) {
      this.re = re; //assignment of instance variables
      this.im = im;
      toString(); //everytime the object is called, run toString() method
  }

  public double getReal() {
      return re;  //returns the real part
  }

  public double getImaginary() {
      return im;  //returns the imaginary part
  }

  public ComplexNumber negate() {
      //to negate, reverse the sign of the parameters
      return new ComplexNumber(-re, -im); //put the opposite the sign of the re and im accordingly
  }

  public ComplexNumber add(ComplexNumber z) {
      //to add, just take the integer value of each component and sum them
      return new ComplexNumber(re + z.getReal(), im + z.getImaginary()); // uses the '.' operator to access the re and im of the object passed in the parameter
  }

  public ComplexNumber subtract(ComplexNumber z) {
      //to subtract, just take the integer value of each component and take the difference
      return new ComplexNumber(re - z.getReal(),im - z.getImaginary());  //uses the '.' operator to access the re and im of the object passed in the parameter
  }

  public ComplexNumber multiply(ComplexNumber z) {
      //to multiply, distribute the two complex number and sum accordinly
      return new ComplexNumber (reComponent(z), imComponent(z)); //uses 2 methods for the real and imaginary component accordinly, and pass the values into the parameter
  }

  public ComplexNumber reciprocal() {
      //to find the reciprocal, divid the integer value of each component by the square sum of the integer value of each component 
      double denominator = (re*re +im*im); //double variable that takes the square sum of the integer value of each component
      return new ComplexNumber(re/denominator, (-im)/denominator); //pass the components divided by the denominator value into the parameters.
  }

  public ComplexNumber divide(ComplexNumber z) {
      //to divide, multiply the numerator by the conjugate of the denominator and divide it by the square sum of the denominator
      double denominator = (z.getReal()*z.getReal() + z.getImaginary()*z.getImaginary()); //variable for the square sum of the denominator which in this case is the passed object
      ComplexNumber conjugate = new ComplexNumber(z.getReal(),-(z.getImaginary())); //create a conjugate of the denominator by creaing a new ComplexNumber object
      return new ComplexNumber(reComponent(conjugate)/denominator, imComponent(conjugate)/denominator); //use the same steps of the multiply method and divide method
      
  }
  //Using the distrivutive propery via FOIL, the real component between two complex numbers is F and -L of FOIL
  public double reComponent (ComplexNumber z) {
      return (re*z.getReal())+(-(im*z.getImaginary())); 
  }
  //the im component is the O and I of FOIL
  public double imComponent (ComplexNumber z) {
      return (im*z.getReal())+(re*z.getImaginary());
  }

  @Override
  public String toString() {
      //DO NOT MODIFY THIS CODE!
      String str = "" + this.getReal();
      if (this.getImaginary() == 0.0) {
          return str;
      }
      if (this.getImaginary() > 0) {
          return str + " + i" + this.getImaginary();
      } else {
          return str + " - i" + -this.getImaginary();
      }
  }
}