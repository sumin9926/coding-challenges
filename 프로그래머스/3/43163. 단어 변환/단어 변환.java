import java.util.*;

class Solution {
    static class Word{
        String str;
        int step;
        
        Word(String str, int step){
            this.str=str;
            this.step=step;
        }
    }
    
    public boolean matchWords(String str1, String str2){
        int unMatch=0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                unMatch++;
                if(unMatch>=2) return false;
            }
        }
        return true;
    }
    
    public int solution(String begin, String target, String[] words) {
        int totalWords = words.length;
        boolean[] isVisited = new boolean[totalWords];
        
        Deque<Word> dq = new ArrayDeque<>();
        dq.offerLast(new Word(begin, 0));
        
        while(!dq.isEmpty()){
            Word currentWord = dq.pollFirst();
            if(currentWord.str.equals(target)){
                return currentWord.step;
            }
            for(int i=0; i<totalWords; i++){
                if(isVisited[i]) continue;
                String nextWord = words[i];
                if(matchWords(currentWord.str, nextWord)){
                    isVisited[i]=true;
                    dq.offerLast(new Word(nextWord, currentWord.step+1));
                }
            }
        }
        
        return 0;
    }
}