class Solution {
    public String multiply(String num1, String num2) {
        int n= num1.length();
        int m= num2.length();
        if(n==0 || m==0 || num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int[]ans = new int[n+m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                int one= num1.charAt(i)-'0';
                int second= num2.charAt(j)-'0';
                int digit= one*second + ans[i+j+1];
                ans[i+j+1]= digit%10;
                ans[i+j]+=digit/10;
            }
        }
        StringBuilder s= new StringBuilder();
        for(int i=0;i<ans.length;i++){
            if(s.length()==0 && ans[i]==0){
                continue;
            }
            s.append(ans[i]);
        }
        
        return s.toString();
    }
}


