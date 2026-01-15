import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<String> stringSet = new HashSet<>();
        for(int i=0; i<N; i++){
            stringSet.add(br.readLine());
        }

        String[] strings = stringSet.toArray(new String[0]);
        Arrays.sort(strings, (a, b)->{
            if(a.length()==b.length()) return a.compareTo(b);
            else return a.length()-b.length();
        });

        for(String s: strings){
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}