class Solution {
    public int reverse(int n) {
        // if(n==Integer.MIN_VALUE){
        //     return 0;
        // }
        int num=0;
        while(n!=0){
            int digit=n%10;
            if(num>Integer.MAX_VALUE/10 || num<Integer.MIN_VALUE/10){
                return 0;
            }
            num = num*10+digit;
            n/=10;
        }
        return num;
        
    }
}
