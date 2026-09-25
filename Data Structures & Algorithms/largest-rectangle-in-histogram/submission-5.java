class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> height = new Stack<>();
        int n = heights.length;
        int maxarea=0;
        int currentheight=0;

        for(int i=0;i<=n;i++){
            currentheight = (i==n)? 0 :heights[i];
            while(!height.isEmpty() && currentheight < heights[height.peek()]){
                int h = heights[height.pop()];
                int w;
                if(height.isEmpty()){
                    w=i;
                }else{
                    w=i-height.peek()-1;
                }
                maxarea = Math.max(maxarea,h*w);
            }
            height.push(i);

        }
        return maxarea;
        
        
    }
}
