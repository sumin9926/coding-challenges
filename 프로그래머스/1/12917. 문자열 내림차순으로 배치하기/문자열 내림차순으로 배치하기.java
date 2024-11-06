import java.util.*;
import java.lang.StringBuilder;

class Solution {
    public String solution(String s) {
        
        char[] charArr= s.toCharArray();
        Arrays.sort(charArr);
        
        StringBuilder sb=new StringBuilder();
        for(char x: charArr){
            sb.append(Character.toString(x));
        }
        return sb.reverse().toString();
    }
}