import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Point{
    int x,y, time;
    public Point(int x, int y,int time){
        this.x=x;
        this.y=y;
        this.time=time;
    }
}

class Main{
    static int N,M,empty_space,answer=Integer.MAX_VALUE;
    static int[][] lab;
    static int[] dx={1,0,-1,0}, dy={0,1,0,-1};
    static boolean[] ch;
    static ArrayList<Point> virus;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken()); //바이러스 수

        lab=new int[N][N];
        virus=new ArrayList<>(); //바이러스를 놓을 수 있는 위치
        empty_space-=M;

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                lab[i][j]=Integer.parseInt(st.nextToken());
                if(lab[i][j]==2) virus.add(new Point(i,j,0)); // 바이러스를 둘 수 있는 위치 저장
                if(lab[i][j]!=1) empty_space++;
            }
        }
        ch=new boolean[virus.size()];
        DFS(0,0);

        if (answer==Integer.MAX_VALUE) answer=-1;
        System.out.println(answer);

    }

    public static void DFS(int mNum, int s){ //바이러스 시작 위치 선정
        if(mNum==M){
            BFS(); // 바이러스가 퍼지는 시간
            return;
        }
        for(int i=s; i< virus.size(); i++){ //ArrayList index를 활용한 조합
            Point tmp=virus.get(i);
            if(lab[tmp.x][tmp.y] != -1){
                lab[tmp.x][tmp.y] = -1; //바이러스를 놓은 위치를 -1로 표시
                ch[i]=true;
                DFS(mNum + 1, i+1);
                lab[tmp.x][tmp.y] = 2;
                ch[i]=false;
            }
        }
    }
    
    public static void BFS(){
        int[][] lab_copy=new int[N][N];
        Queue<Point> q=new LinkedList<>();

        for(int i=0; i<virus.size(); i++){ //q에 바이러스가 있는 위치 넣기
            if(ch[i]){
                Point tmp=virus.get(i);
                q.offer(new Point(tmp.x,tmp.y,0));
            }
        }

        int empty_space_copy=empty_space;

        for(int i=0; i<N; i++){//배열 복사(원본 유지 목적)
            System.arraycopy(lab[i], 0, lab_copy[i],0,N);
        }
        
        int t=0; //시간

        while(!q.isEmpty()){
            Point tmp = q.poll();
            t=Math.max(tmp.time,t);
                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (lab_copy[nx][ny] == 0 || lab_copy[nx][ny] == 2) {
                            lab_copy[nx][ny] = -1;
                            empty_space_copy--;
                            q.offer(new Point(nx, ny, tmp.time+1));
                        }
                    }
                }

        }

        if(empty_space_copy==0) answer=Math.min(answer,t);
    }
}