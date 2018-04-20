package probs.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {
    public static <T> List<T> listOf(T... items) {
        ArrayList<T> result = new ArrayList<>();
        result.addAll(Arrays.asList(items));

        return result;
    }
}
