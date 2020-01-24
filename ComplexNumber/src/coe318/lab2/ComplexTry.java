package coe318.lab2;
/**
 * Do <b>NOT</b> modify this class.
 * Its output will be used as part
 * of the marking procedure for this lab.
 * @author Jules Gammad
 */
public class ComplexTry {
    public static void main(String[] args) {
        ComplexNumber a, b, c, d, e, f, g, h;
        a = new ComplexNumber(1, 2);
        System.out.println("a = " + a);
        b = a.negate();
        System.out.println("b (-a) = " + b);
        c = new ComplexNumber(2, 3);
        System.out.println("c = " + c);
        d = a.add(c);
        System.out.println("d (a + c) = " + d);
        e = a.subtract(c);
        System.out.println("e (a - c) = " + e);
        f = a.reciprocal();
        System.out.println("f (1 / a) = " + f);
        g = a.divide(c);
        System.out.println("g (a / c) = " + g);
        h = a.multiply(c);
        System.out.println("h (a * c) = " + h);
    }
}