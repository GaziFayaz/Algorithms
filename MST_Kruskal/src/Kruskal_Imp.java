import java.util.*;
import java.lang.*;

/*
 * Class for edges
 * Static "edgesPicked" indicates how to many of the edges have yet been picked.
 * "from" indicates source node number
 * "to" indicates destination node number
 * "weight" indicates the weight of edge between node "from" to "to"
 *  "isPicked" indicates if the the specific edge object has been used to form the MST
 */
class Edge{
	static int edgesPicked=0;
	int from;
	int to;
	int weight;
	boolean isPicked = false;
	
	Edge(int from, int to, int weight){		//constructor
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
}


/*
 *  Class for nodes
 *  "nodeNumber" specifies the 
 */
class Node{
	int nodeNumber;
	Node parent;
	int rank = 0;
	
	Node(int nodeNumber){
		this.nodeNumber = nodeNumber;
	}
}

public class Kruskal_Imp {
	static Node[] nodes;
	static Edge[] edges;
	
	static Node getAbsParent(Node node) {
		if(node.parent == null) {
//			System.out.println("abs parent "+ node.nodeNumber);
			return node;
		}
		else {
			return getAbsParent(node.parent);
		}
	}
	
	static boolean sameAbsParent(Node from, Node to) {
//		System.out.println("Comparing abs parent of node " + from.nodeNumber + " and node " + to.nodeNumber);
		if(getAbsParent(from) == getAbsParent(to)) {
			return true;
		}
		else return false;
	}
	
	static void getMST() {
		for(int i=0; i<edges.length; i++) {
			if(Edge.edgesPicked==nodes.length-1 && Edge.edgesPicked == edges.length) {
//				System.out.println("Number of picked edges: "+ Edge.edgesPicked + " is equal to 1 less than number of nodes- " + nodes.length);
//				System.out.println("---end of getMST---");
				return;
			}
			else {
//				System.out.println("Number of picked edges: " + Edge.edgesPicked + "--- Number of nodes- " + nodes.length);
				if(sameAbsParent(nodes[edges[i].from], nodes[edges[i].to])) {
//					System.out.println( "abs node of " + nodes[edges[i].from].nodeNumber + " and node " + nodes[edges[i].to].nodeNumber + " is same");
					continue;
				}
				else {
					Edge.edgesPicked++;
					//edges[i].isPicked = true;
					if(getAbsParent(nodes[edges[i].from]).rank == getAbsParent(nodes[edges[i].to]).rank) {
						getAbsParent(nodes[edges[i].from]).parent = getAbsParent(nodes[edges[i].to]);
//						System.out.println("Updated abs parent of node " + nodes[edges[i].from].nodeNumber + " and node " + nodes[edges[i].to].nodeNumber);
//						getAbsParent(nodes[edges[i].from]);
//						getAbsParent(nodes[edges[i].to]);
						getAbsParent(nodes[edges[i].to]).rank++;
						edges[i].isPicked = true;
					}
					else if(getAbsParent(nodes[edges[i].from]).rank < getAbsParent(nodes[edges[i].to]).rank	) {
						getAbsParent(nodes[edges[i].from]).parent = getAbsParent(nodes[edges[i].to]);
//						System.out.println("Updated abs parent of node " + nodes[edges[i].from].nodeNumber + " and node " + nodes[edges[i].to].nodeNumber);
//						getAbsParent(nodes[edges[i].from]);
//						getAbsParent(nodes[edges[i].to]);
						edges[i].isPicked = true;
					}
					else {
						getAbsParent(nodes[edges[i].to]).parent = getAbsParent(nodes[edges[i].from]);
//						System.out.println("Updated abs parent of node " + nodes[edges[i].from].nodeNumber + " and node " + nodes[edges[i].to].nodeNumber);
//						getAbsParent(nodes[edges[i].from]);
//						getAbsParent(nodes[edges[i].to]);
						edges[i].isPicked = true;
					}
				}
				
			}
		}
	}
	
	static void printMST() {
		for(int i=0; i<edges.length; i++) {
			if(edges[i].isPicked) {
				System.out.println("From " + edges[i].from + " to " + edges[i].to + " of weight " + edges[i].weight );
			}
		}
	}
	
	static void printAllEdges() {
		for(int i=0; i<edges.length; i++) {
			System.out.println("From " + edges[i].from + " to " + edges[i].to + " of weight " + edges[i].weight + "...Is picked = " + edges[i].isPicked);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nNode = 6, nEdge=10;	// node and edges count predetermined
		nodes = new Node[nNode];	// initialization of node array
		for(int i=0; i<nNode; i++) {
			nodes[i] = new Node(i);		// initialization of every element of node array
		}
		
		/*
		 * initialization of edge array
		 * input the edges sorted by the weight -- otherwise wrong output
		 */
		edges = new Edge[nEdge];
		
//		for(int i= 0; i<nEdge; i++) {		// In case of user input
//			int n1, n2, weight;
//			System.out.println("From: ");
//			n1 = sc.nextInt();
//			System.out.println("To: ");
//			n2 = sc.nextInt();
//			System.out.println("Weight: ");
//			weight = sc.nextInt();
//			edges[i]= new Edge(n1,n2,weight);
//		}
		
		edges[0] = new Edge(0,1,1);	
		edges[1] = new Edge(1,3,1);
		edges[2] = new Edge(2,4,1);
		edges[3] = new Edge(0,2,2);
		edges[4] = new Edge(2,3,2);		// These need to entered sorted in terms of their weight
		edges[5] = new Edge(3,4,2);
		edges[6] = new Edge(1,2,3);
		edges[7] = new Edge(1,4,3);
		edges[8] = new Edge(4,5,3);
		edges[9] = new Edge(3,5,4);
		
		
		
		getMST();	//call to get the MST
//		System.out.println("All edges: ");
//		printAllEdges();
		
//		System.out.println("Node details: ");
//		for(int i = 0; i<nodes.length; i++) {
//			if(nodes[i].parent!=null)
//			System.out.println("node number: " + nodes[i].nodeNumber + " parent: " + nodes[i].parent.nodeNumber + " rank: " + nodes[i].rank);
//		}
		
		System.out.println("MST edges: ");
		printMST();		// call to print the MST
		
	}

}
