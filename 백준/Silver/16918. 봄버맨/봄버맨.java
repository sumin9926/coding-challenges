import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Bombs{
    public char bomb;
    public int timer;
    Bombs(char bomb, int timer){
        this.bomb=bomb;
        this.timer=timer;
    }
}

class Main{
    static int R,C,N;
    static Bombs[][] map;
    static int[] dr={-1,0,1,0}, dc={0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        map=new Bombs[R][C];
        for(int r=0; r<R; r++){
            String s=br.readLine();
            for(int c=0; c<C; c++){
                char a=s.charAt(c);
                if(a=='O') map[r][c]=new Bombs(a,1);
                else map[r][c]=new Bombs(a, -1);
            }
        }

        for(int n=2; n<=N; n++){
            if(n%2==0) setBomb();
            else explosion();
        }

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                System.out.print(map[r][c].bomb);
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void setBomb(){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                Bombs b=map[r][c];
                if(b.bomb=='.') map[r][c]=new Bombs('O',0);
                else map[r][c].timer+=1;
            }
        }
    }
    public static void explosion(){

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                Bombs b=map[r][c];
                if(b.timer==2) {
                    map[r][c]=new Bombs('.', -1);
                    for (int dir = 0; dir < 4; dir++) {
                        int nr = r + dr[dir], nc = c + dc[dir];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc].timer!=2) {
                            map[nr][nc] = new Bombs('.', -1);
                        }
                    }
                }
                else if(b.bomb=='O' && b.timer<2) map[r][c]=new Bombs('O', b.timer+1);
            }
        }
    }
}