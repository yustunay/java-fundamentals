import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOccurrence {
    public static void main(String[] args) {
        String input = "yahyaustunay";
        System.out.println(findOccurrences(input));
        System.out.println(findDuplicatedElements(input));
    }

    private static Map<String,Long> findOccurrences(String input) {
        return Arrays.asList(input.split(""))
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), //s -> s
                                Collectors.counting()
                        )
                );
    }

    private static Map<String,Long> findDuplicatedElements(String input) {
             return Arrays.asList(input.split(""))
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
}
