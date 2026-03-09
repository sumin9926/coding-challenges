import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int[] pos=new int[100001];
    static int K, answer=0, cnt, flag=0;
    static Queue<Integer> q=new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken()); //수빈
        K=Integer.parseInt(st.nextToken()); //동생
        if(N==K){
            System.out.println(0);
            System.out.println(1);
            System.exit(0);
        }

        pos[N]=0;

        q.offer(N);

        while(!q.isEmpty() && flag==0){
            int size=q.size();
            answer++;
            for(int i=0; i<size; i++){
                int x=q.poll();

                int forward=x+1;
                int back=x-1;
                int teleport=x*2;

                calcu(forward);
                calcu(back);
                if(teleport<=K+1) calcu(teleport);
            }
        }
        System.out.println(cnt);
    }

    public static void calcu(int nx){
        if(nx>=0 && nx<100001 && (pos[nx]==answer || pos[nx]==0)){
            pos[nx]=answer;
            if(nx==K && flag==0){
                System.out.println(answer);
                cnt++;
                flag=1;
            }
            else if(nx==K && flag==1) {
                cnt++;
            }
            else q.offer(nx);
        }
    }
}