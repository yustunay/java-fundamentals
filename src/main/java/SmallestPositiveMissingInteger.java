import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallestPositiveMissingInteger {

    public static void main(String[] args) {
        //int[] input = {1, 3, 6, 4, 1, 2};
        //int[] input = {-1, -2};
        int[] input = {-1, -3, 15, 7, 9, 1, 0, 2, 5, 4};
        System.out.println(getSmallestPositiveInteger(input));
        System.out.println(getSmallestPositiveIntegerV2(input));
    }

    public static int getSmallestPositiveInteger(int[] input){
        TreeSet<Integer> collect = IntStream.of(input).boxed().sorted().filter(i -> i > 0).collect(Collectors.toCollection(TreeSet::new));
        Optional<Integer> first = collect.stream().filter(i -> !collect.contains(i + 1)).findFirst();
        if (first.isPresent()){
            return first.get() + 1;
        }
        return 1;
    }

    public static int getSmallestPositiveIntegerV2(int[] A) {
        int n = A.length;
        boolean[] present = new boolean[n + 1];

        // Mark elements that are within the valid range
        for (int num : A) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }

        // Find the first missing positive integer
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }

        // If all integers from 1 to n are present, return n+1
        return n + 1;
    }

}


