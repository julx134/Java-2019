/**
 *
 * @author Jules Gammad
 */

public class Counter {
    //Instance variables here
    int modulus, digit; //instance variables that wil be used in the methods
    Counter left; //reference object variable for any neighbouring Counter object
    
    public Counter(int modulus, Counter left) {
        //intialize instance variables
        this.modulus = modulus;
        this.digit = 0;
        //make this.left a reference var to Counter object passed through the parameter
        this.left = left;
        //method to convert getCount() to string
        toString();
    }


    /**
     * @return the modulus
     */
    public int getModulus() {
        return modulus; 
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() {
        //if left referance var is not null then return the Counter object assigned to left
        if (left != null)
            return left;
       //otherwise, make getLeft null
        else
            return null;
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return digit;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        //assigns instance variable digit to whatever value is passed to the parameter
        this.digit = digit; 
    }
        

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() {
        //compares this.digit to the modulus
        if (digit < getModulus()-1) { //Modulus is offset by -1 because digit starts at 0
            setDigit(digit+1); //increment digit by 1
        }else{ //if digit is more than or equal to modulus run code
            //sets the digit to 0
            setDigit(0);
            //if the reference object variable is not null, run the increment method in its class
             if (this.left != null)
                left.increment();
        }
       
        
    }

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        //if there is a neighbouring Counter object, do the operations as described in the lab
        if (left != null)
            return (left.getDigit()*left.getModulus()) + getDigit();
        else //otherwise getCount() will only return the digit of the object
            return (getDigit());
    }

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}