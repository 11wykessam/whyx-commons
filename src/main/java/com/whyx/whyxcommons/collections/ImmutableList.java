package com.whyx.whyxcommons.collections;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

/**
 * @param <T>
 * @author Sam Wykes.
 * Immutable list
 */
public class ImmutableList<T> {

    // the underlying list.
    private final List<T> mutableList;

    private ImmutableList(final List<T> list) {
        this.mutableList = list;
    }

    public static <T> ImmutableList<T> ofList(final List<T> list) {
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
    public boolean contains(final T object) {
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
    public boolean equals(final Object object) {
        requireNonNull(object, "object must not be null");
        return object instanceof ImmutableList && this.mutableList.equals(((ImmutableList<?>) object).mutableList);
    }

    /**
     * Gets a specific item in the list.
     *
     * @param i index of item.
     * @return {@link T} object.
     */
    public T get(final int i) {
        return mutableList.get(i);
    }

    /**
     * Return a stream of elements in the list.
     *
     * @return {@link Stream} of immutable lists' elements.
     */
    public Stream<T> stream() {
        return this.mutableList.stream();
    }

}
