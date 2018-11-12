package DijkstraAlo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {

	/*
	 * 1. set the source vertex's mindist=0
	 * 2. add the source vertex in q
	 * 3. while q is not empty do
	 * 		1. get the head h of the queue(mindist minimum) , will be src first time
	 * 		2. get all the edges originating from the vertex h , 
	 * 		3. calculate the optimal distance from the source for each of the neighbouring vertex
	 *      4. If found minimum , change the min distance and set the predecessor of the vertex
	 *          
	 */
	public void computePaths(Vertex sourceVertex){
		
		sourceVertex.setMinDistance(0);
		PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(sourceVertex);
		
		while( !priorityQueue.isEmpty() ){
			
			Vertex actualVertex = priorityQueue.poll();
			
			for(Edge edge : actualVertex.getAdjacenciesList()){
				
				Vertex v = edge.getTargetVertex();
				Vertex u = edge.getStartVertex();
				
				double newDistance = actualVertex.getMinDistance() + edge.getWeight();
				
				if( newDistance < v.getMinDistance() ){
				//	priorityQueue.remove(v); // this step not reqd
					v.setMinDistance(newDistance);
					v.setPredecessor(actualVertex);
					priorityQueue.add(v);
				}
			}
		}
	}
	
	public List<Vertex> getShortestPathTo(Vertex targetVertex){
		List<Vertex> path = new ArrayList<>();
		
		for(Vertex vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor()){
			path.add(vertex);
		}
		
		Collections.reverse(path);
		
		return path;
	}
}
