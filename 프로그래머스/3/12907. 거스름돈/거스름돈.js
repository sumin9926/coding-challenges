function solution(n, money) {
    const MOD = 1_000_000_007;
    let dp = Array(n+1).fill(0);
    dp[0]=1;
    
    for(let i=0; i<money.length; i++){
        let coin = money[i];
        for(let j=coin; j<dp.length; j++){
            dp[j]=(dp[j]+dp[j-coin])%MOD;
        }
    }
    
    
    
    return dp[n];
}