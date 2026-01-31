import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), total = 0;
        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            total += num;
            arr[i] = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> {
            if(Objects.equals(map.get(b), map.get(a))) return Integer.compare(a,b);
            return map.get(b) - map.get(a);
        });
        //산술평균
        System.out.println(Math.round((double) total / (double) N));
        //중앙값
        System.out.println(arr[N / 2]);
        //최빈값
        if(list.size()>1 && Objects.equals(map.get(list.get(0)), map.get(list.get(1)))){
            System.out.println(list.get(1));
        }
        else System.out.println(list.get(0));
        //범위
        System.out.println(arr[N - 1] - arr[0]);
    }
}
