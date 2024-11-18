import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0, len=sizes.length;
        int[] longs=new int[len];
        int[] shorts=new int[len];
        for(int i=0; i<len; i++){
            if(sizes[i][0]>sizes[i][1]){
                longs[i]=sizes[i][0];
                shorts[i]=sizes[i][1];
            }else{
                longs[i]=sizes[i][1];
                shorts[i]=sizes[i][0];
            }
        }
        Arrays.sort(longs);
        Arrays.sort(shorts);
        
        answer=longs[len-1]*shorts[len-1];
        return answer;
    }
}