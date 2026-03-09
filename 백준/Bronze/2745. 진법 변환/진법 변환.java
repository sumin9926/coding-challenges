import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        System.out.print(baseConversion(N, B));
    }

    public static int baseConversion(String N, int B){
        char[] n = N.toCharArray();
        int answer=0;
        for(int i=0; i<n.length; i++){
            if(Character.isAlphabetic(n[i])){
                int num = n[i]-55;
                answer=B*answer+num;
            }else{
                answer=B*answer+Character.getNumericValue(n[i]);
            }
        }
        return answer;
    }
}