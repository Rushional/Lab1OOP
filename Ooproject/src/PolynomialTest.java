import exceptions.NegativeDiscriminant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    @Test
    void calculateRoots() {
        //make sure negative discriminant is detected
        Polynomial unsolvablePolynomial = new Polynomial(new Number(1), new Number(2), new Number(2));
        assertThrows(NegativeDiscriminant.class, () -> {
            Polynomial.calculateRoots(unsolvablePolynomial);
        });
        //assert that roots are calculated correctly
        Polynomial solvablePolynomial = new Polynomial(new Number(1), new Number(1), new Number(-2));
        try {
            Number[] roots =  Polynomial.calculateRoots(solvablePolynomial);
            assertTrue((roots[0].number == 1 && roots[1].number == -2) || (roots[0].number == -2 && roots[1].number == 1));
        } catch (NegativeDiscriminant negativeDiscriminant) {
            fail();
        }
    }
}