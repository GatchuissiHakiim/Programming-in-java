// File: lab01/src/test/java/agh/ii/prinjava/lab01/lst01_03/CircleTest.java
package agh.ii.prinjava.lab01.lst01_03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void Area() {
        Circle circle = new Circle(5);
        assertEquals(Math.PI * 25, circle.area(), 0.0001);
    }

    @Test
    void Perimeter() {
        Circle circle = new Circle(5);
        assertEquals(2 * Math.PI * 5, circle.perimeter(), 0.0001);
    }

    @Test
    void IsFilled() {
        Circle circle = new Circle(5, true);
        assertTrue(circle.isFilled());
    }

    @Test
    void SetFilled() {
        Circle circle = new Circle(5, false);
        circle.setFilled(true);
        assertTrue(circle.isFilled());
    }
}