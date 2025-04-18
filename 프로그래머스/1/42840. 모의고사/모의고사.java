import java.util.*;
class Solution {
    public ArrayList<Integer> solution(int[] answers) {
        int[] score = new int[3];
        int[] first={1,2,3,4,5};
        int[] sec={2,1,2,3,2,4,2,5};
        int[] third={3,3,1,1,2,2,4,4,5,5};
        int max=0;
        ArrayList<Integer> answer=new ArrayList<>();
        
        for(int i=0; i<answers.length; i++){
            if(answers[i]==first[i%5]) score[0]++;
            if(answers[i]==sec[i%8]) score[1]++;
            if(answers[i]==third[i%10]) score[2]++;
        }
        for(int i=0; i<3; i++){
            max=Math.max(score[i],max);
        }
        for(int i=0; i<3; i++){
            if(max==score[i]) answer.add(i+1);
        }
        return answer;
    }
}
