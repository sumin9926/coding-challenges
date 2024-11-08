import java.util.*;
class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int minNum=Math.min(n,m); //n,m 중 더 작은 수
        int maxNum=Math.max(n,m); //n,m 중 더 큰 수
        
        //최대공약수 구하기
        for(int i=1; i<=minNum; i++){
            if(n%i==0 && m%i==0){
                answer[0]=i;
            }
        }
        
        int cnt=2;
        int maxNumTimes=maxNum;
        //최소공배수 구하기
        while(true){
            if(maxNumTimes%minNum==0){
                answer[1]=maxNumTimes;
                break;
            }else{
             maxNumTimes=maxNum*cnt++;  
            }
        }
        
        return answer;
    }
}