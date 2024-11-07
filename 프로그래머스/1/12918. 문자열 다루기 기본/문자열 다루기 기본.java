class Solution {
    public boolean solution(String s) {
        
        int slen=s.length();
        if(slen==4 || slen==6){
            for(char c: s.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
         }
        }else{
            return false;
        }
        
        return true;
    }
}