import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] distances = new long[N - 1];
        long[] gasStations = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gasStations[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        for (int i = 0; i < N - 1; i++) {
            long dist = distances[i];
            long cost = gasStations[i];
            for (int j = i + 1; j < N - 1; j++) {
                if (cost <= gasStations[j]) {
                    dist += distances[j];
                    i++;
                } else break;
            }
            answer += dist * cost;
        }
        System.out.print(answer);
    }
}
