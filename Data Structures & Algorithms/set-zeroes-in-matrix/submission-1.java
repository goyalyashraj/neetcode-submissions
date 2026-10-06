class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstRow=false;

        for(int r=0;r<n;r++){

            if(matrix[r][0]==0){
                firstRow=true;
            }
            for(int c=1;c<m;c++){
                if(matrix[r][c]==0){
                    matrix[r][0]=0;
                    matrix[0][c]=0;
                }
            }
        }
        for(int r=1;r<n;r++){
            for(int c=1;c<m;c++){
                if(matrix[r][0]==0 || matrix[0][c]==0){
                    matrix[r][c]=0;
                }
            }
        }

        if(matrix[0][0]==0){
            for(int j=1;j<m;j++){
                matrix[0][j]=0;

            }
        }
        if(firstRow){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
    }
}
