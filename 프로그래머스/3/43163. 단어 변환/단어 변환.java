import java.util.*;

class Solution {
    public boolean matchWords(String str1, String str2){
        int unMatchCnt = 0;
        int[] cntChar = new int[98];
        
        for(int i=0; i<str1.length(); i++){
            cntChar[str1.charAt(i)-97]++;
        }
        
        for(int i=0; i<str2.length(); i++){
            cntChar[str2.charAt(i)-97]--;
        }
        
        for(int v : cntChar){
            unMatchCnt+=Math.abs(v);
            if(unMatchCnt>2) return false;
        }
        
        return true;
    }
    
    public int solution(String begin, String target, String[] words) {
        Map<String, ArrayList<String>> wordsGraph = new HashMap<>();
        Map<String, Integer> cntSteps = new HashMap<>(); //문자열별 최소 변환 단계 저장
        for(String str:words){
            cntSteps.put(str, -1);
        }
        cntSteps.put(begin, 0);
        
        // 상호 변환 가능 문자열 그래프 만들기
        for(int i=0; i<=words.length; i++){
            String str1 = null;
            if(i==words.length) str1 = begin;
            else str1 = words[i];
            for(int j=0; j<words.length; j++){
                if(j==i) continue;
                if(matchWords(str1, words[j])){
                    wordsGraph.computeIfAbsent(str1, k -> new ArrayList<>()).add(words[j]);
                }
            }
        }
        
        // BFS
        Deque<String> dq = new ArrayDeque<>();
        dq.offerLast(begin);
        
        while(!dq.isEmpty()){
            String currentString = dq.pollFirst();
            for(String nextString : wordsGraph.get(currentString)){
                if(nextString.equals(target)){
                    return 1+cntSteps.get(currentString);
                }
                Integer cnt = cntSteps.get(nextString);
                if(cnt!=-1) continue;
                cntSteps.put(nextString, 1+cntSteps.get(currentString));
                dq.offerLast(nextString);
            }
        }
        
        return 0;
    }
}