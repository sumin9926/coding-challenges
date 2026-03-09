import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static char a,b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        Stack<Character> stack=new Stack<>();
        stack.push(s.charAt(0));

        int answer=0;
        for(int j=1; j<s.length(); j++){
            b=s.charAt(j-1);
            a=s.charAt(j);
            if(a=='(') {
                stack.push(a);
                continue;
            }
            if(a==')'){
                stack.pop();
                if(b=='(')answer+=stack.size();
                if(b==')') answer+=1;
            }
        }
        System.out.println(answer);
    }
}