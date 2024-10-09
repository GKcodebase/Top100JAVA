package Graph;
import java.util.*;
public class TopologicalSort {
    static void sortingUtil(List<List<Integer>> adj, boolean[] visited, Stack st, int i ){
        visited[i] = true;
        for(int j : adj.get(i)){
            if(!visited[j]){
                sortingUtil(adj,visited,st,j);
            }
        }
        st.push(i);
    }
    public static void getTopologicalSort(List<List<Integer> > adj,
    int V){
        Stack<Integer> stack = new Stack();
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i]){
                sortingUtil(adj,visited,stack,i);
            }
        }
        System.out.print(
            "Topological sorting of the graph: ");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    public static void main(String args[]){
      // Number of nodes
      int V = 4;

      // Edges
      List<List<Integer> > edges = new ArrayList<>();
      edges.add(Arrays.asList(0, 1));
      edges.add(Arrays.asList(1, 2));
      edges.add(Arrays.asList(3, 1));
      edges.add(Arrays.asList(3, 2));

      // Graph represented as an adjacency list
      List<List<Integer> > adj = new ArrayList<>(V);
      for (int i = 0; i < V; i++) {
          adj.add(new ArrayList<>());
      }

      for (List<Integer> i : edges) {
          adj.get(i.get(0)).add(i.get(1));
      }

      getTopologicalSort(adj, V);
    }
}
