import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //reverse string
//        String string = "happy world!";
//        System.out.println(string.chars().mapToObj(i -> String.valueOf((char) i)).reduce("", (a, b) -> b + a));
//
//        //Min-max numbers in array
//        int[] arr = new int[]{21, 3, 8, 5, 19, 11, 4, 46};
//        List<Integer> orderedList = IntStream.of(arr).boxed().sorted().collect(Collectors.toList());//Comparator.reverseOrder()
//        System.out.println("Min number: " + orderedList.get(0) + ", max number: " + orderedList.get(orderedList.size() - 1));
//
//        String palindrome = "A man, a plan, a canal, Panama!".toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
//        boolean isPalindrome = IntStream.of(0, palindrome.length() / 2).allMatch(i -> palindrome.charAt(i) == palindrome.charAt(palindrome.length() - 1 - i));
//        System.out.println("Is '" + palindrome + "' a palindrome? " + isPalindrome);


        //order by length
        //uppercase
//        List<String> fruits = Arrays.asList("apple", "banana", "orange", "grape");
//        System.out.println(fruits.stream().sorted(Comparator.comparing(String::length)).map(String::toUpperCase).collect(Collectors.toList()));

        //longest name by first latter
//        List<String> names = Arrays.asList("John", "Jane", "Alice", "Bob");
//
//        Map<Character, String> collect = names.stream()
//                .sorted(Comparator.comparing(n -> n.charAt(0)))
//                .collect(
//                        Collectors.groupingBy(name -> name.charAt(0),
//                                Collectors.reducing("", (n1, n2) -> n1.length() > n2.length() ? n1 : n2)));
//
//        System.out.println(collect);




    }


}
