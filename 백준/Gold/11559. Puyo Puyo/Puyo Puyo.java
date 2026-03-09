import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Point{
    public int r, c;
    Point(int r, int c){
        this.r=r;
        this.c=c;
    }
}

class Main{
    static boolean flag=true;
    static char[][] field;
    static int[][] ch;
    static int[] dr={-1,0,1,0}, dc={0,1,0,-1};
    static int answer=0;
    static char color;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        field=new char[12][6];

        for(int i=0; i<12; i++){
            String s=br.readLine();
            for(int j=0; j<6; j++){
                field[i][j]=s.charAt(j);
            }
        }

        ch=new int[12][6];
        while(flag){
            cntPuyo();
            if(flag) {
                arrangement();
                answer++;}
            else break;
        }
        System.out.println(answer);
    }

    public static void cntPuyo(){
        flag=false;
        for(int r=11; r>=0; r--) {
            int cntDote=0;
            for (int c = 0; c < 6; c++) {
                color=field[r][c];
                if(color=='.') {
                    cntDote++;
                    continue;
                }
                if(cntDote==6) return;

                Queue<Point> q = new LinkedList<>();
                Queue<Point> puyoPoint = new LinkedList<>();
                ch[r][c]=1;
                q.offer(new Point(r, c));
                puyoPoint.offer(new Point(r,c));
                int cnt = 1; //연속하는 뿌요의 수

                while (!q.isEmpty()) {
                    Point tmp = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = tmp.r + dr[i], nc = tmp.c + dc[i];
                        if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && field[nr][nc] == color && ch[nr][nc]==0) {
                            cnt++;
                            ch[nr][nc]=1;
                            q.offer(new Point(nr, nc));
                            puyoPoint.offer(new Point(nr, nc));
                        }
                    }
                }
                if (cnt >= 4) {
                    flag=true;
                    int size= puyoPoint.size();
                    for(int i=0; i<size; i++){
                        Point tmp=puyoPoint.poll();
                        field[tmp.r][tmp.c]='.';
                    }
                }
            }
        }
    }

    //빈 공간 없도록 재배치
    public static void arrangement(){
        for(int x=0; x<6; x++){
            Queue<Character> move=new LinkedList<>();//움직여야하는 뿌요 저장
            for(int r=11; r>=0; r--){
                if(field[r][x]!='.') {
                    move.offer(field[r][x]);
                    field[r][x]='.';
                }
            }
            int size=move.size();
            int row=11;
            for(int i=0; i<size; i++){
                field[row--][x]= move.poll();
            }
        }
        ch=new int[12][6];
    }
}