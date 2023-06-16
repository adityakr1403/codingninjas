import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class GraphTest {

    public static boolean hasPathHelper(int[][] graph, int v1, int v2, boolean[] visited) {

        if (v1 == v2) {
            return true;
        }

        boolean result = false;

        visited[v1] = true;
        for (int i = 0; i < graph[v1].length; i++) {
            if (graph[v1][i] == 1 && !visited[i]) {
                result = hasPathHelper(graph, graph[v1][i], v2, visited);

            }
            if (result) {
                return result;
            }
        }

        return result;
    }

    public static boolean hasPath(int[][] graph, int v1, int v2) {

        boolean[] visited = new boolean[graph.length];
        return hasPathHelper(graph, v1, v2, visited);

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();


        int edges = e;
        int[][] graph = new int[v][v];
        while (e-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();


        boolean[] visited = new boolean[v];


        for (int j = 0; j < v; j++) {
            if (!visited[j]) {
                queue.add(j);
                visited[j] = true;
            }
            while (!queue.isEmpty()) {
                int x = queue.poll();
                System.out.print(x + " ");

                for (int i = 0; i < v; i++) {
                    if (graph[x][i] != 0 && !visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }
}
