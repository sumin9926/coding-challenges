import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> numSet = new HashSet<>();
        int[] nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i]=Integer.parseInt(st.nextToken());
            numSet.add(nums[i]);
        }
        Integer[] sortedNums = numSet.toArray(new Integer[0]);
        Arrays.sort(sortedNums);
        Map<Integer, Integer> compreesedCorMap = new HashMap<>();
        for(int i=0; i<sortedNums.length; i++){
            compreesedCorMap.put(sortedNums[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for(int num:nums){
            int idx = compreesedCorMap.get(num);
            sb.append(idx).append(" ");
        }

        System.out.print(sb);
    }
}
