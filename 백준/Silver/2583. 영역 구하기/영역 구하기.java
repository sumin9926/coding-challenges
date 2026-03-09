
import java.util.*;

class Point{
    int sx, sy, ex,ey;
    Point(int sx, int sy, int ex, int ey){
        this.sx=sx;
        this.sy=sy;
        this.ex=ex;
        this.ey=ey;
    }
}

class Main {
    static ArrayList<Integer> answer=new ArrayList<>(); //영역별 넓이
    static int cnt;//나누어지는 영역 개수
    static int area; //영역의 넓이
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};

    public static void DFS(int x, int y, int[][] Board, int m, int n){
       area++;
        for(int i=0; i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if(nx>=0 && nx<m && ny>=0 && ny<n && Board[nx][ny]==0){
                Board[nx][ny]=1;
                DFS(nx, ny, Board, m, n);
            }
        }

    }

    public static ArrayList<Integer> Solution(int m, int n, int[][] Board){

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                area=0; //초기화
                if(Board[i][j]==0) {
                    Board[i][j]=1;
                    cnt++;
                    DFS(i,j,Board, m, n);
                    answer.add(area);
                }
            }

        }

        Collections.sort(answer);
        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int m=kb.nextInt(); //x
        int n=kb.nextInt(); //y
        int k=kb.nextInt(); //좌표 개수
        int[][] Board=new int[m][n]; //모눈종이
        ArrayList<Point> p=new ArrayList<>();
        for(int i=0; i<k; i++){
            int sy=kb.nextInt(); //왼쪽 아래 점의 y
            int sx=kb.nextInt(); //왼쪽 아래 점의 x
            int ey= kb.nextInt()-1; //오른쪽 위 점의 y
            int ex= kb.nextInt()-1; //오른쪽 위 점의 x
            p.add(new Point(sx,sy,ex,ey));
        }

        for(Point t: p){
            for(int i=t.sx; i<=t.ex; i++){
                for(int j=t.sy; j<=t.ey; j++){
                    Board[i][j]=1;
                }
            }
        } //모눈종이에서 직사각형 부분을 1로 표시

        Solution(m, n, Board);

        System.out.println(cnt);
        for(int num: answer){
            System.out.print(num+" ");
        }
    }
}