public class Polynomial {
    public Number a, b, c;

    public Polynomial(Number a, Number b, Number c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void showPolynomial() {
        System.out.println(a.number + "x^2 + " + b.number + "x + " + c.number);
    }
}
