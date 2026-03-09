import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result=-10000, preSum = 0;
        for(int i=0; i<n; i++){
            int num=Integer.parseInt(st.nextToken());
            if(preSum+num<num){
                preSum=num;
            }else{
                preSum+=num;
            }
            result=Math.max(result, preSum);
        }

        System.out.print(result);
    }
}
