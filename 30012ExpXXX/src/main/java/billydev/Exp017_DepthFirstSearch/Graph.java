package billydev.Exp017_DepthFirstSearch;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	
	
	int v ;
	LinkedList<Integer>[] adj ; 
	boolean[] visited; 
	
	Graph(int vertex){
		v=vertex; 
		adj=new LinkedList[v];
		for(int i=0;i<v; i++){
			adj[i]=new LinkedList<Integer>(); 
		}
		visited=new boolean[vertex]; 
	}
	
	private void addEdge(int v, int e){
		adj[v].add(e); 
	}
	
	private void DFS(int n) {
		
		
		for(int i=0;i<v;i++){
			visited[i]=false; 
		}
		DFSUtil(n); 
		
	}	

	private void DFSUtil(int n) {
	 if(!visited[n]){
		System.out.print(n+" ");
		visited[n]=true;
		
		Iterator<Integer> it = adj[n].iterator(); 
        while(it.hasNext()){
    	   DFSUtil(it.next()); 
        }
	 }
	}

	public static void main(String[] args) {
		Graph g= new Graph(4); 
		g.addEdge(0, 2);
		g.addEdge(0,1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.DFS(2); 
	}



}
