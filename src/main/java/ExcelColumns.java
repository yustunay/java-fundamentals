import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ExcelColumns {

    private static String[] columnNamesArray = "abcdefghijklmnopqrstuvwxyz".split("");

    public static void main(String[] args) {
        List<String> generatedList = generateColumnNames();
        System.out.println(generatedList.get(24)); //y
        System.out.println(generatedList.get(52)); //ba
    }

    private static List<String> generateColumnNames() {
        List<String> generatedList = new CopyOnWriteArrayList<>();
        generatedList.addAll(Arrays.asList(columnNamesArray));
        List<String> prevList = new CopyOnWriteArrayList<>(generatedList);

        for (int x = 2; x <= 3; x++) {
            List<String> currentList = new CopyOnWriteArrayList<>(); //1 letter, 2 letters, 3 letters, ...
            for (int j = 0; j < prevList.size(); j++) {
                for (int i = 0; i < columnNamesArray.length; i++) {
                    currentList.add(prevList.get(j) + columnNamesArray[i]);
                }
            }
            generatedList.addAll(currentList);
            prevList.clear();
            prevList.addAll(currentList);
        }
        return generatedList;
    }

}
