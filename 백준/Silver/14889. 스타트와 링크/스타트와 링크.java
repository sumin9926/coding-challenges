import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int n, answer=Integer.MAX_VALUE;
    static int[][] S; //능력치 조합 표
    static int[] number; //사람 번호. index 활용(0사용 안 함)

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        S=new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                S[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        number=new int[n+1];
        number[0]=-1; //0번 사용 안 함

        DFS(0,1);//1번 부터 시작
        System.out.println(answer);
    }

    public static void DFS(int L, int s){ //L은 뽑은 사람의 수, s는 뽑아야하는 사람의 번호

        if(L==n/2){ //절반의 인원을 다 뽑음(=한 팀 조합 완성)
            answer=Math.min(answer,calculator());
            return;
        }

        else{
            for(int i=s; i<=n; i++){
                number[i]=1;
                DFS(L+1, i+1);
                number[i]=0;
            }
        }

    }

    public static int calculator(){
        int startT=0,linkT=0;
        //startT S
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(number[i]==1&&number[j]==1) startT+=S[i-1][j-1];
                else if(number[i]==0&&number[j]==0) linkT+=S[i-1][j-1];
            }
        }
        return Math.abs(startT-linkT);
    }
}