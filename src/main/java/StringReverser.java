import java.util.stream.Collectors;

public class StringReverser {

    public static String reverseString(String str) {
        int length = str.length() - 1;
        int index = length;
        String reversedStr = "";

        while (index >= 0) {
            reversedStr += str.charAt(index);
            index--;
        }

        return reversedStr;
    }

    public static String reverseStringV2(String str) {
        return new StringBuilder(str)
                .reverse()
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }

    public static String reverseStringV3(String str) {
        return str.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", (revStr, c) -> c + revStr);
    }

    public static void main(String[] args) {
        System.out.println("1-Reverse string of ege ustunay is " + reverseString("ege ustunay"));
        System.out.println("2-Reverse string of ege ustunay is " + reverseStringV2("ege ustunay"));
        System.out.println("3-Reverse string of ege ustunay is " + reverseStringV3("ege ustunay"));
    }


}
