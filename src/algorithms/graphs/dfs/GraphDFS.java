package algorithms.graphs.dfs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Very good explanation : https://www.youtube.com/watch?v=uT1p5Eiw9CE
 * 
 * @author sandeep kulkarni
 *
 */

/**
 * Inner class Vertex denotes each vertex in Graph. 
 * Each Vertex object has 2 things - Name of vertex, Adjacent List of neighboring vertices (denoted by Neighbour object) 
 */
class Vertex {
	String vertexName;
	Neighbour adjacentList;

	public Vertex(String vertexName, Neighbour adjacentList) {		
		this.vertexName = vertexName;
		this.adjacentList = adjacentList;
	}	
}
/**
 * Inner class Neighbour denotes each neighboring vertices. If Neighbour can also have more neighbours. 
 */
class Neighbour {
	int vertexNo; //denotes index of itself (neighbour)
	Neighbour next; //denotes next neighbour if present

	public Neighbour(int vertexNo, Neighbour next) {
		this.vertexNo = vertexNo;
		this.next = next;
	}
}


public class GraphDFS {

	Vertex[] adjacentVertices;	//array of all vertices in graph

	private int getIndexForVertexName(String vertexName){
		for(int i = 0; i < adjacentVertices.length; i++){
			if(adjacentVertices[i].vertexName.equals(vertexName)){
				return i;
			}
		}
		return -1;
	}

	private  void initializeGraph(String fileName) throws FileNotFoundException {
		Scanner s = new Scanner(new File(fileName));

		//"directed" or "undirected"
		String graphType = s.nextLine();

		boolean isUndirected = true;
		if(graphType.equalsIgnoreCase("directed")){
			isUndirected = false;
		}

		int noOfVertices = s.nextInt();
		adjacentVertices = new Vertex[noOfVertices];

		//read vertices and initialize Vertex object
		for(int i =0; i < noOfVertices; i++) {
			adjacentVertices[i] = new Vertex(s.next(), null);	//for now just populate vertex name, set neighbour list to null
		}


		//read edges
		while(s.hasNext()) {

			int startVertex = getIndexForVertexName(s.next()); 
			int endVertex = getIndexForVertexName(s.next());

			//Add endVertex in front of startVertex adjacent list
			adjacentVertices[startVertex].adjacentList = new Neighbour(endVertex, adjacentVertices[startVertex].adjacentList);
			if(isUndirected){
				//As undirected, also Add startVertex in front of endVertex adjacent list
				adjacentVertices[endVertex].adjacentList = new Neighbour(startVertex, adjacentVertices[endVertex].adjacentList);
			}

		}		

		s.close();		
	}


	//recursive dfs 
	private void DFS(int vertexNo, boolean[] visited) {
		//Mark vetex as visited
		visited[vertexNo] = true;

		System.out.println("** Visiting : " + adjacentVertices[vertexNo].vertexName);

		for(Neighbour n = adjacentVertices[vertexNo].adjacentList; n != null; n=n.next){			
			if(!visited[n.vertexNo]) {
				System.out.println(adjacentVertices[vertexNo].vertexName + " -> " + adjacentVertices[n.vertexNo].vertexName);
				//Call DFS recursivelly
				DFS(n.vertexNo, visited);
			}
		}

	}


	//Maintain a visited[] array and call dfs() for all unvisited nodes (even for nodes which are not reachable from start node)
 	public void call_DFS() {
		boolean[] visited = new boolean[adjacentVertices.length];

		for (int i = 0; i  < visited.length; i ++) {
			if (!visited[i]) {
				System.out.println("\n\n STARTING AT " + adjacentVertices[i].vertexName);
				DFS(i , visited);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		GraphDFS graph = new GraphDFS();

		//Initialize the Graph from input file 1 : Directed graph
		graph.initializeGraph("d://dfs_input1.txt");
		
		//Input 2 : Undirected graph
		//graph.initializeGraph("d://dfs_input1.txt");

		graph.call_DFS();

	}

}
