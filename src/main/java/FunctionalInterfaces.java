import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {

        //PREDICATE
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(10));

        //CONSUMER
        List<String> nameList = Arrays.asList("Yahya","Berna","Ege","Deniz");
        Consumer<List<String>> printValues = list -> list.forEach(v -> System.out.println(v.toUpperCase()));//System.out::println;
        printValues.accept(nameList);

        //SUPPLIER
        Supplier<LocalDateTime> getDate = LocalDateTime::now;
        System.out.println(getDate.get());

        //FUNCTION
        Function<Integer,Integer> square = x -> x * x;
        System.out.println(square.apply(4));

        //UNARY OPERATOR
        UnaryOperator<Integer> squareV2 = num -> num * num;
        System.out.println(squareV2.apply(20));

    }

}
