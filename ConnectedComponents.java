/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mujtaba Abr
 */

    import java.util.*;

public class ConnectedComponents {

    public static void main(String[] args) {
        int[][] adjacencyMatrix = {
            {0, 1, 1, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0}
        };

        List<List<Integer>> connectedComponents = findConnectedComponents(adjacencyMatrix);

        System.out.println("Connected Components:");
        for (int i = 0; i < connectedComponents.size(); i++) {
            System.out.println("Component " + (i + 1) + ": " + connectedComponents.get(i));
        }
    }

    public static List<List<Integer>> findConnectedComponents(int[][] adjacencyMatrix) {
        int vertices = adjacencyMatrix.length;
        boolean[] visited = new boolean[vertices];
        List<List<Integer>> connectedComponents = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(adjacencyMatrix, i, visited, component);
                connectedComponents.add(component);
            }
        }

        return connectedComponents;
    }

    public static void dfs(int[][] adjacencyMatrix, int vertex, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex + 1);

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                dfs(adjacencyMatrix, i, visited, component);
            }
        }
    }
}

    



