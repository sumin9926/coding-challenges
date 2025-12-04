import java.util.*;

class Solution {
    public int solution(int[][] matrixSizes) {
        int matrixNum = matrixSizes.length;
        int[][] dp = new int[matrixNum][matrixNum];
        
        for(int num = 2; num<=matrixNum; num++){ // 곱할 행렬의 개수
            for(int start=0; start<=matrixNum-num; start++){ //곱할 첫번째 행렬
                int end = start+num-1; // 곱할 마지막 행렬
                dp[start][end] = Integer.MAX_VALUE;
                
                for(int k=start; k<end; k++){ // 분할 지점
                    int cost = dp[start][k] + dp[k+1][end] + matrixSizes[start][0] * matrixSizes[k][1] * matrixSizes[end][1];
                    dp[start][end] = dp[start][end]>cost ? cost : dp[start][end];
                }
                
            }
        }
        
        return dp[0][matrixNum-1];
    }
}