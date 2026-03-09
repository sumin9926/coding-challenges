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
    static boolean[] ch; //활성화된 바이러스의 초기 위치
    static ArrayList<Point> virus, wall;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken()); //바이러스 수

        lab=new int[N][N];
        virus=new ArrayList<>(); //바이러스를 놓을 수 있는 위치
        wall=new ArrayList<>();//벽의 위치

        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                lab[i][j]=Integer.parseInt(st.nextToken());
                if(lab[i][j]==2) virus.add(new Point(i,j,0));  // 바이러스를 둘 수 있는 위치 저장
                if(lab[i][j]==0) empty_space++;
            }
        }

        if(empty_space==0) { //빈칸이 없는 경우 바이러스 활성화 시간은 0
            System.out.println(0);
            return;
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
            if(!ch[i]){
                ch[i]=true;
                DFS(mNum + 1, i+1);
                ch[i]=false;
            }
        }
    }

    public static void BFS(){
        int[][] lab_copy=new int[N][N];
        Queue<Point> q=new LinkedList<>();

        int empty_space_copy=empty_space;

        for(int i=0; i<N; i++){
            System.arraycopy(lab[i], 0, lab_copy[i],0,N);
        }

        for(int i=0; i<virus.size(); i++){
            if(ch[i]){
                Point tmp=virus.get(i);
                q.offer(new Point(tmp.x,tmp.y,0));
                lab_copy[tmp.x][tmp.y]=-1;
            }
        }

        int t=0; //시간

        while(!q.isEmpty()){
            if (empty_space_copy == 0) {
                answer = Math.min(answer, t);
                return;
            }
            t++;
            int size=q.size();
            for(int l=0; l<size; l++) {
                Point tmp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = tmp.x + dx[i], ny = tmp.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if (lab_copy[nx][ny] == 0) { //빈 칸인 경우
                            lab_copy[nx][ny] = -1;
                            empty_space_copy--;
                            q.offer(new Point(nx, ny, tmp.time + 1));
                        } else if (lab_copy[nx][ny] == 2) { //비활성 바이러스의 활성화
                            lab_copy[nx][ny] = -1;
                            q.offer(new Point(nx, ny, tmp.time + 1));
                        }
                    }
                }
            }
        }
    }
}