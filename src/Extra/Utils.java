package Extra;

import java.util.List;
import java.util.Optional;

public final class Utils {
    private Utils() {
    }

    public static <T> Optional<T> getFromList(T searchObj, List<T> list) {
        for (T obj : list)
            if (obj.equals(searchObj))
                return Optional.of(obj);
        return Optional.empty();
    }

    public static <T> boolean isOnList(T searchObj, List<T> list) {
        return getFromList(searchObj, list).isPresent();
    }

    public static <T extends Comparable<T>> T clamp(T value, T min, T max) {
        if (value.compareTo(min) < 0)
            return min;
        else if (value.compareTo(max) > 0)
            return max;
        else
            return value;
    }

    public static <T extends Comparable<T>> T lowerBound(T value, T minBound) {
        if (value.compareTo(minBound) < 0)
            return minBound;
        return value;
    }
}
