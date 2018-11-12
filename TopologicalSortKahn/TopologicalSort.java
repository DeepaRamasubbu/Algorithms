package TopologicalSortKahn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/*
 * 1.initialize inDegree[] for all the vertices
 * 2.initialize Queue with inDegree 0 vertices
 * 3.Dequeue and output vertex
 * 4.Reduce inDegree of all the vertices adjacent to vertex and enqueue any 0 in-degree vertices.  
 */
public class TopologicalSort {

	private int V;
	private Map<Vertex, Integer> inDegree = new HashMap<>();

	public Map<Vertex, Integer> getInDegree() {
		return inDegree;
	}

	public TopologicalSort(int v) {

	}

	public void sort(Vertex v) {
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(find0Degree());
		while(!q.isEmpty()){
			Vertex removedV = q.remove();
			System.out.println(removedV);
			reFind0Degree(removedV);
			inDegree.remove(removedV);
			Vertex s = find0Degree();
			if(s!=null)
				q.add(find0Degree());
		}
	}
	
	public void  reFind0Degree(Vertex src){
	
		for(Vertex dest:src.getNeighbourList()){
			inDegree.put(dest, inDegree.get(dest).intValue()-1);
		}
	}
	
	public Vertex find0Degree(){
		for(Entry<Vertex, Integer> i :inDegree.entrySet()){
			if (i.getValue().intValue() == 0){
				return i.getKey();
			}
		}
		return null;
	}

	public void fillinDegree(Vertex vert) {
		for (Vertex node : vert.getNeighbourList()) {
			if (inDegree.containsKey(node))
				inDegree.put(node, inDegree.get(node).intValue() + 1);
			else
				inDegree.put(node, 1);
		}
	}

}
