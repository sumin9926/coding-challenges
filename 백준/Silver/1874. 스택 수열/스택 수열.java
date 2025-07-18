import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static Deque<Integer> dq=new ArrayDeque<>();
    static StringBuilder sb=new StringBuilder();
    static int j=2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());

        dq.push(1);
        sb.append('+').append('\n');

        for(int i=0; i<n; i++){
            int num=Integer.parseInt(br.readLine());
            if(!dq.isEmpty()&&num==dq.getFirst()){
                dq.pop();
                sb.append('-').append('\n');
            }
            else if(num<j){
                System.out.println("NO");
                return;
            }
            else progression(num);
        }
        System.out.println(sb);
    }

    public static void progression(int num){
        for(;j<=num; j++){
            if(dq.isEmpty() || dq.getFirst()<=num){
                dq.push(j);
                sb.append('+').append('\n');
            }
            if(dq.getFirst()==num){
                dq.pop();
                sb.append('-').append('\n');
            }
        }
    }
}