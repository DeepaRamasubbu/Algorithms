package TopologicalSortKahn;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	
	private char data;
	private List<Vertex> neighbourList;
	private boolean visited;
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex(char data){
		this.data = data;
		this.neighbourList = new ArrayList<Vertex>();
	}

	public int getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public List<Vertex> getNeighbourList() {
		return neighbourList;
	}

	public void setNeighbourList(List<Vertex> neighbourList) {
		this.neighbourList = neighbourList;
	}
	
	public void addNeighbour(Vertex v){
		this.neighbourList.add(v);
	}
	
	@Override
	public String toString() {
		return this.data+"";
	}

}

