import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> logs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken(), log = st.nextToken();
            if (log.equals("enter")) {
                logs.add(name);
            } else {
                logs.remove(name);
            }
        }
        List<String> names = new ArrayList<>(logs);
        Collections.sort(names, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append('\n');
        }
        System.out.print(sb);
    }
}
