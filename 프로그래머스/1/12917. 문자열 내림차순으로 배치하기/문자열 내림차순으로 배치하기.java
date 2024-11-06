 
 	
import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] charArray = s.toCharArray();
        
        Arrays.sort(charArray);
        
        for(int i = charArray.length-1;i>=0;i--){
            answer += String.valueOf(charArray[i]);
        }
        return answer;
    }
}