package ru.ifmo.collections;

import java.util.TreeMap;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    int k;
    TreeMap<Integer, Integer> numbersCollection = new TreeMap<>();

    public KthLargest(int k, int[] numbers) {
        this.k = k;
        for (int number :
                numbers) {
            numbersCollection.put(number, 1);
        }
    }

    public int add(int val) {
        Integer prev = numbersCollection.get(val);
        if (prev != null) {
            numbersCollection.put(val, prev + 1);
        } else {
            numbersCollection.put(val, 1);
        }

        var map = numbersCollection.descendingMap();
        int count = 0;
        for (var pair : map.entrySet()) {
            count += pair.getValue();
            if (count >= k) {
                return pair.getKey();
            }
        }

        throw new IllegalArgumentException("There are less than " + k + " elements");
    }
}