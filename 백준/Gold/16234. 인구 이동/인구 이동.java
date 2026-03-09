import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point{
    public int r,c;
    Point(int r, int c){
        this.r=r;
        this.c=c;
    }
}

public class Main {
    static int N,L,R;
    static int[][] arr,ch,arr_copy;
    static int[] dr={0,-1,0,1}, dc={-1,0,1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        arr=new int[N][N];

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int time=0;
        while(time<=2000){
            ch=new int[N][N];
            arr_copy=new int[N][N];
            for(int i=0; i<N; i++){
                System.arraycopy(arr[i],0,arr_copy[i],0,N);
            }

            int num=1, maxNation=1,cntNation=0;
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(ch[r][c]==0) cntNation=move(r,c,num++);
                    maxNation=Math.max(maxNation,cntNation);
                }
            }

            //종료 조건
            if(maxNation==1) break;
            for(int i=0; i<N; i++){
                System.arraycopy(arr_copy[i],0,arr[i],0,N);
            }
            time++;
        }
        System.out.println(time);
    }

    public static int move(int r, int c, int num){
        Queue<Point> q=new LinkedList<>();
        q.offer(new Point(r,c));
        ch[r][c]=num;
        int pop_sum=arr[r][c], nation=1;

        while(!q.isEmpty()){
            Point t=q.poll();
            for(int i=0; i<4; i++){
                int nr=t.r+dr[i], nc=t.c+dc[i];
                if(nr>=0 && nr<N && nc>=0 && nc<N && ch[nr][nc]==0){
                    int min=Math.abs(arr[t.r][t.c]-arr[nr][nc]);
                    if(min<=R && min>=L){
                        q.offer(new Point(nr,nc));
                        ch[nr][nc]=num;
                        pop_sum+=arr[nr][nc];
                        nation++;
                    }
                }
            }
        }

        if(nation>1) fillarr(pop_sum/nation,num);
        return nation;
    }

    public static void fillarr(int pop_avg, int num){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(ch[r][c]==num) arr_copy[r][c]=pop_avg;
            }
        }
    }
}