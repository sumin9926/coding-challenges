import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arrA[i]=Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        int answer = 0;
        for(int i=0; i<N; i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                if(arrA[i]>arrA[j]) max = Math.max(max, dp[j]);
            }
            dp[i]=max+1;
            answer = Math.max(answer, dp[i]);
        }

        System.out.print(answer);
    }
}
