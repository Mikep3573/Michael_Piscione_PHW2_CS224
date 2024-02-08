/**
 * This Node class represents a node in a graph. It holds the integer value of itself,
 * the distance to the start node in a connected graph, and the direct parent of this node.
 */

package Classes;

public class Node {

    // Class fields
    int node;
    int distance;

    int parent;

    // Constructors

    /**
     * This is a simple default constructor.
     */
    public Node() {
        node = -1;
        distance = -1;
        parent = -1;
    }

    /**
     * This is a constructor that allows the user to set the values of the integer representation of the node,
     * the distance to the start node, and the integer representation of this node's parent.
     * @param node, the integer representation of this node
     * @param distance, the node's distance to the start node
     * @param parent, the node's direct parent in the graph
     */
    public Node(int node, int distance, int parent) {
        this.node = node;
        this.distance = distance;
        this.parent = parent;
    }

    // Getters
    /**
     * getNode is a simple getter that returns the value held in the integer node identifier 'node'.
     * @return node, the integer node identifier
     */
    public int getNode() { return node; }

    /**
     * getDistance is a simple getter that returns the 'distance' from the source node to this node.
     * @return distance, the distance to the node
     */
    public int getDistance() { return distance; }

    /**
     * getParent is a simple getter that returns the direct parent of this node in a graph.
     * Parent is an integer representation of the parent node.
     * @return parent, the direct parent of this node in a graph
     */
    public int getParent() { return parent; }

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

    /**
     * setParent is a simple setter that sets the parent field equal to the direct parent of this node in a graph.
     * Parent is an integer representation of the parent node.
     * @param parent, the direct parent of this node in a graph
     */
    public void setParent(int parent) { this.parent = parent; }

    // toString
    /**
     * toString overrides the Object class's toString method. It prints a formatted string showing the
     * values of this instance's fields.
     * @return, the formatted string
     */
    @Override
    public String toString() { return "Node: " + getNode() + ", Distance: " +
            getDistance() + ", Parent: " + getParent(); }
}
