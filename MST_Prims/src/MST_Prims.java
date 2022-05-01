import java.util.*;
import java.lang.*;

class Node{		// Properties of each node in the mst
	int nodeNumber;
	int cost;
	boolean pickStat;
	Node parent;
	
	Node(int nodeNumber){
		this.cost = Integer.MAX_VALUE;
		this.pickStat = false;
		this.nodeNumber = nodeNumber;
	}
}

class Main {
	static int n;
	static int[][] adjMat;
	static Node[] vertices;
	
	static int findMin() {
		int min = Integer.MAX_VALUE;
		int index =-1;	
		for(int i=0; i<n; i++) {
			if(vertices[i].cost < min && !vertices[i].pickStat ) {	//check for minimum cost node yet to be picked
				min = vertices[i].cost;
				index = i;
			}
		}
		return index;
	}
	
	// Finds the MST using the Adjacency matrix
	
	static void findMST() {
		vertices[0] = new Node(0);		// Node initialization
		vertices[0].cost = 0;		//setting the cost of the first node to 0
		for(int i=1;i<n; i++) {
			vertices[i] = new Node(i);
		}	
		
		for(int i=0; i<n-1; i++) {
			int index = findMin();
			vertices[index].pickStat = true;	// set the minimum weight node as picked
			
			// Traverse the index row of adjacency matrix
			for(int j = 0; j<n; j++) {
				
				//Check for non-zero elements which means connected to node[index] 	
				if(adjMat[index][j] != 0) {
					
					// Check if node[index] has lower cost connection to node[j]	
					if(adjMat[index][j] < vertices[j].cost && !vertices[j].pickStat) {	
						vertices[j].cost = adjMat[index][j];
						vertices[j].parent = vertices[index];
					}
				}
				
			}
		}
	}
	
	
	// Adds a edge between two vertices with specified weight
	static void addEdge(int from, int to, int weight) {		
		adjMat[from][to] = weight;
		adjMat[to][from] = weight;
		
	}
	
	static void printMST() {
		for(int i = 0; i<n; i++) {
			if(vertices[i].parent!= null) {
				System.out.println(vertices[i].parent.nodeNumber + " - " + vertices[i].nodeNumber 
						+ " weight: " + vertices[i].cost);
			}
		}
	}
	

	public static void main(String[] args) {
		
		//Scanner sc = new Scanner(System.in);
		//System.out.println("Enter the total number of vertices:");
		
		n = 6;
		adjMat = new int[n][n];
		vertices = new Node[n];
		for(int i=0; i<n; i++) {
			adjMat[i][i] = 0; //Setting all the diagonal elements to zero
		}
		addEdge(0,1, 4);
		addEdge(0, 2, 6);
		addEdge(1, 2, 6);
		addEdge(1, 3, 3);
		addEdge(1, 4, 4);
		addEdge(2, 3, 1);
		addEdge(3, 4, 2);
		addEdge(3, 5, 3);
		addEdge(4, 5, 7);
		
		findMST();
		printMST();
	}

}


