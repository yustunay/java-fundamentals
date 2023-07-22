import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatElement {
    public static void main(String[] args) {
        String input = "egeustunay";
        System.out.println(getFirstNonRepeatElement(input));
    }

    private static String getFirstNonRepeatElement(String input) {
        String[] characters = input.split("");
        Optional<Map.Entry<String, Long>> firstNonRepeatElement = Arrays.asList(characters)
                .stream()
                .collect(Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new, //!!!
                                Collectors.counting()
                                )
                        )
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst();

        if (firstNonRepeatElement.isEmpty())
            return null;

        return firstNonRepeatElement.get().getKey();
    }


}
