import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        Map<String, Integer> words = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }
        // 우선순위대로 정렬
        List<String> wordList = new ArrayList<>(words.keySet());
        wordList.sort((a, b) -> {
            if (!Objects.equals(words.get(a), words.get(b))) return words.get(b) - words.get(a);
            if (b.length() != a.length()) return b.length() - a.length();
            else return a.compareTo(b);
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String word : wordList) {
            bw.write(word);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
