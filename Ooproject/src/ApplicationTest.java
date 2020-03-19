import exceptions.NegativeDiscriminant;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    @org.junit.jupiter.api.Test
    void calculateRoots() {
        //make sure negative discriminant is detected
        Polynomial unsolvablePolynomial = new Polynomial(new Number(1), new Number(2), new Number(2));
        assertThrows(NegativeDiscriminant.class, () -> {
            Application.calculateRoots(unsolvablePolynomial);
        });
        Polynomial solvablePolynomial = new Polynomial(new Number(1), new Number(1), new Number(-2));
        try {
            Number[] roots =  Application.calculateRoots(solvablePolynomial);
            assertTrue((roots[0].number == 1 && roots[1].number == -2) || (roots[0].number == -2 && roots[1].number == 1));
        } catch (NegativeDiscriminant negativeDiscriminant) {
            fail();
        }
    }
}