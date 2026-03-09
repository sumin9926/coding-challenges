import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> positive=new PriorityQueue<>(Collections.reverseOrder()); //내림차순
        PriorityQueue<Integer> negativeNZero=new PriorityQueue<>(); //오름차순

        for(int i=0; i<N; i++){
            int num=Integer.parseInt(br.readLine());
            if(num>0) positive.offer(num);
            else negativeNZero.offer(num);
        }

        int answer=0;
        while(!positive.isEmpty()){
            if(positive.size()==1) answer+=positive.poll();
            else{
                int tmp= positive.poll();
                answer+=Math.max(tmp+positive.peek(),tmp*positive.peek());
                positive.poll();
            }
        }
        while(!negativeNZero.isEmpty()){
            if(negativeNZero.size()==1) answer+=negativeNZero.poll();
            else{
                int tmp=negativeNZero.poll();
                answer+=tmp*negativeNZero.peek();
                negativeNZero.poll();
            }
        }
        System.out.println(answer);

    }
}