import java.util.List;
import java.util.stream.IntStream;

public class PrimeNumbers {

    public static void main(String[] args) {
        System.out.println(findPrimeNumbers(20));
    }

    public static List<Integer> findPrimeNumbers(int n){
        return IntStream.rangeClosed(2, n)
                .boxed()
                .filter(num -> {
                    int maxRange = (int) Math.round(Math.sqrt(num));
                    System.out.println("num: "+num+",maxRange:"+maxRange);
                    return IntStream.rangeClosed(2, maxRange)
                                    .boxed()
                                    .filter(v -> num % v == 0)
                                    .findFirst()
                                    .isEmpty();
                       }
                ).toList();
    }


}
