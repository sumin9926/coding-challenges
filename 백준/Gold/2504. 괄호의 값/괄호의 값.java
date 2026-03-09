import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static Deque<Character> dq=new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        int tmp=1, answer=0;

        for(int i=0; i<s.length(); i++){
            char x=s.charAt(i);
            switch (x){
                case '(': tmp*=2;
                    dq.push(x);
                    break;
                case '[': tmp*=3;
                    dq.push(x);
                    break;
                case ')': if(dq.isEmpty() || dq.peek()!='(') {System.out.println(0); return;}
                    if(s.charAt(i-1)=='(') answer+=tmp;
                    tmp/=2;
                    dq.pop();
                    break;
                case ']': if(dq.isEmpty() || dq.peek()!='[') {System.out.println(0); return;}
                    if(s.charAt(i-1)=='[') answer+=tmp;
                    tmp/=3;
                    dq.pop();
                    break;
            }
        }

        if(!dq.isEmpty())System.out.println(0);
        else System.out.println(answer);
    }
}