import exceptions.NegativeDiscriminant;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Polynomial {
//    When add a math class, I'll make this package-private
    private Number a, b, c;

    public Polynomial(Number a, Number b, Number c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void showPolynomial() {
        System.out.println(a.number + "x^2 + " + b.number + "x + " + c.number);
    }

    //If I need roots amount, I can call x.length
//    I'd probably create another class called RootsCalculator or something like that have this method public there
    public static Number[] calculateRoots(Polynomial polynomial) throws NegativeDiscriminant {
        var roots = new Number[2];
        var discriminant = new Number(pow(polynomial.b.number, 2) - 4 * polynomial.a.number * polynomial.c.number);
        if (discriminant.number < 0) throw new NegativeDiscriminant();
        roots[0] = new Number((-polynomial.b.number + sqrt(discriminant.number))
                / (2 * polynomial.a.number));
        if (discriminant.number == 0) roots[1] = roots[0];
        else roots[1] = new Number((-polynomial.b.number - sqrt(discriminant.number))
                / (2 * polynomial.a.number));
        return roots;
    }

    public static Number calculateValue(Polynomial polynomial, Number argument) {
        return new Number(polynomial.a.number * pow(argument.number, 2) + polynomial.b.number * argument.number + polynomial.c.number);
    }
}
