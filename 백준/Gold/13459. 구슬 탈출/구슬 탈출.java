import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Place{
    int Rx, Ry, Bx, By;
    Place(int Rx, int Ry, int Bx, int By){
        this.Rx=Rx;
        this.Ry=Ry;
        this.Bx=Bx;
        this.By=By;
    }
}

class Main {
    static char[][] board;
    static int[][][][] check;
    static int[] dx={-1,0,1,0}, dy={0,1,0,-1};
    static int success=0, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        int sRx=0,sRy=0,sBx=0,sBy=0;
        board=new char[N][M];
        check=new int[N][M][N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                board[i][j]=(char)br.read();
                if(board[i][j]=='R') {sRx=i; sRy=j;}
                if(board[i][j]=='B') {sBx=i; sBy=j;}
            }
            br.read();//개행문자 처리
        }
        br.close();

        check[sRx][sRy][sBx][sBy]=1;
        Queue<Place> Q=new LinkedList<>();
        Q.offer(new Place(sRx,sRy,sBx,sBy));
        int cnt=0;

        while(!Q.isEmpty()) {
            int cycle = Q.size();
            cnt++;
            if(cnt>10){
                System.out.print(0);
                System.exit(0);
            }
            for (int k = 0; k < cycle; k++) {
                Place tmp=Q.poll();
                for(int i=0; i<4; i++){
                    Place moveResult=move(i, tmp);
                    if(success==-1) continue;
                    else if(success==1){
                        System.out.print(1);
                        System.exit(0);
                    }

                    if(check[moveResult.Rx][moveResult.Ry][moveResult.Bx][moveResult.By]==0){
                        check[moveResult.Rx][moveResult.Ry][moveResult.Bx][moveResult.By]=1;
                        Q.offer(new Place(moveResult.Rx, moveResult.Ry, moveResult.Bx, moveResult.By));
                    }
                }
            }

        }
        System.out.print(0);
    }

    public static Place move(int i, Place tmp){
        success=0; //초기화, 아무 구슬도 구멍에 빠지지 않음
        int Rnx=tmp.Rx+dx[i], Rny=tmp.Ry+dy[i], Rdist=0;
        int Bnx=tmp.Bx+dx[i], Bny=tmp.By+dy[i], Bdist=0;
        while(board[Rnx][Rny]!='#'){ //구슬R을 i방향으로 이동
            if(board[Rnx][Rny]=='O') success=1; //빨간 구슬이 구멍에 들어감
            Rnx+=dx[i];
            Rny+=dy[i];
            Rdist++;
        }
        while(board[Bnx][Bny]!='#'){ //구슬B를 i방향으로 이동
            if(board[Bnx][Bny]=='O') success=-1; //파란구슬이 구멍에 빠짐
            Bnx+=dx[i];
            Bny+=dy[i];
            Bdist++;
        }
        if(Rnx-dx[i]==Bnx-dx[i]&&Rny-dy[i]==Bny-dy[i]){
            if(Rdist>Bdist) return new Place(Rnx-(dx[i]*2), Rny-(dy[i]*2), Bnx-dx[i], Bny-dy[i]);//B구슬이 앞에 있음
            else return new Place(Rnx-dx[i], Rny-dy[i], Bnx-(dx[i]*2), Bny-(dy[i]*2));
        }
        return new Place(Rnx-dx[i], Rny-dy[i], Bnx-dx[i], Bny-dy[i]);
    }
}