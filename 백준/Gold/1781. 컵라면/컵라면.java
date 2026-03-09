import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class dDayNRamen implements Comparable<dDayNRamen>{
    int dD,rN;
    public dDayNRamen(int dD, int rN){
        this.dD=dD;
        this.rN=rN;
    }

    @Override
    public int compareTo(dDayNRamen o) {
        if(this.dD==o.dD) return o.rN-this.rN;
        else return o.dD-this.dD;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long ans=0;
        PriorityQueue<Integer> ramen=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<dDayNRamen> pq=new PriorityQueue<>();
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            pq.offer(new dDayNRamen(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        int longestDday=pq.peek().dD;

        for(int Dday=longestDday; Dday>=1; Dday--){
            if(!pq.isEmpty() && Dday==pq.peek().dD){
                dDayNRamen tmp=pq.poll();
                ramen.offer(tmp.rN);
                while(!pq.isEmpty() && pq.peek().dD==tmp.dD){
                    ramen.offer(pq.poll().rN);
                }
            }
            if(!ramen.isEmpty()) ans+= ramen.poll();
        }

        System.out.println(ans);
    }
}