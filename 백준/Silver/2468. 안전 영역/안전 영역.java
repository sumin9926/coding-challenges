import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Main{
    static int answer=1,N,cnt; //비가 내리지 않는경우 안전 영역은 1
    static int[][] map;
    static int[] dx={-1,0,1,0}, dy={0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
              map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<=100; i++){ //i는 수위를 의미. 0(비가 내리지 않음)~100
            int[][] check=new int[N][N]; //수위가 달라질 때 마다 초기화
            cnt=0;//각 수위에 대한 안전구역 개수를 저장하는 변수(수위가 달라질 때 마다 초기화)
            for(int x=0; x<N; x++){
                for(int y=0; y<N; y++){
                    if(check[x][y]==0 && map[x][y]>i){ //탐방한 적 없는 지역 & 안전 영역
                        check[x][y]=1;
                        cnt++;
                        cntSafetyZone(x,y,i,check);
                   }
                }
            }
            answer=Math.max(cnt,answer);
        }
        System.out.print(answer);
    }

    //중복 순회를 방지하기 위해 check 배열에서 안전구역을 1로 표시
    public static void cntSafetyZone(int x, int y,int waterLevel, int[][] check){
        for(int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            boolean bounds = nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]>waterLevel;
            if(bounds && check[nx][ny]==0){
                check[nx][ny]=1;
                cntSafetyZone(nx, ny, waterLevel, check);
            }
        }
    }
}