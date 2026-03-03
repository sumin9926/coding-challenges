import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] values = new int[N + 1][3];
        Arrays.fill(values[0], 0);
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            values[i][0] = Integer.parseInt(st.nextToken()); //R
            values[i][1] = Integer.parseInt(st.nextToken()); //G
            values[i][2] = Integer.parseInt(st.nextToken()); //B
        }

        for(int i=2; i<=N; i++){
            values[i][0]+=Math.min(values[i-1][1], values[i-1][2]);
            values[i][1]+=Math.min(values[i-1][0], values[i-1][2]);
            values[i][2]+=Math.min(values[i-1][1], values[i-1][0]);
        }

        System.out.print(Math.min(Math.min(values[N][0], values[N][1]), values[N][2]));
    }
}
