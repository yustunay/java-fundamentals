import java.util.*;

public class DirectedAcyclicGraph {

    private static Map<String, List<String>> verticesMap;
    private static Map<String, Integer> inDegreeMap = new HashMap<>();

    private static Queue<String> queue = new LinkedList<>();
    private static List<String> orderedArrays = new ArrayList<>();

    public static void main(String[] args) {
        verticesMap = new HashMap<>() {{
            put("A", Arrays.asList());
            put("B", Arrays.asList("A"));
            put("C", Arrays.asList("A"));
            put("D", Arrays.asList("B"));
            put("E", Arrays.asList("C"));
            put("F", Arrays.asList("B", "E"));
            put("G", Arrays.asList("E"));
            put("I", Arrays.asList("A","C"));
        }};

        System.out.println(verticesMap);

        verticesMap.entrySet().forEach(entry ->
                inDegreeMap.put(
                        String.valueOf(entry.getKey()),
                        entry.getValue().size()
                )
        );

        System.out.println(inDegreeMap);
        checkQueue();
    }

    private static void checkQueue() {
        //Check inDegreeMap and push to queue if value is 0
        inDegreeMap.forEach((key, value) -> {
            if (value == 0) {
                queue.add(key);
            }
        });

        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            orderedArrays.add(vertex);
            dfs(vertex);
        }
        System.out.println(orderedArrays);
    }

    private static void dfs(String vertex) {
        verticesMap.entrySet().forEach(entry -> {
            if (entry.getValue().contains(vertex)) {
                String edge = entry.getKey();
                int value = inDegreeMap.get(edge);
                inDegreeMap.put(edge, --value);
                if (value == 0) {
                    queue.add(edge);
                }
            }
        });
    }
}
