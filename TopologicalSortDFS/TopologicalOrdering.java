package TopologicalSortDFS;

import java.util.Stack;

public class TopologicalOrdering {

	private Stack<Vertex> stack;
	
	public TopologicalOrdering(){
		this.stack = new Stack<>();
	}
	/*
	 * The algorithm loops through each node of the graph, in an arbitrary order, initiating a depth-first search that terminates when it hits any node 
	 * that has already been visited since the beginning of the topological sort or the node has no outgoing edges (i.e. a leaf node):
	 */
	public void dfs(Vertex vertex){
	
		vertex.setVisited(true);
		
		for(Vertex v : vertex.getNeighbourList()){
			if( !v.isVisited()){
				dfs(v);
			}
		}
		
		stack.push(vertex);
	}
	
	public Stack<Vertex> getStack(){
		return this.stack;
	}
}
