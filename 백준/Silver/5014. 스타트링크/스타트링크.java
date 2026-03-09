import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class Main {
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int F=Integer.parseInt(st.nextToken()); //최상층
        int S=Integer.parseInt(st.nextToken()); //현재 위치
        int G=Integer.parseInt(st.nextToken()); //사무실 층
        int U=Integer.parseInt(st.nextToken()); //한 번에 올라갈 수 있는 층수
        int D=Integer.parseInt(st.nextToken()); //한 번에 내려갈 수 있는 층수
        if(S==G){
            System.out.print(0);
            return;
        }
        int answer=BFS(F,S,G,U,D);
        if(answer==-1) System.out.print("use the stairs");
        else System.out.println(answer);
    }

    public static int BFS(int F, int S, int G, int U, int D){
        int cnt=0; //버튼 횟수
        ch=new boolean[F+1];
        ch[0]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(S);
        ch[S]=true; //중복체크 방지

        while(!q.isEmpty()) {
            int len = q.size();
            cnt++;
            for(int i=0; i<len; i++){
                int state=q.poll();
                int nU=state+U; //올라갔을 때의 층
                int nD=state-D; //내려갔을 때의 층
                if(nU>=1 && nU<=F && !ch[nU]) {
                    q.offer(nU);
                    if(G==nU) return cnt;
                    ch[nU]=true;
                }
                if(nD<=F && nD>=1 && !ch[nD]){
                    q.offer(nD);
                    if(G-nD==0) return cnt;
                    ch[nD]=true;
                }
            }
        }
        return -1;
    }
}