import java.util.*;

class Solution {
    static int[] answer;
    static int indexAnswer=0;
    public int[] solution(int[] array, int[][] commands) {
        answer = new int[commands.length];
        
        for(int[] x: commands){
            SortNum(x[0], x[1], x[2], array);
        }
        
        return answer;
    }
    
    public void SortNum(int i, int j, int k, int[] array){
        int[] cut=new int[j-i+1];
        int index=0;
        for(;i<=j; i++){
            cut[index++]=array[i-1];
        }
        Arrays.sort(cut);
        answer[indexAnswer++]=cut[k-1];
    }
}