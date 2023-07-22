import java.util.Arrays;
import java.util.List;

public class ArrayPairIndicesTargetSum {

    public static void main(String[] args) {
        System.out.println(getIndicesWhichEqualTargetSum(new int[]{1,3,7,9,2}, 11));
    }

    private static List<Integer> getIndicesWhichEqualTargetSum(int[] input, int targetSum) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i == j) {
                    continue;
                }
                if (input[i] + input[j] == targetSum) {
                    return Arrays.asList(i, j);
                }
            }
        }
        return null;
    }


}
