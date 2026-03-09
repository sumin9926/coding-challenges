import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

        System.out.print(baseConversion(N, B));
    }

    public static String baseConversion(int N, int B){
        StringBuilder sb = new StringBuilder();
        while(N!=0){
            int num = N%B;
            N/=B;
            if(num>=10){
                sb.append((char)(num+55));
            }else {
                sb.append(num);
            }
        }
        return sb.reverse().toString();
    }
}