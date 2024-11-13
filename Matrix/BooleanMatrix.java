package Matrix;

public class BooleanMatrix {
    private static void setZero(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        //Iterate through each elements in marix
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    int ind =i-1;
                    while(ind>=0){
                        // Mark all elements in the same column
                        // as -1, except for other 1's
                        if(mat[ind][j] !=1 ){
                            mat[ind][j] = -1;
                        }
                        ind--;
                    }
                    ind =i+1;
                    while(ind<row){
                        if (mat[ind][j] != 1) {
                            mat[ind][j] = -1;
                        }
                        ind++;
                    }
                  // Mark all elements in the same row as
                  // -1, except for other 1's
                  ind = j-1;
                  while(ind>=0){
                    if (mat[i][ind] != 1) {
                        mat[i][ind] = -1;
                    }
                    ind--;
                  }
                  ind = j + 1;
                  while (ind < col) {
                    if (mat[i][ind] != 1) {
                        mat[i][ind] = -1;
                    }
                    ind++;
                }
                }
            }
        }
            // Iterate through the matrix again, setting all
        // -1's to 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] < 0) {
                    mat[i][j] = 1;
                }
            }
        }
    }
    public static void main(String args[]){
        int mat[][] = {{1,0,0,1},
                        {0,0,1,0},
                        {0,0,0,0}};
        setZero(mat);
        System.out.println("The Final Matrix is:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    
    }
        
}
