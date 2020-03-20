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
//                    I know this input is weird,
//                    but the entire idea to rename double to "number" without any new functionality is weird
//                    So I'm leaving it like that until questioned (hopefully forever)
                    a.number = scanner.nextDouble();
                    System.out.println("Input coefficient b: ");
                    b.number = scanner.nextDouble();
                    System.out.println("Input coefficient c: ");
                    c.number = scanner.nextDouble();
                    break;
                case 2:
                    var rootCalcPolynomial = new Polynomial(a, b, c);
                    try {
                        Number[] roots = Polynomial.calculateRoots(rootCalcPolynomial);
                        if (roots[0].number == roots[1].number) System.out.println("The only root is " + roots[0].asString());
                        else System.out.println("The first root is " + roots[0].asString() + ", and the second one is " + roots[1].asString());
                    } catch (NegativeDiscriminant negativeDiscriminant) {
                        System.out.println("There are no real roots for this one:(");
                    }
                    break;
                case 3:
                    System.out.println("Please input an argument of the polynomial: ");
                    var argument = new Number(scanner.nextDouble());
                    var calcValuePolynomial = new Polynomial(a, b, c);
                    Number calculatedValue = Polynomial.calculateValue(calcValuePolynomial, argument);
                    System.out.println("With the argument "+ argument.asString() + ", the value of the polynomial is " + calculatedValue.asString());
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
}

