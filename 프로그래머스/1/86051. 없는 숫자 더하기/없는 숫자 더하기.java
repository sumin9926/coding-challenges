
class Solution {
    public int solution(int[] numbers) {
        int[] index=new int[10];
        for(int i:numbers){
            index[i]=-1;
        }
        
        int answer=0;
        for(int num=0; num<index.length; num++){
            if(index[num]==0) answer+=num;
        }
        return answer;
    }
}