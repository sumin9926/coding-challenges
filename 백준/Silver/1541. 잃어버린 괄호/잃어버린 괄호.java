import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // 숫자만 추출
        String strCpy = str.replace("-", " ").replace("+", " ");
        StringTokenizer st = new StringTokenizer(strCpy);

        // 덱에는 뺄셈할 숫자만 저장
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(getParseInt(st.nextToken()));
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                q.addLast(getParseInt(st.nextToken()));
            } else if (str.charAt(i) == '+') { // 식의 값을 최소로 만들기 위해서는 덧셈을 우선 수행해 뺄 숫자를 최대한 큰 값으로 만들어야한다. 
                int a = q.removeLast();
                int b = getParseInt(st.nextToken());
                q.addLast(a + b);
            }
        }
        int answer = q.removeFirst();
        while (!q.isEmpty()) {
            answer -= q.removeFirst();
        }
        System.out.print(answer);
    }

    private static int getParseInt(String num) {
        return Integer.parseInt(num.replaceFirst("^0+", ""));
    }
}
