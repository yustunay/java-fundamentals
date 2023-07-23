import java.util.ArrayList;
import java.util.List;

public class ContinuousSequences {

    public static void main(String[] args) {
        String[] input = new String[]{"1", "2", "3", "5", "9", "a", "6", "7", "8", "4", "@", "-5", "-7", "-3", "-2", "-1"};
        System.out.println(findSequences(3, input));
    }

    private static List<List<Integer>> findSequences(int sequenceNumber, String[] input) {
        List<List<Integer>> sequences = new ArrayList<>();
        List<Integer> dataFrame = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (!isNumber(input[i])) {
                dataFrame.clear();
                continue;
            }

            Integer value = Integer.valueOf(input[i]);
            if (dataFrame.isEmpty() || dataFrame.get(dataFrame.size() - 1) + 1 == value) {
                dataFrame.add(value);
            } else {
                if (dataFrame.size() >= sequenceNumber) {
                    sequences.add(new ArrayList<>(dataFrame));
                }
                dataFrame.clear();
            }
        }

        if (dataFrame.size() >= sequenceNumber) {
            sequences.add(new ArrayList<>(dataFrame));
        }
        return sequences;
    }

    private static boolean isNumber(String value) {
        try {
            int intValue = Integer.valueOf(value);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }


}
