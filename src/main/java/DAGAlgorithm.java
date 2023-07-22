import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class DAGAlgorithm {
    private int numVertices;
    private List<List<String>> adjacencyList;
    private Map<String, Integer> vertexIndexMap;

    public DAGAlgorithm() {
        numVertices = 0;
        adjacencyList = new ArrayList<>();
        vertexIndexMap = new HashMap<>();
    }

    public void addEdge(String source, String destination) {
        if (!vertexIndexMap.containsKey(source)) {
            vertexIndexMap.put(source, numVertices++);
            adjacencyList.add(new ArrayList<>());
        }
        if (!vertexIndexMap.containsKey(destination)) {
            vertexIndexMap.put(destination, numVertices++);
            adjacencyList.add(new ArrayList<>());
        }
        int sourceIndex = vertexIndexMap.get(source);
        int destIndex = vertexIndexMap.get(destination);
        adjacencyList.get(sourceIndex).add(destination);
    }

    public List<String> topologicalSort() {
        List<String> topologicalOrder = new ArrayList<>();
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            int vertexIndex = stack.pop();
            String vertex = getKeyByValue(vertexIndex);
            topologicalOrder.add(vertex);
        }

        return topologicalOrder;
    }

    private void dfs(int vertexIndex, boolean[] visited, Stack<Integer> stack) {
        visited[vertexIndex] = true;

        for (String adjacent : adjacencyList.get(vertexIndex)) {
            int adjacentIndex = vertexIndexMap.get(adjacent);
            if (!visited[adjacentIndex]) {
                dfs(adjacentIndex, visited, stack);
            }
        }

        stack.push(vertexIndex);
    }

    private String getKeyByValue(int value) {
        for (Map.Entry<String, Integer> entry : vertexIndexMap.entrySet()) {
            if (entry.getValue() == value) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        // Create a DAG
        DAGAlgorithm dag = new DAGAlgorithm();

        // Add edges to the DAG
        dag.addEdge("A", "B");
        dag.addEdge("A", "C");
        dag.addEdge("B", "D");
        dag.addEdge("B", "F");
        dag.addEdge("C", "E");
        dag.addEdge("E", "F");


        // Perform topological sort
        List<String> topologicalOrder = dag.topologicalSort();

        // Print the topological order
        System.out.println("Topological Order:");
        for (String vertex : topologicalOrder) {
            System.out.print(vertex + " ");
        }
    }
}
