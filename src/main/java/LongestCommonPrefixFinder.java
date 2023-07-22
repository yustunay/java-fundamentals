public class LongestCommonPrefixFinder {
    public static String findLongestCommonPrefix(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        
        String prefix = strings[0]; // Initialize prefix with the first string
        
        for (int i = 1; i < strings.length; i++) {
            while (!strings[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1); // Remove last character
            }
            
            if (prefix.isEmpty()) {
                break; // No common prefix exists
            }
        }
        
        return prefix;
    }
    
    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};
        
        String longestCommonPrefix = findLongestCommonPrefix(input);
        System.out.println("Longest common prefix: " + longestCommonPrefix);
    }
}
