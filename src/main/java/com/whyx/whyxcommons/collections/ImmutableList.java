package com.whyx.whyxcommons.collections;

import java.util.List;

/**
 * @param <T>
 * @author Sam Wykes.
 * Immutable list
 */
public class ImmutableList<T> {

    private final List<T> mutableList;

    public ImmutableList(List<T> list) {
        this.mutableList = list;
    }

    int size() {
        return mutableList.size();
    }

    boolean isEmpty() {
        return mutableList.isEmpty();
    }

    boolean contains(T item) {
        return mutableList.contains(item);
    }

    boolean equals(ImmutableList<T> immutableList2) {
        return this.mutableList.equals(immutableList2.mutableList);
    }

    public T get(int i) {
        return mutableList.get(i);
    }

}
