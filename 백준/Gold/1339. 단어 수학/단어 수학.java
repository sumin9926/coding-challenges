import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class AlpaNum implements Comparable<AlpaNum>{
    char alpabet;
    int cnt;
    public AlpaNum(char alpabet, int cnt){
        this.alpabet=alpabet;
        this.cnt=cnt;
    }

    @Override
    public int compareTo(AlpaNum o) {
        return o.cnt-this.cnt;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        HashMap<Character, Integer> hm=new HashMap<>(36);

        for(int i=0; i<N; i++){
            String str=br.readLine();
            int size=str.length()-1, multiple=1;
            for(int j=size; j>=0; j--){
                hm.put(str.charAt(j), hm.getOrDefault(str.charAt(j),0)+multiple);
                multiple*=10;
            }
        }
        PriorityQueue<AlpaNum> pq=new PriorityQueue<>();
        for(Map.Entry<Character, Integer> entry:hm.entrySet()){
            pq.offer(new AlpaNum(entry.getKey(), entry.getValue()));
        }

        int num=9, answer=0;
        while(!pq.isEmpty()){
            AlpaNum tmp=pq.poll();
            answer+=tmp.cnt*num--;
        }

        System.out.println(answer);

    }
}
