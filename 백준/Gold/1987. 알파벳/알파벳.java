import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static ArrayList<Character> visited=new ArrayList<>();
    static char[][] board;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,-1,0,1};
    static int R,C; //R=세로(행 개수) //C=가로(열 개수)
    static int answer; //최대로 지나간 칸 수

    public static void DFS(int x, int y){
        answer=Math.max(answer,visited.size()); //지나간 칸 수 저장
        //인접한 4칸의 알파벳 확인
        for(int i=0; i<dx.length; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            //지나간적 없는 알파벳일 경우 새롭게 추가
            if(nx>=0 && nx<R && ny>=0 && ny<C && !visited.contains(board[nx][ny])){
                visited.add(board[nx][ny]);
                DFS(nx,ny);
                visited.remove(visited.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());
    R=Integer.parseInt(st.nextToken()); //세로(행 개수)
    C=Integer.parseInt(st.nextToken()); //가로(열 개수)
    board=new char[R][C];
    for(int i=0; i<R; i++){
        for(int j=0; j<C; j++){
            board[i][j]=(char)br.read(); //보드에 알파벳 입력
        }
        br.read(); //개행문자 처리
    }
    visited.add(board[0][0]); //시작 위치 알파벳 추가
    DFS(0,0);
    System.out.println(answer);
    }
}