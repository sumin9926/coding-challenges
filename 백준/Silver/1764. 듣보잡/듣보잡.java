import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Set<String> nameSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            nameSet.add(br.readLine());
        }

        List<String> unSeenList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            unSeenList.add(br.readLine());
        }
        Collections.sort(unSeenList);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (String name : unSeenList) {
            if (nameSet.contains(name)) {
                cnt++;
                sb.append(name).append('\n');
            }
        }

        System.out.println(cnt);
        System.out.print(sb);
    }
}