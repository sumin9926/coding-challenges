import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0, n=citations.length;
        Arrays.sort(citations);
        
        for(int i=0; i<n; i++){
            int h = Math.min(citations[i], n-i);
            answer = answer < h ? h : answer;
        }
        
        return answer;
    }
}