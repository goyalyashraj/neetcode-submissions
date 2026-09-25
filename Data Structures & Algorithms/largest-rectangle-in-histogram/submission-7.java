// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         Stack<Integer> height = new Stack<>();
//         int n = heights.length;
//         int maxarea=0;
//         int currentheight=0;

//         for(int i=0;i<=n;i++){
//             currentheight = (i==n)? 0 :heights[i];
//             while(!height.isEmpty() && currentheight < heights[height.peek()]){
//                 int h = heights[height.pop()];
//                 int w;
//                 if(height.isEmpty()){
//                     w=i;
//                 }else{
//                     w=i-height.peek()-1;
//                 }
//                 maxarea = Math.max(maxarea,h*w);
//             }
//             height.push(i);

//         }
//         return maxarea;
        
        
//     }
// }
// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         Stack<Integer> area = new Stack<>();
//         int maxarea=0;
//         int current =0;
//         for(int i=0;i<=n;i++){
//             current =(i==n) ?0:heights[i];
//             while(!area.isEmpty() && current < heights[area.peek()]){
//                 int h = heights[area.pop()];
//                 int w;
//                 if(area.isEmpty()){
//                     w=i;
//                 }
//                 else{
//                     w = i-area.peek()-1;
//                 }
//                 maxarea = Math.max(maxarea,h*w);
//             }
//             area.push(i);

//         }
//         return maxarea;
        
//     }
// }

class Solution{
    public int  largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int[]left = new int[n];
        int []right = new int[n];
        for(int i =0;i<n;i++){
            while(!stack.isEmpty()&& heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            left[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
           for(int i =n-1;i>=0;i--){
            while(!stack.isEmpty()&& heights[stack.peek()]>=heights[i]){
                stack.pop();

            }
            right[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
            int area =0;
            for(int i =0;i<n;i++){
                int w = right[i]-left[i]-1;
                int a = w*heights[i];
                area = Math.max(area,a);
            }
            return area ;
    }
}