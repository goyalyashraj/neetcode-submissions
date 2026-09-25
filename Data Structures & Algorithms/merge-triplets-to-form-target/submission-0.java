class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
       boolean first=false;
       boolean sec=false;
       boolean third=false;
        for(int[]triplet :triplets){
            if(triplet[0]>target[0] ||triplet[1]>target[1]||triplet[2]>target[2] ){
                continue;
            }
            if(triplet[0]==target[0]){
                first=true;
            }
            if(triplet[1]==target[1]){
                sec=true;
            }
            if(triplet[2]==target[2]){
                third =true;
            }
        }
        return first && sec && third; 
    }
}
