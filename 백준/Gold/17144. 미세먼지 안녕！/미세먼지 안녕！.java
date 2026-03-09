import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main{
    static int R,C,T,top=Integer.MIN_VALUE,bottom=Integer.MIN_VALUE;
    static int[][] map;
    static int[] dr={-1,0,1,0}, dc={0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());

        map=new int[R][C];

        for(int i=0; i<R; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]==-1){ //청소기 위치 저장
                    if(top==Integer.MIN_VALUE) top=i;
                    else bottom=i;
                }
            }
        }

        for(int t=1; t<=T; t++){
            map=spreadDust();
            moveDust();
        }

        System.out.println(cntDust());
    }

    //미세먼지 확산
    public static int[][] spreadDust(){
        int[][] newMap=new int[R][C];

        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                int dust=map[r][c];
                newMap[r][c] += dust;
                if(dust>=5) {
                    int sp = dust / 5; //확산되는 먼지량
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d], nc = c + dc[d];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != -1) {
                            newMap[r][c] -= sp;
                            newMap[nr][nc] += sp;
                        }
                    }
                }
            }
        }
        newMap[top][0]=-1; //청정기 위치(상단)
        newMap[bottom][0]=-1; //청정기 위치(하단)
        return newMap;
    }

    //청정기 돌리기
    public static void moveDust(){
        //공기 청정기 상단
        for(int r=top-1; r>0; r--){ //0번째 열에서 아래로 진행
            map[r][0]=map[r-1][0];
        }
        for(int c=0; c<C-1; c++){//0번째 행에서 왼쪽으로 진행
            map[0][c]=map[0][c+1];
        }
        for(int r=0; r<top; r++){ //C-1번째 열에서 위로 진행
            map[r][C-1]=map[r+1][C-1];
        }
        for(int c=C-1; c>1; c--){ //top번째 행에서 오른쪽으로 진행
            map[top][c]=map[top][c-1];
        }
        map[top][1]=0; //공기청정기에서 나온 정화된 공기

        //공기 청정기 하단
        for(int r=bottom+1; r<R-1; r++){//0번째 열에서 위로 진행
            map[r][0]=map[r+1][0];
        }
        for(int c=0; c<C-1; c++){ //R-1번째 행에서 왼쪽으로 진행
            map[R-1][c]=map[R-1][c+1];
        }
        for(int r=R-1; r>bottom; r--){ //C-1번째 열에서 아래로 진행
            map[r][C-1]=map[r-1][C-1];
        }
        for(int c=C-1; c>1; c--){ //bottom번째 행에서 오른쪽으로 진행
            map[bottom][c]=map[bottom][c-1];
        }
        map[bottom][1]=0;//공기청정기에서 나온 정화된 공기

    }

    //먼지량 계산하기. 전역변수 map 사용
    public static int cntDust(){
        int answer=0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(map[r][c]>0) answer+=map[r][c];
            }
        }
        return answer;
    }
}