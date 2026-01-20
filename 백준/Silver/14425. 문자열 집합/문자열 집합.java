import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int answer = 0;
        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            strSet.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            if (strSet.contains(br.readLine())) {
                answer++;
            }
        }

        System.out.print(answer);
    }
}