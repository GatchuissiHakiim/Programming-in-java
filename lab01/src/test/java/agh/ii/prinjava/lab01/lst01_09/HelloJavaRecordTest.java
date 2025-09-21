package agh.ii.prinjava.lab01.lst01_09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloJavaRecordTest {

    @Test
    void testHelloJavaRecordCreation() {
        HelloJavaRecord hjr = new HelloJavaRecord(42, "Test");
        assertEquals(42, hjr.i1());
        assertEquals("Test", hjr.s1());
    }

    @Test
    void testHelloJavaRecordEquality() {
        HelloJavaRecord hjr1 = new HelloJavaRecord(42, "Test");
        HelloJavaRecord hjr2 = new HelloJavaRecord(42, "Test");
        assertEquals(hjr1, hjr2);
        assertEquals(hjr1.hashCode(), hjr2.hashCode());
    }

    @Test
    void testHelloJavaRecordToString() {
        HelloJavaRecord hjr = new HelloJavaRecord(42, "Test");
        assertEquals("HelloJavaRecord[i1=42, s1=Test]", hjr.toString());
    }
}