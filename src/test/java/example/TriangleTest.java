package example;

import org.example.Triangle;
import org.example.TriangleException;
import org.example.TriangleKind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class TriangleTest {

    @Test
    public void equilateralTriangleHaveEqualSides() throws Exception {
        Triangle triangle = new Triangle(2, 2, 2);

        assertEquals(TriangleKind.EQUILATERAL, triangle.getKind());
    }

    @Test
    public void isoscelesTriangleHasTwoEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(1,2,2);

        assertEquals(TriangleKind.ISOSCELES, triangle.getKind());
    }

    @Test
    public void scaleneHasNoEqualSides() throws TriangleException {
        Triangle triangle = new Triangle(3,4,5);

        assertEquals(TriangleKind.SCALENE, triangle.getKind());
    }

    @Test
    public void InvalidTriangleThrowErrorViolatesTriangleInequality() throws  TriangleException{
        assertThrows(TriangleException.class,
                () -> {
                    Triangle triangle = new Triangle(1,2,3);
                });
    }

    @Test
    public void InvalidTriangleThrowErrorAllSidesEqualZero() throws  TriangleException{
        assertThrows(TriangleException.class,
                () -> {
                    Triangle triangle = new Triangle(0,0,0);
                });
    }

    @Test
    public void InvalidTriangleThrowErrorImpossibleSides() throws TriangleException{
        assertThrows(TriangleException.class,
                () -> {
                    Triangle triangle = new Triangle(-15,-15,-15);
                });
    }
}