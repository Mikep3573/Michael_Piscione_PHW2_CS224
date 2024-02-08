/**
 * This program implements Dijkstra's single-source shortest-path algorithm on a graph represented by an
 * adjacency matrix.
 */

import Classes.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Main is just a class containing the helper functions 'extractMin' and 'changeKey' for the algorithm. It also holds
 * Dijkstra's single-source shortest-path algorithm and the main function.
 */
public class Main {
    // Helper Functions
    /**
     * extractMin is the 'extractMin' method used in the pseudocode of Dijkstra's algorithm. It takes
     * a priority queue and removes and returns the highest priority item.
     * @param distances, the priority queue
     * @return, Node, the highest priority item
     */
    public Node extractMin(PriorityQueue<Node> distances) {
        return distances.poll();
    }

    /**
     * changeKey is the 'changeKey' method used in the pseudocode of Dijkstra's algorithm. It takes a Node,
     * a priority queue, and a distance and updates the node in the priority queue with the distance.
     * @param distances, the priority queue
     * @param node, the node to be updated in the priority queue
     * @param distance, the distance value to update the node with
     */
    public void changeKey(PriorityQueue<Node> distances, Node node, int distance) {
        // Remove the node from the queue
        distances.remove(node);

        // Update the node with the new distance from the start node
        node.setDistance(distance);

        // Add the node back to the queue
        distances.add(node);
    }

    // Algorithm
    /**
     * dijkstraAlgorithm is the method that implements Dijkstra's single-source shortest-path algorithm.
     * It takes an adjacency matrix representation of a graph and the source node and prints the shortest path
     * to each node from the start node individually.
     * @param graph, the adjacency matrix representation of the graph
     * @param startNode, the node to be used as the source node
     */
    public void dijkstraAlgorithm(int[][] graph, int startNode) {
        // Variable representing the number of node
        // NOTE: This is added because of this specific graph, the variable can be easily changed to be
        // based on user input if needed
        int initCapacity = 8;

        // Create a priority queue where the minimum distance to the start node has the highest priority
        PriorityQueue<Node> distances = new PriorityQueue<>(initCapacity,
                (n1, n2) -> Integer.compare(n1.getDistance(), n2.getDistance()));

        // Create a list to keep track of node predecessors and distances
        ArrayList<Node> nodeInfo = new ArrayList<>(initCapacity);

        // Load the distances into the queue and info list
        for(int i = 1; i <= initCapacity; i++) {
            // NOTE: The parents are initiated to the start node (the start node for this graph is represented as 1
            // while the end node is represented as 8)
            if(i == startNode) {
                // The start node always has a distance of zero
                Node tempNode = new Node(i, 0, startNode);
                distances.add(tempNode);
                nodeInfo.add(i - 1, tempNode);
            }
            else {
                // Note: We use the largest integer available in place of infinity
                Node tempNode = new Node(i, 2147483647, 1);
                distances.add(tempNode);
                nodeInfo.add(i - 1, tempNode);
            }
        }

        // Create a list (representing a cut) to keep track of visited nodes
        ArrayList<Integer> cut = new ArrayList<>(initCapacity);

        // While the queue is not empty continue the program
        while(distances.size() != 0) {
            // Get the highest priority node in the queue and remove it
            Node v = extractMin(distances);

            // Handle disconnected graphs -> if we start reading 'infinities' don't use them, just end the algorithm
            if(v.getDistance() == 2147483647) {
                break;
            }

            // Add node to cut
            cut.add(v.getNode());

            // Printing the path to v when it gets added to the cut
            // Begin the string
            String pathOutput = "Node " + v.getNode() + " included in S with the shortest path length ";

            // Create a list to represent the path from the start node to v
            ArrayList<Integer> path = new ArrayList<>();

            // Find the path using the parents of the nodes stored in the nodeInfo list
            Node tempNode = nodeInfo.get(v.getNode() - 1);
            for(int i = 0; i < cut.size(); i++) {
                if (tempNode.getParent() != startNode) {
                    path.add(tempNode.getParent());
                    tempNode = nodeInfo.get(tempNode.getParent() - 1);
                }
            }

            // Update the string with the path length and the start node
            if(v.getNode() != startNode) {
                pathOutput += (path.size() + 1) + " on the path: " + startNode;
            }
            else { // NOTE: The start node has a path length of zero always
                pathOutput += "0 on the path: " + startNode;
            }

            // Load the nodes out of the path list and into the string
            for(int i = path.size() - 1; i >= 0; i--) {
                pathOutput += " - " + path.get(i) ;
            }

            // End the path with v unless it was the start node
            if(v.getNode() != startNode) {
                pathOutput += " - " + v.getNode();
            }

            // Print the formatted string
            System.out.println(pathOutput);


            // Update the distances to the nodes visible to v
            for(int i = 0; i < initCapacity; ++i) {

                // Check if there is an edge to w and w is not within the cut
                if(graph[v.getNode() - 1][i] != -1 && !cut.contains(i + 1)) {

                    // If the distance of w is larger than the new distance to w as seen by v,
                    // set the parent of w to this node and update the distance
                    if(nodeInfo.get(v.getNode() - 1).getDistance() + graph[v.getNode() - 1][i] <
                            nodeInfo.get(i).getDistance()) {
                        // Change the parent of w to v
                        nodeInfo.get(i).setParent(v.getNode());

                        // Update the distance to w in nodeInfo
                        nodeInfo.get(i).setDistance(nodeInfo.get(v.getNode() - 1).getDistance() +
                                graph[v.getNode() - 1][i]);

                        // Update the distance to w in the priority queue
                        changeKey(distances, nodeInfo.get(i), nodeInfo.get(i).getDistance());
                    }
                }
            }
        }
    }

    /**
     * This main function simply defines the adjacency matrix graph and source node and calls Dijkstra's algorithm using
     * that information.
     */
    public static void main(String[] args) {
        // Create the adjacency matrix representation of the graph
        // NOTE: Node s and node t are 1 and 8 respectively
        // NOTE: The adjacency list is slightly modified to hold the edge weights instead of just a one if there is
        // an edge or not. It also holds -1 instead of zeroes to represent no edge (therefore assuming no negative
        // edge weights)
        int[][] graphAdjMatrix = {{-1, 9, 15, 14, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, 23, -1},
                {-1, -1, -1, -1, 20, -1, -1, 44}, {-1, -1, 5, -1, 30, -1, 18, -1}, {-1, -1, -1, -1, -1, 11, -1, 16},
                {-1, -1, -1, -1, -1, -1, 6, 6}, {-1, -1, -1, -1, 2, -1, -1, 19}, {-1, -1, -1, -1, -1, -1, -1, -1}};

        // Create a main object
        Main main = new Main();

        // Create start node variable (using node s as the start node)
        int startNode = 1;

        // Display header
        System.out.println("The graph is represented using an adjacency matrix.");
        System.out.println("=================================================");

        // Start the algorithm
        main.dijkstraAlgorithm(graphAdjMatrix, startNode);
    }
}