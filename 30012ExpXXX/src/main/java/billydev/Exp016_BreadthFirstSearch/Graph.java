package billydev.Exp016_BreadthFirstSearch;

import java.util.LinkedList;
import java.util.ListIterator;

public class Graph {

    int v ; 	
	//LinkedList edges= new LinkedList<Integer>(); 
	LinkedList<Integer>[] adj; 

	
	
	Graph(int vertexNumber){
		v=vertexNumber; 
		adj=new LinkedList[v];  
		for(int i=0;i<v; i++){
			adj[i]=new LinkedList<Integer>(); 
		}
		
	}
	
	public void addEdge(int v, int e){
		adj[v].add(e); 
	}
	
	public void BFS(int vertex){
		
		boolean[] visited= new boolean[v];
		LinkedList queue= new LinkedList<Integer>(); 
		visited[vertex]=true; 
		queue.add(vertex); 
		
		while(queue.size()>0){
			

			int current=(int)queue.poll();
			System.out.print(current+" ");
			                                       //BL: all goint to be put in the queue will be the next generation nodes
			ListIterator listIterator = adj[current].listIterator(); //BL: go through adj of current node
			while(listIterator.hasNext()){                 //BL: just put into the queue ,then all will be output in the outer loop; choose the last node to continue
				
				int n=(int)listIterator.next();
				if(!visited[n]){
					queue.offer(n);
					visited[n]=true; 
				}
				
				
				
			}
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		Graph g=new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2,0);
		g.addEdge(2,3);
		g.addEdge(3,3);
		
		g.BFS(2) ;
		//g.BFS(1);
		//g.BFS(3);

	}

}
