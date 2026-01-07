import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine()), cnt=1, num=666;

        while(cnt<N){
            num++;
            if(String.valueOf(num).contains("666")){
                cnt++;
            }
        }

        System.out.print(num);
    }
}