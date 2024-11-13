package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {
    static class Quentry{
        int v;
        int dist;
        Quentry(int v, int dist){
            this.v=v;
            this.dist=dist;
        }
    }
    public static int getMinDiceThrows(int move[], int n){
        boolean visited[] = new boolean[n];
        Queue<Quentry> queue  = new LinkedList<>();
        Quentry qe = new Quentry(0, 0);
        visited[0] = true;
        queue.add(qe);
        while(!queue.isEmpty()){
            qe = queue.remove();
            int v = qe.v;
            if(v==n-1)
                break;
            for(int j=v+1;j<=(v+6)&&j<n;++j){
                if(!visited[j]){
                    Quentry a = new Quentry(0,qe.dist+1);
                    if(move[j] !=-1)
                        a.v=move[j];
                    else    
                        a.v=j;
                    queue.add(a);
                }
            }
        }
        return qe.dist;
    }
    public static void main(String args[]){
    // Let us construct the board given in above diagram
    int N = 30;
    int moves[] = new int[N];
    for (int i = 0; i < N; i++)
        moves[i] = -1;

    // Ladders
    moves[2] = 21;
    moves[4] = 7;
    moves[10] = 25;
    moves[19] = 28;

    // Snakes
    moves[26] = 0;
    moves[20] = 8;
    moves[16] = 3;
    moves[18] = 6;

    System.out.println("Min Dice throws required is "
                       + getMinDiceThrows(moves, N));
    }
}
