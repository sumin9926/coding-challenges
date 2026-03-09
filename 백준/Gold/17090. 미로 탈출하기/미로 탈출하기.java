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
    static int N,M,answer;
    static int[] dx={1,0,-1,0}, dy={0,1,0,-1};
    static ArrayList<Point> chWay=new ArrayList<>(); //지나간 루트를 저장
    static int[][] ch; //지나간 길은 1표시(중복 방지), 탈출가능 구역은 2로 표시
    static char[][] map; //문자가 적힌 미로
    static boolean flag;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new char[N][M];
        ch=new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j]=(char)br.read();
            }
            br.read();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                chWay.clear(); //초기화
                flag=false; //초기화
                if(ch[i][j]!=2) DFS(i,j);
            }
        }

        System.out.println(answer);
    }

        //명령어에 따라 맵 탐색
        public static void DFS(int x, int y){
            if(flag) return;
            if(ch[x][y]==0){ //지나간적 없는 길일 경우
                ch[x][y]=1; //지나간 길은 1로 표시(무한루프 방지)
                chWay.add(new Point(x,y)); //지나간 경로 저장
            }
            else if(ch[x][y]==1){ //이미 지나왔던 길인경우(=무한루프 탈출 불가)
                for (Point tmp : chWay) { //그동안 지나온 길 0으로 초기화
                    ch[tmp.x][tmp.y] = 0;
                }
                flag=true;
                return;
            }
            else{ //ch[x][y]==2인 경우. 탈출 가능. 더 탐색할 필요 없음.
                answer+=chWay.size();
                for (Point tmp : chWay) { //그동안 지나온 길 2로 변경
                    ch[tmp.x][tmp.y] = 2;
                }
                flag=true;
                return;
            }

            int nx=x,ny=y;
            switch(map[x][y]){
                case 'U': nx-=1;
                          break;
                case 'R': ny+=1;
                          break;
                case 'D': nx+=1;
                          break;
                case 'L': ny-=1;
                          break;
            }

            if(nx>=0 && nx<N && ny>=0 && ny<M){
                DFS(nx,ny);
            }
            else{ //다음으로 이동해야하는 구역이 경계 밖임(=탈출성공)
                answer+=chWay.size();
                for (Point tmp : chWay) { //그동안 지나온 길 2로 변경
                    ch[tmp.x][tmp.y] = 2;
                }
                flag=true;
            }
        }

}