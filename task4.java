/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mujtaba Abr
 */

    import java.util.*;

public class task4 {

    private int vertices;
    private int[][] adjacencyMatrix;

    public task4(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        adjacencyMatrix[u - 1][v - 1] = 1;
        adjacencyMatrix[v - 1][u - 1] = 1; // for undirected graph
    }

    public void displayAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("  ");
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void findAllPaths(int start, int destination) {
        boolean[] visited = new boolean[vertices];
        List<String> paths = new ArrayList<>();
        List<Integer> pathLengths = new ArrayList<>();

        findAllPathsUtil(start, destination, visited, "", paths, pathLengths);

        System.out.println("Paths:");
        for (int i = 0; i < paths.size(); i++) {
            System.out.println(paths.get(i) + " (Length: " + pathLengths.get(i) + ")");
        }
    }

    private void findAllPathsUtil(int currentVertex, int destination, boolean[] visited, String path, List<String> paths, List<Integer> pathLengths) {
        visited[currentVertex - 1] = true;
        path += currentVertex;

        if (currentVertex == destination) {
            paths.add(path);
            pathLengths.add(countEdges(path));
        } else {
            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[currentVertex - 1][i] == 1 && !visited[i]) {
                    findAllPathsUtil(i + 1, destination, visited, path + " → ", paths, pathLengths);
                }
            }
        }

        visited[currentVertex - 1] = false;
    }

    private int countEdges(String path) {
        return path.length() - path.replace(" → ", "").length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        task4 graph = new task4(vertices);

        System.out.println("Enter the edges as (u, v) pairs:");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        graph.displayAdjacencyMatrix();

        System.out.println("Enter the starting vertex:");
        int start = scanner.nextInt();
        System.out.println("Enter the destination vertex:");
        int destination = scanner.nextInt();

        graph.findAllPaths(start, destination);
    }
}

