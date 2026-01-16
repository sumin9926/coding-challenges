import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] F=new int[1_000_001];

        Deque<Integer> dq=new ArrayDeque<>();
        int[] A=new int[N];
        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
            F[A[i]]++; //F(i)값 구하기
        }

        int[] NGF=new int[N];
        for(int i=0; i<N; i++){
            while(!dq.isEmpty() && F[A[dq.peek()]]<F[A[i]]) {
                NGF[dq.pop()]=A[i];
            }
            dq.push(i);
        }

        while(!dq.isEmpty()){
            NGF[dq.pop()]=-1;
        }

        StringBuilder answer=new StringBuilder();
        for(int x:NGF){
            answer.append(x).append(' ');
        }
        System.out.println(answer);
    }
}