import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int minNum=Math.min(n,m); //n,m 중 더 작은 수
        int maxNum=Math.max(n,m); //n,m 중 더 큰 수
        
        //최대공약수 구하기
        while(true){
            if(minNum==0){
                answer[0]=maxNum;
                answer[1]=n*m/maxNum;
                break;
            }
            int tmp=maxNum%minNum;
            maxNum=minNum;
            minNum=tmp;
        }
        
        return answer;
    }
}