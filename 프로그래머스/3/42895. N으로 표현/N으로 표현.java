import java.util.*;

class Solution {
    
    static Set<Integer>[] dp;
    
    public int solution(int N, int number) {
        dp = new HashSet[9];
        
        for(int i=0; i<9; i++){
            dp[i]=new HashSet<>();
        }
        
        for(int i=1; i<9; i++){
            int n = 0;
            for(int l=1; l<=i; l++){
                n=n*10+N;
            }
            dp[i].add(n);
            comb(i);
            if(dp[i].contains(number)) return i;
        }
        
        return -1;
    }
    
    public void comb(int i){
        for(int j=1; j<=i/2; j++){
            Integer[] arr1 = dp[j].toArray(new Integer[dp[j].size()]);
            Integer[] arr2 = dp[i-j].toArray(new Integer[dp[i-j].size()]);
            
            for(Integer num1 : arr1){
                for(Integer num2 : arr2){
                    // +
                    dp[i].add(num1+num2);

                    // -
                    dp[i].add(num1-num2);
                    dp[i].add(num2-num1);

                    // *
                    dp[i].add(num1*num2);

                    // /
                    if(num2!=0){
                        dp[i].add(num1/num2);
                    }
                    if(num1!=0){
                        dp[i].add(num2/num1);
                    }
                }
            }
        }
    }
}