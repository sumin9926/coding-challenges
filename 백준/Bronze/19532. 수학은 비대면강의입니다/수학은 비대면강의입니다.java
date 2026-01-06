import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()),
                c = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken()),
                e = Integer.parseInt(st.nextToken()), f = Integer.parseInt(st.nextToken());
        
        // 방법 1 수학
        int x=(c*e-b*f)/(a*e-d*b), y=(c*d-a*f)/(b*d-a*e);
        System.out.print(x+" "+y);
    }
}