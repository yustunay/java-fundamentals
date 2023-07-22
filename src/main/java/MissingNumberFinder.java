import java.util.Arrays;

public class MissingNumberFinder {

    public static int findMissingNumberV1(int[] nums) {
        Arrays.sort(nums); // Order the elements in the array

        int expectedNum = 1; // Start with the expected number 1

        for (int num : nums) {
            if (num != expectedNum) {
                return expectedNum; // Return the first number that doesn't match the expected number
            }
            expectedNum++; // Increment the expected number for the next iteration
        }

        return expectedNum; // If all numbers match, return the next expected number
    }


    public static int findMissingNumberV2(int[] nums) {
        Arrays.sort(nums); // Order the elements in the array

        return Arrays.stream(nums)
                .reduce(1, (expectedNum, num) -> num == expectedNum ? expectedNum + 1 : expectedNum);
    }
    
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 5, 6, 7, 8};
        
        int missingNumber = findMissingNumberV2(input);
        System.out.println("Missing number: " + missingNumber);
    }
}
