import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st=br.readLine();
        String explosion= br.readLine();

        Deque<Character> dq=new ArrayDeque<>();

        for(int i=0; i<st.length(); i++){
            dq.push(st.charAt(i));
            if(st.charAt(i)==explosion.charAt(explosion.length()-1)){
                int j=explosion.length()-1;
                while(!dq.isEmpty() && j>=0 && explosion.charAt(j)==dq.peek()){
                    dq.pop();
                    j--;
                }
                if(j>=0){
                    for(int k=j+1; k<=explosion.length()-1; k++){
                        dq.push(explosion.charAt(k));
                    }
                }
            }
        }

       int size=dq.size();
       if(size==0) {
            System.out.println("FRULA");
            return;
        }

        StringBuilder sb=new StringBuilder();

        for(int i=0; i<size; i++){
            sb.append(dq.pollLast());
        }
        System.out.println(sb);
    }
}