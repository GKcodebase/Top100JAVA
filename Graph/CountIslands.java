package Graph;

public class CountIslands {
    static boolean isSafe(char[][]M, int r, int c, boolean [][]visited){
        int ROW = M.length;
        int COL = M[0].length;
        return r >=0 && r< ROW && c>=0 && c<COL && M[r][c] == '1' && !visited[r][c];
    }
    static void DFS(char[][] M, int r, int c, boolean [][] visited){
        int rNbr[] = {-1,-1,-1,0,0,1,1,1};
        int cNbr[] = {-1,0,1,-1,1,-1,0,1};

        visited[r][c] = true;
        for(int k=0;k<8;k++){
            int newR = r+rNbr[k];
            int newC = c+cNbr[k];
            if(isSafe(M,newR,newC,visited))
                DFS(M,newR,newC,visited);
        }
    }
    public static int getCount(char[][] M){
        int ROW = M.length;
        int COLOUMN = M[0].length;

        boolean visited[][] = new boolean[ROW][COLOUMN];

        int count =0;
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COLOUMN;j++){
                if(M[i][j] == '1' && !visited[i][j]){
                    DFS(M , i, j, visited);
                    count++;
                }    
            }
        }
        return count;
    }
    public static void main(String args[]){
        char[][] M = {
            { '1', '1', '0', '0', '0' },
            { '0', '1', '0', '0', '1' },
            { '1', '0', '0', '1', '1' },
            { '0', '0', '0', '0', '0' },
            { '1', '0', '1', '1', '0' }
        };

        System.out.println(getCount(M));
    }
}
