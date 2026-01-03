import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int cnt = 0, max=1;

        while(N>max){
            cnt++;
            max=max+(6*cnt);
        }
        System.out.print(cnt+1);
    }
}