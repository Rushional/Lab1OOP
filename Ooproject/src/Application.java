import java.util.Scanner;

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
                    Number[] roots = rootCalcPolynomial.calcRoots();
                    System.out.println("roots[0] = " + roots[0].number + ", roots[1] = " + roots[1].number);
                    break;
                case 3:
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
        System.out.println("2) Roots");
        System.out.println("0) Exit");
    }
}

