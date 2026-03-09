import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Point{
    int r,c,d;
    public Point(int r, int c, int d){
        this.r=r;
        this.c=c;
        this.d=d;
    }
}

class Main {
    static int N,M;
    static int[][] map;
    static int[] dr={-1,0,1,0}, dc={0,1,0,-1};
    static Queue<Point> q=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        Point vacuum=(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))); //청소기 위치
        map=new int[N][M];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        Simulation(vacuum);
    }

    public static void Simulation(Point v){
        q.offer(v);
        int cnt=0; //청소한 구역 개수 카운트

        while(!q.isEmpty()){
            boolean moved=false; //주변 4칸 중 청소하지 못한 곳 카운트
            Point cl=q.poll(); //current location

            //1번 동작
            if(map[cl.r][cl.c]==0) {
                map[cl.r][cl.c]=-1; //청소한 구역 표시
                cnt++;
            }

            for(int i=0; i<4; i++){
                cl.d=(cl.d+3)%4; //반시계 방향으로 회전
                int nr=cl.r+dr[cl.d], nc=cl.c+dc[cl.d];
                if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]==0){ //3번 동작
                    q.offer(new Point(nr, nc, cl.d));
                    moved=true;
                    break;
                }
            }

            //2번 동작
            if(!moved){
                int nd=(cl.d+2)%4; //후진
                int nr=cl.r+dr[nd], nc=cl.c+dc[nd];
                if(nr>=0 && nr<N && nc>=0 && nc<M && map[nr][nc]!=1){
                    q.offer(new Point(nr, nc, cl.d));
                }else break;// 벽에 막힌 경우 작동 중지
            }
        }
        System.out.println(cnt);
    }
}