package de.sikeller.theoretical.turing_machine.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CollectionUtils {

    @SafeVarargs
    public static <T> Set<T> setOf(final T... values) {
        return new HashSet<>(Arrays.asList(values));
    }

}
