import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(cntStringReversal(input));
    }

    public static int cntStringReversal(String input) {
        if(input.length()==1) return 0;
        int cntOne = 0, cntZero = 0;
        char prevChar = input.charAt(0);
        if(prevChar=='0'){
            cntZero++;
        }else{
            cntOne++;
        }
        for (int i = 1, n = input.length(); i < n; i++) {
            char currentChar = input.charAt(i);
            if(prevChar!=currentChar){
                if(currentChar=='0'){
                    cntZero++;
                }else{
                    cntOne++;
                }
                prevChar=currentChar;
            }
        }

        return Math.min(cntOne, cntZero);
    }
}