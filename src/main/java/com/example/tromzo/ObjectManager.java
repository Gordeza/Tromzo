package com.example.tromzo;

import java.util.HashSet;
import java.util.Set;

public class ObjectManager {
    private Set<Integer> freeObjects;
    private Set<Integer> usedObjects;

    /**
     * Constructs an ObjectManager instance with a pool of objects.
     * @param n The number of objects to initialize the pool with.
     */
    public ObjectManager(int n) {
        this.freeObjects = new HashSet<>();
        this.usedObjects = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            freeObjects.add(i);
        }
    }

    /**
     * Retrieves an object from the collection of free objects.
     * If the free objects' collection is empty, returns null.
     * This method is synchronized to ensure thread safety.
     * @return The retrieved object, or null if the there are no free objects available.
     */
    public synchronized Integer get_object() {
        if(freeObjects.isEmpty())
            return null;
        int res = freeObjects.iterator().next();
        freeObjects.remove(res);
        usedObjects.add(res);
        return res;
    }

    /**
     Frees the specified object and adds it back to the collection of free objects.
     If the object is not found in the used objects' collection, returns false.
     This method is synchronized to ensure thread safety.
     @param obj The object to be freed.
     @return true if the object was successfully freed,
     false if the object was not found in the used objects' collection.
     */
    public synchronized boolean free_object(int obj) {
        if(!usedObjects.contains(obj)) return false;
        usedObjects.remove(obj);
        freeObjects.add(obj);
        return true;
    }
}
