package com.example.tromzo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectManagerTest {

    @Test
    public void testGetObjectAndFreeObject() throws IllegalAccessException {
        int n = 3;
        ObjectManager objectManager = new ObjectManager(n);

        // Get objects from the pool
        int obj1 = objectManager.get_object();
        int obj2 = objectManager.get_object();
        int obj3 = objectManager.get_object();

        // Ensure the retrieved objects are within the valid range
        assertTrue(obj1 >= 1 && obj1 <= n);
        assertTrue(obj2 >= 1 && obj2 <= n);
        assertTrue(obj3 >= 1 && obj3 <= n);

        // Try to get another object when all are in use
        assertNull(objectManager.get_object());

        // Free one object and get another one
        objectManager.free_object(obj1);
        int obj4 = objectManager.get_object();
        assertEquals(obj1, obj4);

        // Try to free an object that is already available
        assertTrue(objectManager.free_object(obj4));
        assertFalse(objectManager.free_object(obj4));

        assertTrue(objectManager.free_object(obj2));
        assertTrue(objectManager.free_object(obj3));

        // Try to free an object that is not in the pool
        assertFalse(objectManager.free_object(n+1));
        assertFalse(objectManager.free_object(-1));

        // Get all the objects from the pool again
        int obj5 = objectManager.get_object();
        int obj6 = objectManager.get_object();
        int obj7 = objectManager.get_object();

        // Ensure the retrieved objects are within the valid range
        assertTrue(obj5 >= 1 && obj5 <= n);
        assertTrue(obj6 >= 1 && obj6 <= n);
        assertTrue(obj7 >= 1 && obj7 <= n);
    }

}