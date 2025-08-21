import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>(s.length());
        for (char c : s.toCharArray()) {
            if(c=='('){
                dq.addFirst(c);
            }else{
                if(dq.isEmpty()) return false;
                dq.pop();
            }
        }

        return dq.isEmpty();
    }
}