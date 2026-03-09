import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Deque<Long> dq = new ArrayDeque<>();
        for(int i=0; i<K; i++){
            long num = Long.parseLong(br.readLine());
            if(num!=0) dq.push(num);
            else dq.pop();
        }

        long total = 0L;
        while(!dq.isEmpty()){
            total+=dq.pop();
        }

        System.out.print(total);
    }
}
