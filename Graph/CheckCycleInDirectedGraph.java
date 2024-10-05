package Graph;
import java.util.*;
public class CheckCycleInDirectedGraph {
    public static boolean isCyclice(List<List<Integer>> adj, int V){
        boolean visited[] = new boolean[V];
        boolean[] recStack = new boolean[V];

        for(int i=0;i<V;i++){
            if(!visited[i] && isCyclicUtil(adj,i,visited,recStack))
                return true;
        }
        return false;
    }
    private static boolean isCyclicUtil(List<List<Integer>> adj, int i, boolean[] visited, boolean[] recStack) {
        if(!visited[i]){
            visited[i] = true;
            recStack[i] = true;

            for(int x : adj.get(i)){
                if(!visited[x] && isCyclicUtil(adj, i, visited, recStack))
                    return true;
                else if(recStack[x])
                    return true;
            }
        }
        recStack[i]= false;
        return false;
    }
    public static void main(String args[]){
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(3);

        // Function call
        if (isCyclice(adj, V)) {
            System.out.println("Contains cycle");
        } else {
            System.out.println("No Cycle");
        }
    }
}
