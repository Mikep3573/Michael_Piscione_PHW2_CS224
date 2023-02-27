import Classes.*;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */


public class Main {
    // Algorithm
    public void dijkstraAlgorithm(int[][] graph, int startNode, PriorityQueue<Node> distances) {
        // Initialize a list of distances to nodes
        // Note: We use the largest integer available in place of infinity
        for (int i = 1; i <= distances.size(); i++) {
            distances.add(new Node(i, 2147483647));
        }

        // Create a list of

    }
    public static void main(String[] args) {
        // Variable for the initial size of the min priority queue
        int initCapacity = 8;

        // Create a priority queue using the distance to nodes as the comparison
        PriorityQueue<Node> distances = new PriorityQueue<Node>(initCapacity,
                (n1, n2) -> Integer.compare(n1.getDistance(), n2.getDistance()));

        // Create the adjacency matrix representation of the graph
        // Note: Node s and node t are 1 and 8 respectively
        int[][] graphAdjMatrix = {{0, 1, 1, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 1, 0, 1, 0, 1, 0}, {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0, 0}};


    }
}