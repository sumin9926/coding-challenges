import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] results = new int[N+1];
        results[0]=4;

        for(int i=1; i<=N; i++){
            int p = (int)Math.pow(2, i-1);
            results[i]=p*(p+1)+p*(p+1)+p*p+results[i-1];
        }

        System.out.println(results[N]);
    }
}