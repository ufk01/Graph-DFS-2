import java.util.*;

public class BreadthFirstSearch {
	public static int count, count1, count2, counter;
	public int temp, numberCounter;
	Stack<Integer> path = new Stack<Integer>();
	ArrayList<Integer> arr_path = new ArrayList<Integer>();
	ArrayList<String> arr = new ArrayList<String>();

	public static String exp;
	public boolean marked[][];

	public BreadthFirstSearch(Graph G, int first) {
		count = 1;
		count1 = numberCounter = count2 = counter = 0;
		marked = new boolean[G.V()][G.V()];
		temp = first;
		exp = "";
	}


	public boolean isPath(Graph G, boolean[][] marked, int index)
    //--------------------------------------------------------
	 // Summary: Checking connection between two points in the graph.
	 // Precondition: G is an element of Graph class and index is an integer.
	 // Postcondition: Checked connection between two points in the graph.
	 //--------------------------------------------------------
	{
		for (int temp : G.adj(index)) {
			if (!marked[index][temp]) {
				return true;
			}
		}
		return false;
	}

	public void HasPathsChecker(Graph G, int StartIndex, int FinalIndex)
    //--------------------------------------------------------
	 // Summary: Checking connection between two points in the graph.
	 // Precondition: G is an element of Graph class,c StartIndex is an integer and FinalIndex is an integer.
	 // Postcondition: Checked connection between two points in the graph.
	 //--------------------------------------------------------
	{

		if (counter == G.adj[temp].size || arr_path.isEmpty()) {
			return;
		}

		for (int w : G.adj(StartIndex)) {
			if (!isPath(G, marked, StartIndex) && !arr_path.isEmpty()) {

				arr_path.remove(arr_path.size() - 1);
				if (!arr_path.isEmpty())
					HasPathsChecker(G, arr_path.get(arr_path.size() - 1), FinalIndex);
			}
			if (arr_path.size() == 0) {
				return;
			} else {
				if (marked[StartIndex][w]) {
					continue;
				} else {
					marked[StartIndex][w] = true;
					marked[w][StartIndex] = true;
					if (!arr_path.contains(w)) {
						path.add(w);
						arr_path.add(w);
						if (w == FinalIndex) {
							arr_path.remove(arr_path.size() - 1);
							PrintArray(arr_path, FinalIndex);
							path.remove(path.size() - 1);
							numberCounter = arr_path.get(arr_path.size() - 1);

							for (int v : G.adj(FinalIndex)) {
								if (!marked[FinalIndex][v]) {
									continue;
								} else {
									count1++;
								}
							}
							if (count1 == G.adj[FinalIndex].size()) {
								for (int v : G.adj(FinalIndex)) {
									marked[v][FinalIndex] = false;
									marked[FinalIndex][v] = false;
								}
								counter++;
								path.clear();
								arr_path.clear();
								arr_path.add(temp);
								path.add(temp);
								HasPathsChecker(G, temp, FinalIndex);

							} else {
								count1 = 0;
							}
							continue;
						}
						if (arr_path.size() >= 4 || isPath(G, marked, w) == false) {
							if (numberCounter == 0) {
								marked[arr_path.get(arr_path.size() - 1)][arr_path.get(arr_path.size() - 2)] = false;
								arr_path.remove(arr_path.size() - 1);
							} else {
								while (arr_path.get(arr_path.size() - 1) != numberCounter) {
									marked[arr_path.get(arr_path.size() - 1)][arr_path
											.get(arr_path.size() - 2)] = false;
									arr_path.remove(arr_path.size() - 1);

								}
							}
						}
					}
				}
				HasPathsChecker(G, arr_path.get(arr_path.size() - 1), FinalIndex);
			}
		}

	}

	public void PrintArray(ArrayList<Integer> path, int FinalIndex) 
	 //--------------------------------------------------------
	 // Summary: That method provides to hold paths that are founded in graph
	 // Precondition: path is an array list and Finalindex is an integer
	 // Postcondition: That method provided to hold paths that are founded in graph
	 //--------------------------------------------------------
	{

		if (path.size() > 4 || path.size() <= 1) {
			return;
		}
		count2++;
		Collections.sort(path);
		for (int l = 0; l < path.size(); l++) {
			int temp = path.get(l);
			char c_exp = ((char) temp);
			String s_exp = Character.toString(c_exp);
			exp += s_exp;

		}
		char a = (char) FinalIndex;
		exp += Character.toString(a);
		arr.add(exp);
		exp = "";
		count++;
	}

	public void PrintPaths(ArrayList<String> arr) 
	     //--------------------------------------------------------
		 // Summary: That method provides to keep paths.
		 // Precondition: arr is an array list.
		 // Postcondition: That method provided to keep paths.
		 //--------------------------------------------------------
	{
		Collections.sort(arr);
		HashMap<Integer, String> h = new HashMap<Integer, String>();
		for (int i = 0; i < arr.size(); i++) {
			int temp = arr.get(i).length();
			if (h.containsKey(temp)) {
				h.put(arr.get(i).length() + 1, arr.get(i));

			} else {
				h.put(arr.get(i).length(), arr.get(i));
			}
		}

		for (int i = 3; i <= h.size() + 3; i++) {
			if (h.containsKey(i)) {
				PrintSortString(h.get(i));
				System.out.println();
			}
		}
	}

	public void PrintSortString(String exp)
	//--------------------------------------------------------
	 // Summary: it provides to print paths.
	 // Precondition: exp is a string.
	 // Postcondition: it provided to print paths.
	 //--------------------------------------------------------
	{
		char[] arr = exp.toCharArray();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + "-");
			}
		}
	}
}
