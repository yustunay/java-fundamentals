import java.util.Comparator;
import java.util.stream.IntStream;

public class SecondHighestNumber {
    public static void main(String[] args) {
        int[] numbers = {5,9,11,2,8,21,1};
        System.out.println(getSecondHighestNumber(numbers));
    }

    private static int getSecondHighestNumber(int[] numbers){
      return IntStream.of(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray()[1];
    }
}
