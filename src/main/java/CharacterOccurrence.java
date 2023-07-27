import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterOccurrence {
    public static void main(String[] args) {
        String input = "yahyaustunay"; //subsrCibetoinTerviewmania
        System.out.println(findOccurrences(input));
        System.out.println(findOccurrencesV2(input));
        System.out.println(findDuplicatedElements(input));
        System.out.println(getFirstNonRepeatedCharacter(input));
    }

    private static Map<String, Long> findOccurrences(String input) {
        return Arrays.asList(
                        input
                                .toLowerCase()
                                .split("")
                )
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), //s -> s
                                Collectors.counting()
                        )
                );
    }

    private static Map<Character, Long> findOccurrencesV2(String input) {
        return input.toLowerCase()
                .chars()
                .mapToObj(s -> (char) s)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    }

    private static Map<String, Long> findDuplicatedElements(String input) {
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
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static Character getFirstNonRepeatedCharacter(String input) {
        Map<Character, Long> occurrences = input
                .toLowerCase()
                .chars()
                .mapToObj(s -> (char) s)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        return input.toLowerCase()
                .chars()
                .mapToObj(s -> (char) s)
                .filter(v -> occurrences.get(v) == 1)
                .findFirst()
                .orElseGet(null);
    }

    public static List<String> getCharacters(String input, boolean duplicatedOnes) {
        return Arrays.stream(input.toLowerCase()
                        .split(""))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> duplicatedOnes ? entry.getValue() > 1 : entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
