import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Digit{
    int number;
    int level;
    int x,y;
    Digit(int number, int level, int x, int y){
        this.number=number;
        this.level=level;
        this.x=x;
        this.y=y;
    }
}

class Main{
    static int[] dx={1,0,-1,0}, dy={0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[][] board=new int[5][5];

        for(int i=0; i<5; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[] check=new int[1_000_000];
        int answer=0;
        Queue<Digit> q=new LinkedList<>();

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                q.offer(new Digit(board[i][j], 1, i, j));

                while(!q.isEmpty()){
                    int size=q.size();
                    for(int l=0; l<size; l++) {
                        Digit tmp = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = tmp.x + dx[k];
                            int ny = tmp.y + dy[k];

                            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                                int num = tmp.number * 10 + board[nx][ny];
                                int lev = tmp.level+1;
                                if (lev == 6 && check[num] == 0) {
                                    answer++;
                                    check[num] = 1;
                                }
                                if (lev < 6) q.offer(new Digit(num, lev, nx, ny));
                            }
                        }
                    }
                }

            }
        }
        System.out.print(answer);
    }
}