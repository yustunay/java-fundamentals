import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReductionCost {

    public static int reductionCost(List<Integer> num) {
        // Sort the array in non-decreasing order
        Collections.sort(num);

        int totalCost = 0;
        while (num.size() > 1) {
            // Pick the two smallest elements from the array
            int firstElement = num.remove(0);
            int secondElement = num.remove(0);

            // Calculate the cost of the current move and add it to the total cost
            int cost = firstElement + secondElement;
            totalCost += cost;

            // Add the sum of the two selected elements to the end of the array
            num.add(cost);

            // Sort the array after each move
            Collections.sort(num);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        num.add(4);
        num.add(6);
        num.add(8);

        int minimumTotalCost = reductionCost(num);
        System.out.println("Minimum Total Cost: " + minimumTotalCost);
    }
}
