class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        // (a쌍)b쌍 형식, a,b는 0개일 수도 있다. 카탈란수.
        for(int i=2; i<=n; i++){ // i=괄호 쌍
            int total = i-1; // 고정한 한 쌍의 괄호 제외 나머지 괄호 개수
            for(int a=0; a<=total; a++){
                int b = total-a;
                dp[i] += dp[a]*dp[b]; 
            }
        }
        
        return dp[n];
    }
}