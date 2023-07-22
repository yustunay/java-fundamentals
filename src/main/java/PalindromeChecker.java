import java.util.stream.IntStream;

public class PalindromeChecker {

    public static boolean isPalindrome(String str){
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        System.out.println("cleanStr: "+cleanStr);
        return IntStream.range(0, cleanStr.length() / 2)
                .allMatch(i -> cleanStr.charAt(i) == cleanStr.charAt(cleanStr.length() - 1 - i));
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama!";
        boolean isPalindrome = isPalindrome(input);
        System.out.println("is "+input+" a palindrome? "+isPalindrome);
    }

}
