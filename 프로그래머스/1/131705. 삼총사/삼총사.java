class Solution {
    static int answer = 0,len,cnt=0;
    static int[] numarr;
    
    public int solution(int[] number) {
        
        numarr=number;
        len=number.length;
        DFS(0,0);
       
        
        return answer;
    }
    
    public static void DFS(int num, int nextIndex){
        if(num==3){
            if(cnt==0) answer++;
        }else{
            for(int i=nextIndex; i<len; i++){
                cnt+=numarr[i];
                DFS(num+1, i+1);
                cnt-=numarr[i];
            }
        }
    }
}
