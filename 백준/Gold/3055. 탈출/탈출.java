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
    static int R,C,answer;
    static int[] dx={1,0,-1,0}, dy={0,1,0,-1};
    static int[][] map;
    static boolean flag;
    static Queue<Point> water=new LinkedList<>();
    static Queue<Point> animal=new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        map=new int[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                char c=(char)br.read();
                if(c=='.')map[i][j]=0; //빈공간
                else if(c=='X')map[i][j]=-1; //바위
                else if(c=='*'){ //물
                    map[i][j]=-1;
                    water.offer(new Point(i,j));
                }
                else if(c=='S'){//고슴도치
                    map[i][j]=1;
                    animal.offer(new Point(i,j));
                }
                else map[i][j]=3; //도착지
            }
            br.read();
        }

        BFS();
        if(flag) System.out.println(answer);
        else System.out.println("KAKTUS");
    }

    public static void BFS(){

        while(!animal.isEmpty()){
            answer++;
            int wSize= water.size(),aSize=animal.size();

            for(int i=0; i<wSize; i++){
                Point wp=water.poll();
                for(int j=0; j<4; j++){
                    int w_nx= wp.x+dx[j], w_ny= wp.y+dy[j];
                    if(w_nx>=0 && w_nx<R && w_ny>=0 && w_ny<C){
                        if(map[w_nx][w_ny]==0 ||map[w_nx][w_ny]==1){
                            map[w_nx][w_ny]=-1;
                            water.offer(new Point(w_nx,w_ny));
                        }
                    }
                }
            }

            for(int i=0; i<aSize; i++){
                Point ap=animal.poll();
                for(int j=0; j<4; j++){
                    int a_nx=ap.x+dx[j], a_ny=ap.y+dy[j];
                    if(a_nx>=0 && a_nx<R && a_ny>=0 && a_ny<C){
                        if(map[a_nx][a_ny]==0){
                        map[a_nx][a_ny]=1;
                        animal.offer(new Point(a_nx,a_ny));}
                        if(map[a_nx][a_ny]==3){
                            flag=true;
                            return;
                        }
                    }
                }
            }
        }
    }
}