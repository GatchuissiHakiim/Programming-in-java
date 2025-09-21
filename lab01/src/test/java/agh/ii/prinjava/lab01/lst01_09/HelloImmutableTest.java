package agh.ii.prinjava.lab01.lst01_09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloImmutableTest {

    @Test
    void testHelloImmutableCreation() {
        HelloImmutable hi = new HelloImmutable(42, "Test");
        assertEquals(42, hi.getI1());
        assertEquals("Test", hi.getS1());
    }

    @Test
    void testHelloImmutableEquality() {
        HelloImmutable hi1 = new HelloImmutable(42, "Test");
        HelloImmutable hi2 = new HelloImmutable(42, "Test");
        assertEquals(hi1, hi2);
        assertEquals(hi1.hashCode(), hi2.hashCode());
    }

    @Test
    void testHelloImmutableToString() {
        HelloImmutable hi = new HelloImmutable(42, "Test");
        assertEquals("HelloImmutable{i1=42, s1='Test'}", hi.toString());
    }
}