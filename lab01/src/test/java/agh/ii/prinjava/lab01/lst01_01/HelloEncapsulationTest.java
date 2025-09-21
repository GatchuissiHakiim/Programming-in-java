package agh.ii.prinjava.lab01.lst01_01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloEncapsulationTest {

    @Test
    void getPropVal() {
        HelloEncapsulation obj = new HelloEncapsulation(10);
        assertEquals(10, obj.getPropVal());
    }

    @Test
    void setPropVal() {
        HelloEncapsulation obj = new HelloEncapsulation(10);
        obj.setPropVal(20);
        assertEquals(20, obj.getPropVal());
    }

    @Test
    void isEncapsulated() {
        HelloEncapsulation obj = new HelloEncapsulation(10);
        assertTrue(obj.isEncapsulated());
    }
}