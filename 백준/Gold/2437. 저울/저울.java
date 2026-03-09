import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        if(pq.peek()>1){
            System.out.println(1);
            return;
        }
        int sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
            if(!pq.isEmpty() && sum+1<pq.peek()){System.out.println(sum+1); return;}
        }
        System.out.println(sum+1);
    }
}