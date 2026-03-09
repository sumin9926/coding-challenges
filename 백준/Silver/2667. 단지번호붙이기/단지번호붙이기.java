import java.util.*;
import java.io.IOException; //예외처리
import java.io.BufferedReader; //String을 읽는다
import java.io.InputStreamReader; //char을 읽는다

class Main {
    static int[] dx={0,1,0,-1};
    static int[] dy={-1,0,1,0};
    static int n, cnt;
    static ArrayList<Integer> answer=new ArrayList<>(); //각 단지내 집의 수를 저장할 배열

    public static void DFS(int[][] map, int i, int j){
        cnt++;
        for(int k=0; k<4; k++){
                int nx=i+dx[k];
                int ny=j+dy[k];
                if(nx>=0 && nx<n && ny>=0 && ny<n && map[nx][ny]==1){
                    map[nx][ny]=0;
                    DFS(map,nx,ny);
                }
        }
    }

    public static void Solution(int[][] map){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                cnt=0; //단지내 집의 개수 초기화
                if(map[i][j]==1){ //지도에서 i,j가 가리키는 위치가 집이면
                    map[i][j]=0;
                    DFS(map, i, j);
                    answer.add(cnt);
                }
            }
        }
        Collections.sort(answer); //오름차순으로 정렬
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        int[][] map=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j]=br.read()-'0'; //자료들이 공백문자로 구분되어있지 않기때문에 StringTokenizer의 nextToken()함수는 사용할 필요 없음
            }
            br.read(); //개행문자 읽기
        }
        

        Solution(map);

        System.out.println(answer.size());
        for(int a:answer){
            System.out.println(a);
        }
    }
}