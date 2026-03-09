import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        Deque<Integer> dq=new ArrayDeque<>();
        int num=0;
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            String command=st.nextToken();
            switch (command){
                case "push_front":
                    num=Integer.parseInt(st.nextToken());
                    dq.push(num);
                    break;
                case "push_back":
                    num=Integer.parseInt(st.nextToken());
                    dq.offer(num);
                    break;
                case "pop_front":
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.pop()).append('\n');
                    break;
                case "pop_back":
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.pollLast()).append('\n');
                    break;
                case "size":
                    sb.append(dq.size()).append('\n');
                    break;
                case "empty":
                    if(dq.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                case "front":
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.peek()).append('\n');
                    break;
                case "back":
                    if(dq.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(dq.getLast()).append('\n');
                    break;
            }
        }
        br.close();
        System.out.println(sb);
    }
}