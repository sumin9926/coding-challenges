import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0, len=sizes.length;
        int longs=0,shorts=0;
        for(int i=0; i<len; i++){
            if(sizes[i][0]>sizes[i][1]){
                longs=Math.max(sizes[i][0],longs);
                shorts=Math.max(shorts,sizes[i][1]);
            }else{
                longs=Math.max(longs,sizes[i][1]);
                shorts=Math.max(shorts,sizes[i][0]);
            }
        }
        
        answer=longs*shorts;
        return answer;
    }
}