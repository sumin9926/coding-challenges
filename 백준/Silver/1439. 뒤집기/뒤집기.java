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
        int cntOne = 0, cntZero = 0;
        char[] inputArr = input.toCharArray();
        for (int i = 1; i < inputArr.length; i++) {
            if (inputArr[i - 1] != inputArr[i]) {
                if (inputArr[i - 1] == '0') {
                    cntZero++;
                } else {
                    cntOne++;
                }
            }
        }
        if(inputArr[inputArr.length-1]=='0'){
            cntZero++;
        }else{
            cntOne++;
        }

        return Math.min(cntOne, cntZero);
    }
}