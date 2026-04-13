import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //행렬 A
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[N][M];
        for(int row=0; row<N; row++){
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<M; col++){
                matrixA[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        //행렬 B
        st = new StringTokenizer(br.readLine());
        st.nextToken(); //행렬B의 M
        int K = Integer.parseInt(st.nextToken());
        int[][] matrixB = new int[M][K];
        for(int row=0; row<M; row++){
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<K; col++){
                matrixB[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        //행렬 곱(AB)
        StringBuilder sb = new StringBuilder();
        for(int row=0; row<N; row++){
            for(int col=0; col<K; col++){
                int result=0;
                for(int i=0; i<M; i++){
                    result+=matrixA[row][i]*matrixB[i][col];
                }
                sb.append(result).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
