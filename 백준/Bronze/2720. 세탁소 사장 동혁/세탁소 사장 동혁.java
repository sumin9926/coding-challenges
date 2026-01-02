import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[] coins = new int[]{25, 10, 5, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arrC = new int[T];

        for(int i=0; i<T; i++){
            arrC[i]=Integer.parseInt(br.readLine());
        }

        for(int i=0; i<T; i++){
            System.out.println(calNumOfCoins(arrC[i]));
        }
    }

    public static String calNumOfCoins(int C){
        StringBuilder sb = new StringBuilder();
        int money = C;

        for(int c : coins){
            sb.append(money/c).append(" ");
            money%=c;
        }

        return sb.deleteCharAt(sb.length()-1).toString();
    }
}