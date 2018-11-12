package DijkstraAlo;

public class App {

	public static void main(String[] args) {
		
		/*Vertex vertex0 = new Vertex("A");
		Vertex vertex1 = new Vertex("B");
		Vertex vertex2 = new Vertex("C");
		
		vertex0.addNeighbour(new Edge(1,vertex0,vertex1));
		vertex0.addNeighbour(new Edge(1,vertex0,vertex2));
		vertex1.addNeighbour(new Edge(1,vertex1,vertex2));*/
		
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		
		
		v1.addNeighbour(new Edge(7,v1,v2));
		v1.addNeighbour(new Edge(9,v1,v3));
		v1.addNeighbour(new Edge(14,v1,v6));
		
		v2.addNeighbour(new Edge(15,v2,v4));
		v2.addNeighbour(new Edge(10,v2,v3));
		
		v3.addNeighbour(new Edge(2,v3,v6));
		v3.addNeighbour(new Edge(11,v3,v4));
		v3.addNeighbour(new Edge(10,v3,v2));
		
		v4.addNeighbour(new Edge(6,v4,v5));
		
		v6.addNeighbour(new Edge(9,v6,v5));
		
		
		ShortestPath shortestPath = new ShortestPath();
		
		//compute distance for every vertex from the source vertex 
		shortestPath.computePaths(v1);
		
		//computing the shortest distance for the target vertex from the source vertex
		System.out.println(shortestPath.getShortestPathTo(v5) + "min distance " + v5.getMinDistance());
		
	}
}
