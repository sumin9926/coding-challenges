import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Pair{
    int num, pair;
    public Pair(int num, int pair){
        this.num=num;
        this.pair=pair;
    }
}

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        long answer=0;
        Deque<Pair> dq=new ArrayDeque<>();
        for(int i=0; i<N; i++){
            Pair p=new Pair(Integer.parseInt(br.readLine()),0);
            
            while(!dq.isEmpty() && dq.peek().num<=p.num){
                if(dq.peek().num==p.num){
                    p.pair+=dq.pop().pair+1;
                    answer+=p.pair;
                }
                else answer+=dq.pop().pair+1;
            }

            if(!dq.isEmpty() && dq.peek().num>p.num){
                answer++;
            }
            dq.push(p);
        }

        System.out.println(answer);
    }
}