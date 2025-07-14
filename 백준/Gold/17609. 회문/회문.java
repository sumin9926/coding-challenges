import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] strArr = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = br.readLine();
        }
        for (String str : strArr) {
            System.out.println(isPalindrome(str));
        }
    }

    public static int isPalindrome(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if (arr[i] != arr[j]) {
                if(checkPalindrome(arr, i, j-1) || checkPalindrome(arr, i+1, j)) return 1;
                else return 2;
            }
        }
        return 0;
    }

    public static boolean checkPalindrome(char[] charArr, int i, int j){
        while (i<j){
            if(charArr[i++]!=charArr[j--]) return false;
        }
        return true;
    }
}