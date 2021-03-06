package com.whyx.whyxcommons.collections;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * @param <T>
 * @author Sam Wykes.
 * Immutable list
 */
public class ImmutableList<T> {

    // the underlying list.
    private final List<T> mutableList;

    private ImmutableList(List<T> list) {
        this.mutableList = list;
    }

    public static <T> ImmutableList<T> ofList(List<T> list) {
        requireNonNull(list, "list must not be null");
        return new ImmutableList<>(list);
    }

    /**
     * Get the size of the list.
     *
     * @return int representation of number of elements in the list.
     */
    public int size() {
        return mutableList.size();
    }

    /**
     * Gets whether list is empty.
     *
     * @return boolean representation of list emptiness.
     */
    public boolean isEmpty() {
        return mutableList.isEmpty();
    }

    /**
     * Checks whether list contains a given item.
     *
     * @param object {@link T} object being looked for.
     * @return boolean depending on whether the item is found.
     */
    public boolean contains(T object) {
        requireNonNull(object, "object must not be null");
        return mutableList.contains(object);
    }

    /**
     * Checks whether two immutable lists are equal.
     *
     * @param object object being checked for equality.
     * @return boolean depending on whether the two objects are equal.
     */
    @Override
    public boolean equals(Object object) {
        requireNonNull(object, "object must not be null");
        return object instanceof ImmutableList && this.mutableList.equals(((ImmutableList<?>) object).mutableList);
    }

    /**
     * Gets a specific item in the list.
     *
     * @param i index of item.
     * @return {@link T} object.
     */
    public T get(int i) {
        return mutableList.get(i);
    }

    /**
     * Get a mutable copy of the list.
     *
     * @return {@link List} copy of this item.
     */
    public List<T> mutableCopy() {
        return new ArrayList<>(this.mutableList);
    }

}
