public class Polynomial {
    private Number a, b, c;

    public Polynomial(Number a, Number b, Number c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    //If I need roots amount, I can call x.length
    public Number[] calcRoots() {
        var roots = new Number[2];
        roots[0] = new Number(1);
        roots[1] = new Number(-1);
        return roots;
    }

    public void showPolynomial() {
        System.out.println(a.number + "x^2 + " + b.number + "x + " + c.number);
    }
}
