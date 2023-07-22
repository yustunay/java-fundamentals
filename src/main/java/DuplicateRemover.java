import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateRemover {
    public static int[] removeDuplicates(int[] nums) {
        Set<Integer> uniqueSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        
        int[] result = new int[uniqueSet.size()];
        int index = 0;
        
        for (int num : uniqueSet) {
            result[index++] = num; // Transfer unique elements to the resulting array
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] input = {1, 2, 2, 3, 4, 4, 4, 5};
        
        int[] uniqueArray = removeDuplicates(input);
        System.out.println("Array without duplicates: " + Arrays.toString(uniqueArray));
    }
}
