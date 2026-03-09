import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int m,answer,sum,mindif=Integer.MAX_VALUE;
    static int[] card;

    public static void DFS(int L, int s){//
        if(L==3){
            if(sum<=m && Math.abs(sum-m)<mindif){
                mindif=Math.abs(sum-m);
                answer=sum;
            }
            return;
        }
        else{
            for(int i=s; i< card.length; i++){
                sum+=card[i];
                DFS(L+1,i+1);
                sum-=card[i];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        card=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            card[i]=Integer.parseInt(st.nextToken());
        }
        DFS(0,0);
        System.out.println(answer);
    }
}