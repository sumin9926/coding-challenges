import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int sLen = S.length();
        char[] sArr = S.toCharArray();
        int q = Integer.parseInt(br.readLine());

        // 알파벳 배열
        char[] alphaArr = new char[26];
        for (int i = 0; i < 26; i++) {
            alphaArr[i] = (char) (i + 97);
        }

        // 문자열에 나오는 알파벳 누적합 배열 생성
        Map<Character, int[]> map = new HashMap<>();
        for (char alpha : alphaArr) {
            map.put(alpha, new int[sLen + 1]);
        }
        for (int i = 1; i <= sLen; i++) {
            char c = sArr[i - 1];
            for (char alpha : alphaArr) {
                int[] arr = map.get(alpha);
                arr[i] = arr[i - 1];
            }
            map.get(c)[i]++;
        }

        // 누적합 계산
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char al = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) + 1;
            // 횟수 구하기
            int[] arr = map.get(al);
            sb.append(arr[r] - arr[l]).append('\n');
        }
        System.out.print(sb);
    }
}
