import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        //reverse string
        String string = "happy world!";
        System.out.println(string.chars().mapToObj(i -> String.valueOf((char) i)).reduce("", (a, b) -> b + a));

        //Min-max numbers in array
        int[] arr = new int[]{21, 3, 8, 5, 19, 11, 4, 46};
        List<Integer> orderedList = IntStream.of(arr).boxed().sorted().collect(Collectors.toList());//Comparator.reverseOrder()
        System.out.println("Min number: " + orderedList.get(0) + ", max number: " + orderedList.get(orderedList.size() - 1));

        String palindrome = "A man, a plan, a canal, Panama!".toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        boolean isPalindrome = IntStream.of(0, palindrome.length() / 2).allMatch(i -> palindrome.charAt(i) == palindrome.charAt(palindrome.length() - 1 - i));
        System.out.println("Is '" + palindrome + "' a palindrome? " + isPalindrome);

    }


}
