package menu.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParsingUtil {
    public static List<String> stringToListByComma(String str) {
        return Arrays.stream(str.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
