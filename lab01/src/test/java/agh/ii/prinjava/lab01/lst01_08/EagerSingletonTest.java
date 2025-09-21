package agh.ii.prinjava.lab01.lst01_08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTests {

    @Test
    void testEagerSingletonInstance() {
        EagerSingleton instance1 = EagerSingleton.getInstance();
        EagerSingleton instance2 = EagerSingleton.getInstance();

        // Assert that both instances are the same
        assertSame(instance1, instance2, "EagerSingleton instances should be the same");
    }

    @Test
    void testLazySingletonInstance() {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();

        // Assert that both instances are the same
        assertSame(instance1, instance2, "LazySingleton instances should be the same");
    }
}