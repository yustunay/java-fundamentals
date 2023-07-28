import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {
        print(100);
        //printV2(100);
    }

    public static void print(int num) {
        IntStream.rangeClosed(1, num)
                .mapToObj(i -> {
                    if (i % 3 == 0 && i % 5 == 0) return "FizzBuzz";
                    else if (i % 3 == 0) return "Fizz";
                    else if (i % 5 == 0) return "Buzz";
                    else return String.valueOf(i);
                }).forEach(System.out::println);
    }

    public static void printV2(int num){
        IntStream.rangeClosed(1, num).forEach(i -> {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        });
    }

}
