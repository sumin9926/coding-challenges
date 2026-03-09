import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {
    static int[][] ladder;
    static int N,H;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());
        if(M==0){ //추가된 가로선이 0개일 경우 바로 종료
            System.out.println(0);
            return;
        }
        ladder=new int[H+1][N+1];
        for(int i=0; i<M; i++){ //배열에 가로 선 추가
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            ladder[a][b]=1;
            ladder[a][b+1]=-1;
        }
        //가로선 추가해보기
        for(int i=0; i<=3;i++) {
            DFS(0, i, 1); //L은 추가된 가로선의 개수
            if(flag) {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }

    public static void DFS(int L, int i, int sx){
       if(flag) return;
       if(L==i) {
           if(check()) flag=true;
           return;
       }
       for (int ny = 1; ny < N; ny++) {
          for (int nx = sx; nx <= H; nx++) {
              if (isPossible(ny, nx)) { //새로운 가로선 추가 가능
                  ladder[nx][ny] = 1; //왼
                  ladder[nx][ny + 1] = -1; //오
                  DFS(L + 1, i, nx);
                  ladder[nx][ny] = 0; //왼
                  ladder[nx][ny + 1] = 0; //오
              }
          }
       }
    }

    //각 i번 선의 결과가 조건에 부합하는지 검사하는 메서드
    public static boolean check(){
        for(int n=1; n<=N; n++){
            int state=n;
            for(int h=1; h<=H; h++) if(ladder[h][state]!=0) state+=ladder[h][state]; //왼쪽으로 가거나 오른쪽으로 가거나
            if(state!=n){
                return false;
            }
        }
        return true;
    }

    //간선을 놓을 수 있는 자리인지 확인하는 메서드
    public static boolean isPossible(int y, int x){
        return ladder[x][y] == 0 && ladder[x][y + 1] == 0;
    }
}