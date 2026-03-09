import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Lecture{
    int S,T;
    public Lecture(int S, int T){
        this.S=S;
        this.T=T;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Lecture> pq=new PriorityQueue<>(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o1.S-o2.S;
            }
        });

        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken()), t=Integer.parseInt(st.nextToken());
            pq.offer(new Lecture(s,t));
        }

        PriorityQueue<Integer> answer=new PriorityQueue<>();
        Lecture first=pq.poll();
        answer.offer(first.T);
        while (!pq.isEmpty()){
            Lecture tmp=pq.poll();
            if(tmp.S>=answer.peek()) {
                answer.poll();
            }
            answer.offer(tmp.T);
        }
        System.out.println(answer.size());
    }
}