/**
 * This Node class represents a node in a linked list. Each node holds both the identification of it (an integer)
 * and an object of the node it points to. This is meant to be used in an adjacency list.
 */

package Classes;

public class Node {

    // Class fields
    int node;
    int distance;

    // Constructors

    /**
     *
     */
    public Node() {
        node = -1;
        distance = -1;
    }

    /**
     *
     * @param node
     * @param distance
     */
    public Node(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    // Getters
    /**
     * getNode is a simple getter that returns the value held in the integer node identifier 'node'.
     * @return node, the integer node identifier
     */
    public int getNode() { return node; }

    /**
     * getDistance is a simple getter that returns the 'distance' from the source node to this node.
     * @return distance, the distance of the node object
     */
    public int getDistance() { return distance; }

    // Setters
    /**
     * setNode is a simple setter that sets the integer node identifier field equal to the user given integer node
     * identifier.
     * @param node, the user given integer node identifier
     */
    public void setNode(int node) { this.node = node; }

    /**
     * setDistance is a simple setter that sets the integer distance field equal to the distance from the source
     * node to this node.
     * @param distance, the distance from the source node to this node
     */
    public void setDistance(int distance) { this.distance = distance; }

    // toString
    /**
     *
     */
    @Override
    public String toString() { return getNode() + ", Distance: " + getDistance(); }
}
