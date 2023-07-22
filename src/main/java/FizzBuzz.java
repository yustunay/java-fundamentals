import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {
        IntStream.rangeClosed(1,100).forEach(i -> {
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
