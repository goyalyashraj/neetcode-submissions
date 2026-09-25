class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double [][] res = new double[n][2];
        for(int pos =0;pos<n;pos++){
            res[pos][0]= position[pos];
             res[pos][1]= (double)(target-position[pos])/speed[pos];
        }
        Arrays.sort(res,(b,a)->Double.compare(a[0],b[0]));
        double minSpeed= 0.0;
        int fleet =0;
        for(int i=0;i < res.length;i++){
            double currSpeed =res[i][1];
            if(currSpeed>minSpeed){
                fleet++;
                minSpeed= currSpeed;
            }

        }
        return fleet;

            
    }
}
