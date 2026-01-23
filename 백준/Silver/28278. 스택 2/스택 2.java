import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            switch(command){
                case 1: {
                    int num = Integer.parseInt(st.nextToken());
                    stack.addFirst(num);
                    break;
                }
                case 2: {
                    if(stack.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(stack.removeFirst()).append('\n');
                    break;
                }
                case 3: {sb.append(stack.size()).append('\n'); break;}
                case 4: {
                    if(stack.isEmpty()) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                }
                case 5: {
                    if(stack.isEmpty()) sb.append(-1).append('\n');
                    else sb.append(stack.getFirst()).append('\n');
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
