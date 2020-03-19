import exceptions.NegativeDiscriminant;

import java.util.Scanner;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Application {
    public void run() {
        int userInput = 1;
        var a = new Number(1);
        var b = new Number(2);
        var c = new Number(1);
        while (userInput != 0) {
            showUserOptions();
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();
            if (userInput == 0) break;
            switch (userInput) {
                case 1:
                    System.out.println("Input coefficient a: ");
                    a.number = scanner.nextDouble();
                    System.out.println("Input coefficient b: ");
                    b.number = scanner.nextDouble();
                    System.out.println("Input coefficient c: ");
                    c.number = scanner.nextDouble();
                    break;
                case 2:
                    var rootCalcPolynomial = new Polynomial(a, b, c);
                    try {
                        Number[] roots = calculateRoots(rootCalcPolynomial);
                        if (roots[0].number == roots[1].number) System.out.println("The only root is " + roots[0].number);
                        else System.out.println("The first root is " + roots[0].number + ", and the second one is " + roots[1].number);
                    } catch (NegativeDiscriminant negativeDiscriminant) {
                        System.out.println("There are no real roots for this one:(");
                    }
                    break;
                case 3:
                    System.out.println("Please input an argument of the polynomial: ");
                    var argument = new Number(scanner.nextDouble());
                    var calcValuePolynomial = new Polynomial(a, b, c);
                    Number calculatedValue = calculateValue(calcValuePolynomial, argument);
                    System.out.println("With the argument "+ argument.number + ", the value of the polynomial is " + calculatedValue.number);
                    break;
                case 4:
                    var outputPolynomial = new Polynomial(a, b, c);
                    outputPolynomial.showPolynomial();
                    break;
                default:
                    break;
            }
        }
    }

    private static void showUserOptions() {
        System.out.println("1) Input polynomial coefficients");
        System.out.println("2) Calculate roots of the polynomial");
        System.out.println("3) Calculate value of a polynomial");
        System.out.println("4) Output a polynomial");
        System.out.println("0) Exit");
    }

    //If I need roots amount, I can call x.length
//    I'd probably create another class called RootsCalculator or something like that have this method public there
    static Number[] calculateRoots(Polynomial polynomial) throws NegativeDiscriminant{
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

    private static Number calculateValue(Polynomial polynomial, Number argument) {
        return new Number(polynomial.a.number * pow(argument.number, 2) + polynomial.b.number * argument.number + polynomial.c.number);
    }
}

