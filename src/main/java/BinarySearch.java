import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {3, 7, 9, 11, 23, 34, 56, 89, 97};
        //int target = 89; //7
        //int target = 9; //2
        int target = 102; //-1
        System.out.println(findTarget(arr, target));

       // List<Integer> list = Arrays.stream(arr).boxed().sorted().toList();
       // System.out.println(list);
    }

    private static int findTarget(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

}
