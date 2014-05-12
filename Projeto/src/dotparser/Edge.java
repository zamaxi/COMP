package dotparser;

public class Edge {
	private Vertex sourceVertex;
	private Vertex destinationVertex;
	
	 public Edge(Vertex source, Vertex destination) {
	        this.sourceVertex = source;
	        this.destinationVertex = destination;

	        source.addDestinationEdge(this);
	        destination.addSourceEdge(this);
	    }

	    public Vertex getSourceVertex() {
	        return sourceVertex;
	    }

	    public void setSourceVertex(Vertex sourceVertex) {
	        this.sourceVertex = sourceVertex;
	    }

	    public Vertex getDestinationVertex() {
	        return destinationVertex;
	    }

	    public void setDestinationVertex(Vertex destinationVertex) {
	        this.destinationVertex = destinationVertex;
	    }

}
