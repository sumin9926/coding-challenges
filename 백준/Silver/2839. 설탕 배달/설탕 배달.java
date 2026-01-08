import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), cnt = 10_000;

        for (int i = 0; i <= N/5; i++) { //5kg 개수
            int left=N - 5 * i;
            if (left % 3 == 0) {
                cnt = Math.min(cnt, (i + left / 3));
            }
        }

        if (cnt == 10_000) {
            System.out.println(-1);
        } else {
            System.out.println(cnt);
        }
    }
}