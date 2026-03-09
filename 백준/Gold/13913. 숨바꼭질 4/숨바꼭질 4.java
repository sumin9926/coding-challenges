import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int[] pos=new int[100001];
    static ArrayList<Integer> route=new ArrayList<>();
    static int K, N, answer=0;
    static boolean flag=true;
    static Queue<Integer> q=new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken()); //수빈
        K=Integer.parseInt(st.nextToken()); //동생
        if(N==K){
            System.out.println(0);
            System.out.println(N);
            return;
        }

        for(int i=0; i<100_001; i++){
            pos[i]=i;
        }
        pos[N]=-1;
        q.offer(N);

        while(!q.isEmpty() && flag){
            int size=q.size();
            answer++;
            for(int i=0; i<size; i++){
                if(flag) {
                    int x = q.poll();

                    int forward = x + 1;
                    int back = x - 1;
                    int teleport = x * 2;

                    calcu(forward, x);
                    calcu(back, x);
                    if (teleport <= K + 1) calcu(teleport, x);
                }
            }
        }

    }

    public static void calcu(int nx, int x){
        if(nx>=0 && nx<100001 && pos[nx]==nx && flag){
            pos[nx]=x; //nx의 근원을 저장
            if(nx==K) {
                    System.out.println(answer);
                    Find(K);
                    Collections.reverse(route);
                    for(int n: route){
                        System.out.print(n+" ");
                    }
                    flag=false;
            }
            else q.offer(nx);
        }
    }

    public static void Find(int v){
        if(pos[v]==-1) {
            route.add(v);
            return;
        }
        if(pos[v]!=v){
            route.add(v);
            Find(pos[v]);
        }
    }
}