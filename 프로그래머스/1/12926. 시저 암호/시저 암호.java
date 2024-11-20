import java.util.*;
class Solution {
    public String solution(String s, int n) {
        int i=0;
        char[] charArr=new char[s.length()];
        //대문자 65~90, 소문자 97~122
        for(char x: s.toCharArray()){
            int sum=(int)x+n;
            if(x==' '){
                charArr[i++]=' ';
            }
            else if(Character.isUpperCase(x)){
                charArr[i++]=(sum>90) ? (char)(sum-26) : (char)sum;
            }else{
                charArr[i++]=(sum>122) ? (char)(sum-26) : (char)sum;
            }
        }
        return String.valueOf(charArr);
    }
}