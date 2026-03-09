import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int answer=0;
        while (pq.size()>1){
            int fir=pq.poll(), sec=pq.poll();
            answer+=fir+sec;
            pq.offer(fir+sec);
        }

        System.out.println(answer);
    }
}