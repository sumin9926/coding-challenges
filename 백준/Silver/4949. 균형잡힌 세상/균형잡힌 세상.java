import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> dq = new ArrayDeque<>();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            boolean flag = true;

            for (char c : str.toCharArray()) {
                if(c=='.') break;
                else if (c == '(' || c == '[') {
                    dq.addFirst(c);
                } else if (c == ')') {
                    if (dq.isEmpty() || dq.getFirst() != '(') {
                        flag = false;
                        break;
                    } else {
                        dq.removeFirst();
                    }
                } else if (c == ']') {
                    if (dq.isEmpty() || dq.getFirst() != '[') {
                        flag = false;
                        break;
                    } else {
                        dq.removeFirst();
                    }
                }
            }
            if (flag && dq.isEmpty()) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
            dq.clear();
        }

        System.out.print(sb);
    }
}
