import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class NthHighestSalary {

    static HashMap<String, BigDecimal> salaries = new HashMap<>() {
        {
            put("Yahya", new BigDecimal("3600.00"));
            put("Berna", new BigDecimal("4600.00"));
            put("Ege", new BigDecimal("2300.00"));
            put("Deniz", new BigDecimal("3400.00"));
            put("Bensu", new BigDecimal("3500.00"));
            put("Yunus", new BigDecimal("3500.00"));
        }
    };

    public static void main(String[] args) {
        //System.out.println(getNthHighestSalary(6));
        System.out.println(getNthHighestSalaryV2(3));
    }


    public static List<String> getNthHighestSalaryV2(int order) {
        List<Map.Entry<BigDecimal, List<String>>> collect = salaries.entrySet()
                .stream()
                .collect(groupingBy(
                        entry -> entry.getValue(),
                        mapping(Map.Entry::getKey, toList())))
                .entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey))
                .collect(toList());//.forEach(System.out::println)

        return order <= collect.size() && order > 0 ? collect.get(order - 1).getValue() : null;
    }


    public static Map.Entry getNthHighestSalary(int number) {
        Map<BigDecimal, Set<String>> groupedValues =
                salaries.entrySet()
                        .stream()
                        .collect(Collectors.groupingBy(Map.Entry::getValue, mapping(Map.Entry::getKey, toSet())));

        if (number < 1 || number > groupedValues.size()) {
            throw new IllegalArgumentException("Not valid order number. Max order should be " + groupedValues.size() + "!");
        }

        List<Map.Entry<BigDecimal, Set<String>>> sortedAndGroupedValues =
                groupedValues
                        .entrySet()
                        .stream()
                        //.sorted((e1, e2) -> e2.getValue().compareTo(e1.getKey()))
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                        .collect(Collectors.toList());

        System.out.println(sortedAndGroupedValues);
        return sortedAndGroupedValues.get(number - 1);
    }

}
