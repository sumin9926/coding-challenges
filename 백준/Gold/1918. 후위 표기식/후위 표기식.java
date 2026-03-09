import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String infix=br.readLine();

        Deque<Character> dq=new ArrayDeque<>();
        StringBuilder answer=new StringBuilder();
        for(char x: infix.toCharArray()){
            if(x>='A' && x<='Z') answer.append(x); //x가 피연산자인 경우
            else{ //x가 연산자인경우
                if(x=='(') dq.push(x); //'('이후 연산자는 모두 덱에 push
                else if(x==')'){ //')'이전 연산자를 모두 append
                    while(!dq.isEmpty() && dq.peek()!='('){
                        answer.append(dq.pop());
                    }
                    dq.pop(); //'(' 제거
                }
                else{
                    while(!dq.isEmpty() && dq.peek()!='(' && priority(dq.peek())>=priority(x)){//덱 상단 연산자 우선순위 >= 연산자 x 우선순위일때
                        answer.append(dq.pop());
                    }
                    dq.push(x);
                }
            }
        }

        while (!dq.isEmpty()) answer.append(dq.pop());

        System.out.println(answer);
    }
    public static int priority(char op){
        if(op=='*' || op=='/') return 2;
        else return 1;
    }
}