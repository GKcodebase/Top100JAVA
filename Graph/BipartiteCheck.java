package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteCheck {
    public static boolean isBiPartiteCheck(int V, List<List<Integer>> adj) {
        int colour[] = new int[V];
        Arrays.fill(colour, -1);

        for (int i = 0; i < V; i++) {
            if (colour[i] == -1) {
                colour[i] = 0;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);

                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : adj.get(u)) {
                        if (colour[v] == -1) {
                            colour[v] = 1 - colour[u];
                            q.offer(v);
                        } else if (colour[u] == colour[v])
                            return false;

                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int V = 4;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Adding edges (undirected)
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(0);
        adj.get(0).add(3);
        if (isBiPartiteCheck(V, adj))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
