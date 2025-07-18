import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Deque<Integer> dq=new ArrayDeque<>();
        int[] buildings=new int[N];
        int[] ans=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int s=Integer.parseInt(st.nextToken());
            buildings[i]=s;
        }

        StringBuilder answer=new StringBuilder();
        for(int i=0; i<N; i++){
            while(!dq.isEmpty() && buildings[i]>buildings[dq.peek()]){ //넣으려는 건물의 높이보다 낮은 건물을 모두 pop한다.
                dq.pop();
            }
            if(dq.isEmpty()) answer.append("0 ");//좌측에 넣으려는 건물보다 높은 건물이 없는 경우
            else{ //좌측에 넣으려는 건물보다 높은 건물이 존재
                answer.append(dq.peek()+1); //건물 번호는 0이 아니라 1부터 시작한다.
                answer.append(' ');
            }
            dq.push(i);
        }

        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }
}