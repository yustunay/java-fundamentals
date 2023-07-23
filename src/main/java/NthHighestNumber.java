import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NthHighestNumber {

    public static void main(String[] args) {
        int[] input = new int[]{9, 5, 8, 1, 3, 5, 7, 2, 5}; //1 3 5 7 9
        System.out.println(getHighestNthNumber(input, 3));;
    }

    private static int getHighestNthNumber(int[] input, int index) {
        List<Integer> collect = IntStream.of(input)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        return collect.size() > index ? collect.get(index-1) : null;
    }


}
