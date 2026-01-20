import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Map<String, Integer> strToInt = new HashMap<>();
        Map<Integer, String> intToStr = new HashMap<>();
        int idx = 1;
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            strToInt.put(name, idx);
            intToStr.put(idx, name);
            idx++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) {
                int num = Integer.parseInt(question);
                sb.append(intToStr.get(num)).append('\n');
            } else {
                sb.append(strToInt.get(question)).append('\n');
            }
        }
        System.out.print(sb);
    }
}
