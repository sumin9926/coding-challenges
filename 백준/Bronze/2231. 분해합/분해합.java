import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Nstr = br.readLine();
        int N = Integer.parseInt(Nstr), answer=Integer.MAX_VALUE;
        int C = N-(9*Nstr.length());//생성자

        while(C<N){
            String strC = String.valueOf(C);
            int sum = C;
            for(int i=0; i<strC.length(); i++){
                sum+= strC.charAt(i)-'0';
            }
            if(sum==N){
                answer=C;
                break;
            }
            C++;
        }

        if(answer==Integer.MAX_VALUE) answer=0;
        System.out.print(answer);
    }
}