import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class dayPay implements Comparable<dayPay>{
    int d,p;
    public dayPay(int p, int d){
        this.d=d; //deadline
        this.p=p; //pay
    }

    @Override
    public int compareTo(dayPay o) {
        if(this.d==o.d) return o.p-this.p; //남은 기한이 같을 경우 pay 기준 내림차순 정렬
        else return o.d-this.d; //남은 기한 기준 내림차순 정렬
    }
}
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        if(N==0){
            System.out.println(0);
            return;
        }
        PriorityQueue<dayPay> pq=new PriorityQueue<>();

        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            pq.offer(new dayPay(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }
        int answer=0, Day=pq.peek().d;

        PriorityQueue<Integer> score=new PriorityQueue<>(Collections.reverseOrder()); //점수 내림차순 정렬
        for(int i=Day; i>0; i--){
            while(!pq.isEmpty() && pq.peek().d>=i){
                score.offer(pq.poll().p);
            }
            if(!score.isEmpty())answer+=score.poll();
        }

        System.out.println(answer);
    }
}