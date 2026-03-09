import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Point{
    int r,c,d,com;
    public Point(int r, int c, int d,int com){
        this.r=r;
        this.c=c;
        this.d=d;
        this.com=com;
    }
}

class Main{
    static int[] dr={0,0,0,1,-1}, dc={0,1,-1,0,0};
    static boolean[][][] ch;
    static int N,M;
    static int[][] map;
    static Point end;
    static Queue<Point> q=new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        map=new int[M+1][N+1];
        for(int i=1; i<=M; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        Point start=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
        q.offer(start);

        st=new StringTokenizer(br.readLine());
        end=new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);

        BFS();
    }

    public static void BFS(){
        ch=new boolean[M+1][N+1][5];

        while(!q.isEmpty()){

            Point tmp=q.poll();

            if(tmp.r==end.r && tmp.c==end.c && tmp.d==end.d){
                System.out.println(tmp.com);
                return;
            }

            //명령 1
            for(int k=1; k<=3; k++){ //일단 로봇이 바라보고있는 방향으로 가능한 만큼 이동시킴
                int nr=tmp.r+dr[tmp.d]*k, nc=tmp.c+dc[tmp.d]*k;
                if(nr>0 && nr<=M && nc>0 && nc<=N ){
                    if(map[nr][nc]==1) break; //벽에 도달했을 경우
                    if(!ch[nr][nc][tmp.d]&& map[nr][nc]==0){
                        ch[nr][nc][tmp.d]=true;//방문 표시
                        q.offer(new Point(nr,nc,tmp.d,tmp.com+1));
                    }
                }
                else break;//map 밖으로 나갔을 경우
            }

            //명령 2
            for(int i=1; i<=4; i++){
                if(tmp.d!=i&&!ch[tmp.r][tmp.c][i]) {
                    ch[tmp.r][tmp.c][i]=true;
                        if((tmp.d==4 && i==3)||(tmp.d==3 && i==4)||(tmp.d==2 && i==1)||(tmp.d==1 && i==2)){ //180도 회전
                            q.offer(new Point(tmp.r,tmp.c,i, tmp.com+2));
                        }
                        else q.offer(new Point(tmp.r,tmp.c,i, tmp.com+1)); //90도 회전

                }
            }
        }
    }
}