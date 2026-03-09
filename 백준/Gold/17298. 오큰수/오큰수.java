import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[] arr=new int[N];
        int[] answer=new int[N];
        Deque<Integer> dq=new ArrayDeque<>();

        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());

            while(!dq.isEmpty() && arr[dq.peek()]<arr[i]) {
                answer[dq.pop()]=arr[i];
            }
            dq.push(i);
        }

        while(!dq.isEmpty()){
            answer[dq.pop()]=-1;
        }

        StringBuilder sb=new StringBuilder();
        for(int x:answer){
            sb.append(x).append(' ');
        }
        System.out.println(sb);
    }
}