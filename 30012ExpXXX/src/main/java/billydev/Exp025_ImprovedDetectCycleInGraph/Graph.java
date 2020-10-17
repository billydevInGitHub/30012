package billydev.Exp025_ImprovedDetectCycleInGraph;

public class Graph {

	   int V, E;    // V-> no. of vertices & E->no.of edges
	    Edge edge[]; // /collection of all edges
	 
	    class Edge
	    {
	        int src, dest;
	    };
	 
	    // A class to represent a subset for union-find
	    class subset
	    {
	        int parent, rank;
	    };
	    
	    // Creates a graph with V vertices and E edges
	    Graph(int v,int e)
	    {
	        V = v;
	        E = e;
	        edge = new Edge[E];
	        for (int i=0; i<e; ++i)
	            edge[i] = new Edge();
	    }
	 
	    int find(subset subsets[], int i)
	    {
	        // find root and make root as parent of i (path compression)
	        if (subsets[i].parent != i)
	            subsets[i].parent = find(subsets, subsets[i].parent);
	 
	        return subsets[i].parent;
	    }
	 
	    // A function that does union of two sets of x and y
	    // (uses union by rank)
	    void Union(subset subsets[], int x, int y)
	    {
	        int xroot = find(subsets, x);
	        int yroot = find(subsets, y);
	 
	        // Attach smaller rank tree under root of high rank tree
	        // (Union by Rank)
	        if (subsets[xroot].rank < subsets[yroot].rank)
	            subsets[xroot].parent = yroot;
	        else if (subsets[xroot].rank > subsets[yroot].rank)
	            subsets[yroot].parent = xroot;
	 
	        // If ranks are same, then make one as root and increment
	        // its rank by one
	        else
	        {
	            subsets[yroot].parent = xroot;
	            subsets[xroot].rank++;
	        }
	    }
	 
	 
	    // The main function to check whether a given graph
	    // contains cycle or not
	    int isCycle( Graph graph)
	    {

	        int e = 0;  // An index variable, used for result[]
	        int i = 0;  // An index variable, used for sorted edges

	        
	        // Allocate memory for creating V ssubsets
	        subset subsets[] = new subset[V];
	        for(i=0; i<V; ++i)
	            subsets[i]=new subset();
	 
	        // Create V subsets with single elements
	        for (int v = 0; v < V; ++v)
	        {
	            subsets[v].parent = v;
	            subsets[v].rank = 0;
	        }
	        
	        
	        // Iterate through all edges of graph, find subset of both
	        // vertices of every edge, if both subsets are same, then
	        // there is cycle in graph.
	        for (i = 0; i < graph.E; ++i)
	        {
	            int x = graph.find(subsets, graph.edge[i].src);
	            int y = graph.find(subsets, graph.edge[i].dest);
	 
	            if (x == y)
	                return 1;
	 
	            graph.Union(subsets, x, y);
	        }
	        return 0;
	    }
	 
	    // Driver Method
	    public static void main (String[] args)
	    {
	        /* Let us create following graph
	         0
	        |  \
	        |    \
	        1-----2 */
	        int V = 3, E = 3;
	        Graph graph = new Graph(V, E);
	 
	        // add edge 0-1
	        graph.edge[0].src = 0;
	        graph.edge[0].dest = 1;
	 
	        // add edge 1-2
	        graph.edge[1].src = 1;
	        graph.edge[1].dest = 2;
	 
	        // add edge 0-2
	        graph.edge[2].src = 0;
	        graph.edge[2].dest = 2;
	 
	        if (graph.isCycle(graph)==1)
	            System.out.println( "graph contains cycle" );
	        else
	            System.out.println( "graph doesn't contain cycle" );
	    }
	
}
