import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class WeightValue implements Comparable<WeightValue> {
    int M,V;
    public WeightValue(int M, int V){
        this.M=M; //무게
        this.V=V; //가격
    }

    @Override
    public int compareTo(WeightValue o) {
        if(this.M==o.M) return o.V-this.V; //가격 내림차순
        else return this.M-o.M; //무게 오름차순
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken()), K=Integer.parseInt(st.nextToken());
        PriorityQueue<WeightValue> jewel=new PriorityQueue<>(); //가장 가벼운 보석 순으로 정렬(무게가 같을 경우 가장 가치가 높은 보석이 먼저 옴).
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            int M=Integer.parseInt(st.nextToken()), V=Integer.parseInt(st.nextToken());
            jewel.offer(new WeightValue(M,V));
        }

        PriorityQueue<Integer> bag=new PriorityQueue<>();//가방 용량이 작은 것 부터 오름차순 정렬.
        for(int i=0; i<K; i++){
            bag.offer(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Integer> highestV=new PriorityQueue<>(Collections.reverseOrder()); //가격을 내림차순으로 정렬
        long ans=0;

        while(!bag.isEmpty()){
            int C=bag.poll();
            /*선택된 가방 용량보다 작은 무게를 가진 보석을 모두 우선순위 큐에 넣는다.
            이때 가장 높은 가격을 가진 보석이 우선순위를 갖는다.*/
            while(!jewel.isEmpty() && jewel.peek().M<=C){
                highestV.offer(jewel.poll().V);
            }

            if(!highestV.isEmpty()) ans+=highestV.poll();
        }

        System.out.println(ans);
    }
}