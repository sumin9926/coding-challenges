import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Point{
    int x,y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Main{
        static int N,M,safe_area=-3,answer=Integer.MIN_VALUE;
        static Queue<Point> q=new LinkedList<>();
        static int[][] lab;
        static int[] dx={1,0,-1,0}, dy={0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        lab=new int[N][M];

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                lab[i][j]=Integer.parseInt(st.nextToken());
                if(lab[i][j]==0) safe_area++;
                else if(lab[i][j]==2){
                    q.offer(new Point(i,j));
                }
            }
        }

        DFS(0); //울타리 세우기

        System.out.print(answer);
    }

    public static void DFS(int wall){
        if(wall==3){ //울타리 3개 세우기 완료
            BFS(); //세균 증식
        }
        else{
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++) {
                    if (lab[i][j] == 0) {
                        lab[i][j] = 1;
                        DFS(wall+1);
                        lab[i][j]=0;
                    }
                }
            }
        }
    }

    public static void BFS(){
        Queue<Point> q_copy=new LinkedList<>(q);
        int[][] lab_copy=new int[N][M];
        int virus=0;
        for(int i=0; i<N; i++){
            System.arraycopy(lab[i],0, lab_copy[i],0,M);
        }

        while (!q_copy.isEmpty()){
            Point tmp=q_copy.poll();
            for(int i=0; i<4; i++){
                int nx=tmp.x+dx[i], ny= tmp.y+dy[i];
                if(nx>=0 && nx<N && ny>=0 && ny<M && lab_copy[nx][ny]==0){
                    lab_copy[nx][ny]=2;
                    virus++;
                    q_copy.offer(new Point(nx,ny));
                }
            }
        }

        answer=Math.max(answer,safe_area-virus);
    }
}