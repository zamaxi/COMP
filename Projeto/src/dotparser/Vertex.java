package dotparser;

import java.util.*;

public class Vertex {
	private List<Edge> sourceEdges; // List containing all the Edges with source on this Vertex
    private List<Edge> destinationEdges; // List containing all the Edges with destination on this Vertex
	private String name;

    public Vertex(String name) {
        this.name = name;
    }

    public boolean addSourceEdge(Edge edge) {

        for (Edge edgeIt : sourceEdges) {
            if (edgeIt.getSourceVertex() == edge.getSourceVertex()) {
                // already added
                return false;
            }
        }

        sourceEdges.add(edge);
        return true;
    }

    public boolean addDestinationEdge(Edge edge) {
        for (Edge edgeIt : destinationEdges) {
            if (edgeIt.getDestinationVertex() == edge.getDestinationVertex()) {
                // already added
                return false;
            }
        }

        destinationEdges.add(edge);
        return true;
    }

}
