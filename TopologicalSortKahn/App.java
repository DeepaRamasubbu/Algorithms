package TopologicalSortKahn;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String args[]){
		TopologicalSort topo = new TopologicalSort(6);
		
		List<Vertex> vertexList = new ArrayList<Vertex>();
		
		Vertex v1 = new Vertex('A');
		Vertex v2 = new Vertex('B');
		Vertex v3 = new Vertex('C');
		Vertex v4 = new Vertex('D');
		Vertex v5 = new Vertex('E');
		Vertex v6 = new Vertex('F');
		
		v1.addNeighbour(v2);
		v1.addNeighbour(v4);
		
		v2.addNeighbour(v3);
		
		v3.addNeighbour(v4);
		v3.addNeighbour(v5);
		
		v4.addNeighbour(v5);
		
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);
		vertexList.add(v6);
		
		for(Vertex v:vertexList){
			topo.getInDegree().put(v, 0);
		}
		for(Vertex v:vertexList){
			topo.fillinDegree(v);
		}
		
		System.out.println("Indegree are " + topo.getInDegree());
		
		topo.sort(v1);
		
		
	}
}
