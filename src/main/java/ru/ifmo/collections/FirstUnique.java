package ru.ifmo.collections;

import java.util.LinkedHashMap;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {

    LinkedHashMap<Integer, Boolean> numbersLoneliness;

    public FirstUnique(int[] numbers) {
        numbersLoneliness = new LinkedHashMap<Integer, Boolean>();
        for (int i = 0; i < numbers.length; i++) {
            add(numbers[i]);
        }
    }

    public int showFirstUnique() {
        for (var pair : numbersLoneliness.entrySet()) {
            if (pair.getValue()) {
                return pair.getKey();
            }
        }
        return -1;
    }

    public void add(int value) {
        boolean isFirst = numbersLoneliness.get(value) == null;
        numbersLoneliness.put(value, isFirst);
    }
}
