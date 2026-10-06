class CountSquares {
    int[][]count= new int[1001][1001];
    public CountSquares() {
        
    }
    
    public void add(int[] point) {
        int x=point[0];
        int y=point[1];
        count[x][y]++;
        
    }
    
    public int count(int[] point) {
        int n=point.length;
         int ans =0;
        int x=point[0];
        int y=point[1];
        for(int i=0;i<=1000;i++){

            if(x==i ||count[i][y]==0)continue;
             int d =i-x;
             if(y+d>=0 && y+d<=1000){
                ans +=count[i][y]*count[i][y+d]*count[x][y+d];
             }
              if(y-d>=0 && y-d<=1000){
                ans +=count[i][y]*count[i][y-d]*count[x][y-d];
             }

        }
        return ans ;
        
    }
}

