import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Coordinate{
    int z,x,y;
    Coordinate(int z, int x, int y){
        this.z=z;
        this.x=x;
        this.y=y;
    }
}

class Main{
    static int L,R,C;
    static char[][][] building;
    static int[][][] minutes;
    static int[] dx={0,1,0,-1}, dy={1,0,-1,0}, dz={1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

       while(true) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           L = Integer.parseInt(st.nextToken()); //층수(면)
           R = Integer.parseInt(st.nextToken()); //행
           C = Integer.parseInt(st.nextToken()); //열

           if (L == 0 && R == 0 && C == 0) System.exit(0); //종료 조건

           building = new char[L][R][C];
           minutes=new int[L][R][C];
           int sy = 0,sx=0, sz=0, ez=0, ex=0, ey=0;
           for (int i = 0; i < L; i++) {
               for (int j = 0; j < R; j++) {
                   for (int k = 0; k < C; k++) {
                       building[i][j][k] = (char) br.read();
                       if (building[i][j][k] == 'S') {
                           sz = i;
                           sx = j;
                           sy = k;
                       }
                       if(building[i][j][k] == 'E'){
                           ez = i;
                           ex = j;
                           ey = k;
                       }
                   }
                   br.read();
               }
               br.read();
           }

           escape(sz, sx, sy);
           if(minutes[ez][ex][ey]==0) System.out.println("Trapped!");
           else System.out.println("Escaped in "+minutes[ez][ex][ey]+" minute(s).");
       }
    }

    public static void escape(int z, int x, int y){
        Queue<Coordinate> coor=new LinkedList<>();
        coor.offer(new Coordinate(z,x,y));
        building[z][x][y]='#';

        while(!coor.isEmpty()){
            Coordinate tmp=coor.poll();
            for(int i=0; i<2; i++){ //위,아래 면 이동 가능한 길 확인
                int nz=tmp.z+dz[i];
                if(nz>=0 && nz<L && building[nz][tmp.x][tmp.y]!='#'){
                    coor.offer(new Coordinate(nz,tmp.x,tmp.y));
                    building[nz][tmp.x][tmp.y]='#';
                    minutes[nz][tmp.x][tmp.y]=minutes[tmp.z][tmp.x][tmp.y]+1;
                }
            }
            for(int j=0; j<4; j++){
                int nx=tmp.x+dx[j];
                int ny=tmp.y+dy[j];
                boolean condition= nx>=0 && nx<R && ny>=0 && ny<C;
                if(condition && building[tmp.z][nx][ny]!='#'){
                    coor.offer(new Coordinate(tmp.z, nx, ny));
                    building[tmp.z][nx][ny]='#';
                    minutes[tmp.z][nx][ny]=minutes[tmp.z][tmp.x][tmp.y]+1;
                }
            }
        }
    }
}