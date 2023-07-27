import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyHashMap {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 3, 4, 5, 4, 2, 3};
        System.out.println(getFrequencyHashMap(nums));
        System.out.println(getFrequencyHashMapV2(nums));
    }

    public static HashMap<Integer,Integer> getFrequencyHashMap(int[] input){
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < input.length; i++){
            if (frequencyMap.containsKey(input[i])){
                frequencyMap.put(input[i],frequencyMap.get(input[i])+1);
            } else {
                frequencyMap.put(input[i],1);
            }
        }
        return frequencyMap;
    }

    public static Map<Integer,Long> getFrequencyHashMapV2(int[] input){
        return IntStream.of(input).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //return Arrays.stream(input).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
