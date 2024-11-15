
class Solution {
    public int solution(String t, String p) {
        int answer=0;
        Long pNum=Long.parseLong(p);
        int len=p.length();
        
        for(int i=0; i<=t.length()-p.length(); i++){
            String str=t.substring(i, i+len);
            if(Long.parseLong(str)<=pNum) answer++;
        }
        
        return answer;
    }
}