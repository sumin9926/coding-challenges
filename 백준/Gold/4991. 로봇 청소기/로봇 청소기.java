import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


class Point{
    int h,w;
    public Point(int h, int w){
        this.h=h;
        this.w=w;
    }
}

class Main {
    static boolean flag=true, possible;
    static int h,w,answer=Integer.MAX_VALUE;
    static int[][] map, dist;
    static ArrayList<Point> vacuum, dust;
    static int[] dh={0,0,1,-1}, dw={1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(flag){
            Solution(br);
        }

    }

    public static void Solution(BufferedReader br) throws IOException{
        StringTokenizer st=new StringTokenizer(br.readLine());
        w=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());
        if(w==0 && h==0){
            flag=false;
            return;
        }

        map=new int[h][w];
        vacuum=new ArrayList<>(); //청소기 위치
        dust=new ArrayList<>(); //먼지 위치
        for(int i=0; i<h; i++){
            String line=br.readLine();
            for(int j=0; j<w; j++){
                char a=line.charAt(j);
                if(a=='.') map[i][j]=0;
                else if(a=='*'){
                    map[i][j]=0;
                    dust.add(new Point(i,j));
                }
                else if(a=='x') map[i][j]=-1;
                else if(a=='o'){
                    map[i][j]=0;
                    vacuum.add(new Point(i,j));
                }
            }
        }

        dist= new int[dust.size()+1][dust.size()+1]; //청소기-먼지, 먼지-먼지 사이 거리 저장

        possible = true;
        for (int i = 0; i < dust.size() + 1; i++) {
            for (int j = i + 1; j < dust.size() + 1; j++) {
                if (!BFS(i, j)) {
                    possible = false;
                    break;
                }
            }
            if (!possible) break;
        }

        if(!possible) System.out.println(-1);
        else{
            boolean[] ch=new boolean[dust.size()+1];
            ch[0]=true;
            answer=Integer.MAX_VALUE;
            permutation(0, 1, 0,ch);
            System.out.println(answer);//순열
        }
    }

    //조합 간의 거리
    public static boolean BFS(int start, int end){
        Queue<Point> q=new LinkedList<>();
        int[][] copyMap=new int[h][w];
        for(int i=0; i<h; i++){
            System.arraycopy(map[i], 0, copyMap[i],0, w);
        }

        int distCnt=0;

        Point sPoint = (start == 0) ? vacuum.get(0) : dust.get(start - 1);
        Point ePoint = dust.get(end - 1);

        q.offer(sPoint);
        while(!q.isEmpty()){
            int size=q.size();
            distCnt++;
            for(int j=0; j<size; j++) {
                Point tmp = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nh = tmp.h + dh[i], nw = tmp.w + dw[i];
                    if (nh >= 0 && nh < h && nw >= 0 && nw < w && copyMap[nh][nw] == 0) {
                        if (nh == ePoint.h && nw == ePoint.w) {
                            dist[start][end]=dist[end][start]=distCnt;
                            return true;
                        }
                        copyMap[nh][nw] = 1; //지나간 길 표시
                        q.offer(new Point(nh, nw));
                    }
                }
            }
        }
        return false;
    }

    //순열 만들어서 거리 계산
    public static void permutation(int s, int cnt, int sum, boolean[] ch){
        if(cnt==ch.length){ //청소기와 모든 더러운 칸 순열 만들기 완료
            answer=Math.min(answer,sum);
            return;
        }
        for(int i=1; i<ch.length; i++){ //start는 항상 청소기 부터(index=0)이기 때문에 더러운 칸 위치만 가지고 순열 만들기
            if(ch[i]) continue;
            ch[i]=true; //방문한 곳 체크
            permutation(i,cnt+1, sum+dist[s][i], ch);
            ch[i]=false; //체크 해제
        }
    }
}