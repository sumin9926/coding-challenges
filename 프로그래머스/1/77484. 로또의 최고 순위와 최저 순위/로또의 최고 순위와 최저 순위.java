import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int cnt_win=0, cnt_zero=0;
        int[] rank={6,6,5,4,3,2,1};//일치한 번호 개수를 index로 활용
        Set<Integer> win_set=new HashSet<>();
        
        for(int win_num: win_nums){ //WINNUMS를 SET에 저장
            win_set.add(win_num);
        }
        
        for(int num:lottos){
            if(win_set.contains(num)) cnt_win++; //WINNUMS랑 맞는 수 CNT(->최저 등수)
            if(num==0) cnt_zero++;
        }
        
        answer[0]=rank[cnt_win+cnt_zero];
        answer[1]=rank[cnt_win];
        
        return answer;
    }
}