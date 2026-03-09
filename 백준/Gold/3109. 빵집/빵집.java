import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static char[][] map;
    static int[][] ch;
    static int[] dr={-1,0,1}; //순서: 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래
    static int R,C,ans;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); C=Integer.parseInt(st.nextToken());
        map=new char[R][C];
        ch=new int[R][C];
        for(int i=0; i<R; i++){
            String str= br.readLine();
            for(int j=0; j<C; j++){
                map[i][j]=str.charAt(j);
            }
        }

        for(int row=0; row<R; row++){
            flag=false;
            DFS(row,0);
        }
        System.out.println(ans);
    }

    public static void DFS(int r, int c){
        if(c==C-1) {
            ans++;
            flag=true;
            return;
        }
        for (int j : dr) {
            int nr = r + j, nc = c + 1;
            if (nr >= 0 && nr < R && nc < C && map[nr][nc] != 'x' && ch[nr][nc] == 0) {
                ch[nr][nc] = 1;
                DFS(nr, nc);
                if(flag) return;
            }
        }
    }
}