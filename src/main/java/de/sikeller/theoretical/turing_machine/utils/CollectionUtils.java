package de.sikeller.theoretical.turing_machine.utils;

import java.util.*;

public class CollectionUtils {

    @SafeVarargs
    public static <T> Set<T> setOf(final T... values) {
        return new HashSet<>(Arrays.asList(values));
    }

    @SafeVarargs
    public static <T> List<T> listOf(final T... values) {
        return new LinkedList<>(Arrays.asList(values));
    }

}
