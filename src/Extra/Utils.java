package Extra;

import java.util.List;
import java.util.Optional;

public final class Utils {
    private Utils() {
    }

    public static <T> Optional<T> getFromList(T searchParam, List<T> list) {
        for (T val : list)
            if (val.equals(searchParam))
                return Optional.of(val);
        return Optional.empty();
    }

    public static <T extends Comparable<T>> T clamp(T value, T min, T max) {
        if (value.compareTo(min) < 0)
            return min;
        else if (value.compareTo(min) > 0)
            return max;
        else
            return value;
    }
}
