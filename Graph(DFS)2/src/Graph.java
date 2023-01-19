//------------------------------------------------------------------------------------------------------------------------------------
// Title: Graph class
// Author: H�seyin Ufuk Y�lmaz
// ID: 21826286904
// Section: 02
// Assignment: 1
// Description: This class provides graphical structure creation and calls the Deep First Search class and activates the print method.
//-------------------------------------------------------------------------------------------------------------------------------------
import java.util.Collections;

public class Graph {
	public final int V;
	public Bag<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new Bag<Integer>();
		}
	}

	public int V()
	//--------------------------------------------------------
	 // Summary: returns the size of array	
	 // Precondition:-
	 // Postcondition: returned the size of array
	 //--------------------------------------------------------
	{
		return V;
	}

	public void addEdge(int v, int w)
	//--------------------------------------------------------
		 // Summary: creates path between two point.	
		 // Precondition: v and w both are integer.
		 // Postcondition: created path between two point.	
		 //--------------------------------------------------------
	{
		adj[v].add(w);
		adj[w].add(v);
	}

	public Iterable<Integer> adj(int v)
	//--------------------------------------------------------
	 // Summary: it provides to iterate in array and returns first element in array according to the parameter.
	 // Precondition: v is an integer.
	 // Postcondition: it provided to iterate in array and returned first element in array according to the parameter.
	 //--------------------------------------------------------
	{

		return adj[v];
	}
  public void PrintBreadthFirstSearch(Graph G, int StartIndex, int FinalIndex)
	 //--------------------------------------------------------
	 // Summary: BreadthFirstSearch class is called and path(s) are printed.
	 // name is given.
	 // Precondition: G is an Element of Graph class, firstIndex is an integer and final�ndex is an integer.
	 // Postcondition: Path(s) printed the console if there is a path.
	 //--------------------------------------------------------
  {
	  BreadthFirstSearch bfs = new BreadthFirstSearch(G,StartIndex);
	  bfs.arr_path.add(StartIndex);
	  bfs.path.add(StartIndex);
	  bfs.HasPathsChecker(G, StartIndex, FinalIndex);
	if(BreadthFirstSearch.count2==0) {
		System.out.println("No path");
		return;
	}
	  bfs.PrintPaths(bfs.arr);
  }
}
