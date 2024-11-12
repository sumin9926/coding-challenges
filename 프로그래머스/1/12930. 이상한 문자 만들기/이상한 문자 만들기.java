class Solution {
    public String solution(String s) {
        
        String[] arr=s.split("");
        String answer="";
        
        int index=0;
        for(String str: arr){
            index=(str.equals(" "))?0:index+1;
            answer+=(index%2!=0)?str.toUpperCase():str.toLowerCase();
        }
        
        return answer;
    }
}

