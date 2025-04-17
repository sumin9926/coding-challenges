import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = 0;
        long start = 0;
        long end = 4L * 1_000_000_000_000_00L;;
        
        while(start<=end){
            long mid = (start+end)/2;
            if(check(mid, a, b, g, s, w, t)){
                answer=mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return answer;
    }
    
    public boolean check(long mid, int a, int b, int[] g, int[] s, int[] w, int[] t){
        long totalA = 0;
        long totalB = 0;
        long totalWeight = 0;
        
        for(int i=0; i<g.length; i++) {
            long cntArrival = mid/(2L*t[i]); //목적지 도착 횟수
            if(mid%(2L*t[i])>=t[i]){
                cntArrival += 1;
            }
            long maxWeight = cntArrival*w[i];
            totalA += Math.min(g[i], maxWeight);
            totalB += Math.min(s[i], maxWeight);
            totalWeight += Math.min(g[i]+s[i], maxWeight);
            if(totalA>=a && totalB>=b && totalWeight>=(a+b)){
            return true;
            }
        }
        
        if(totalA<a) { return false; }
        if(totalB<b) { return false; }
        if(totalWeight<(a+b)) { return false; }
            
        return true;
        
    }
}







