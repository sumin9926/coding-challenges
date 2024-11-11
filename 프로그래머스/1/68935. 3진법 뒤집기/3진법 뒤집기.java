import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
    
        List<Integer> list=new LinkedList<>();
        int quotient=n; //몫
        int remainder=quotient%3; //나머지
        
        //3진법 반전시켜 저장
        while(quotient>=3){
            remainder=quotient%3;
            list.add(remainder);
            quotient=quotient/3;
        }
        list.add(quotient);
        
        //10진법으로 변환
        int cnt=list.size();
        int j=0;
        for(int i=cnt-1; i>-1; i--){
            answer+=list.get(i)*Math.pow(3,j++);
        }
        
        return answer;
    }
}