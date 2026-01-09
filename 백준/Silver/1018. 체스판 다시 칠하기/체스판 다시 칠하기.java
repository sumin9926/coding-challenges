import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()); // N열 M행
        char[][] board = new char[N][M];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int c = 0; c <= N - 8; c++) {
            for (int r = 0; r <= M - 8; r++) { //시작점
                //8*8 순회하면서 색칠
                int cntWrong = 0;
                for (int i = c; i < c + 8; i++) {
                    for (int j = r; j < r + 8; j++) {
                        char color = (i + j) % 2 == 0 ? 'W' : 'B';
                        if (board[i][j] != color) cntWrong++;
                    }
                }
                int min = Math.min(cntWrong, 64 - cntWrong);
                answer = Math.min(min, answer);
            }
        }

        System.out.println(answer);
    }
}
