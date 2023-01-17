package algorithm;

import java.util.HashSet;
import java.util.Set;

public class ShortestPathDijsktra {

    public static void main(String[] args) {
        int graph[][]
                = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}};

        ShortestPathDijsktra spd = new ShortestPathDijsktra();
        System.out.println(spd.calculateShortestPath(graph, 0, 6));
    }

    private int calculateShortestPath(int[][] graph, int source, int destination) {
        int[] sourceDistance = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            sourceDistance[i] = graph[source][i];
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(source);

        while (visited.size() < graph.length) {
            int shortestNodeDistance = Integer.MAX_VALUE;
            int shortestNodeIndex = -1;
            for (int i = 0; i < graph.length; i++) {
                if (!visited.contains(i) && sourceDistance[i] != 0 && sourceDistance[i] < shortestNodeDistance) {
                    shortestNodeDistance = sourceDistance[i];
                    shortestNodeIndex = i;
                }
            }

            if (shortestNodeIndex == destination) {
                return shortestNodeDistance;
            }

            if (shortestNodeIndex == -1) {
                // return -1 for non-reachable node
                return shortestNodeIndex;
            }

            for (int i = 0; i < graph.length; i++) {
                if (!visited.contains(i) && graph[shortestNodeIndex][i] != 0 &&
                        (sourceDistance[i] == 0  || sourceDistance[i] > sourceDistance[shortestNodeIndex] + graph[shortestNodeIndex][i])) {
                    sourceDistance[i] = sourceDistance[shortestNodeIndex] + graph[shortestNodeIndex][i];
                }
            }
            visited.add(shortestNodeIndex);
        }
        return -1;
    }
}
