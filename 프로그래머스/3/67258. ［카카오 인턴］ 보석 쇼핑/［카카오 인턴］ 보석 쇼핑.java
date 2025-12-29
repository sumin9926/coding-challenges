import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = gems.length;

        Set<String> kinds = new HashSet<>(Arrays.asList(gems));
        int K = kinds.size();

        Map<String, Integer> cnt = new HashMap<>();
        int left = 0;
        int bestL = 0, bestR = n - 1;
        int bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            cnt.put(gems[right], cnt.getOrDefault(gems[right], 0) + 1);

            while (cnt.size() == K) {
                int len = right - left + 1;
                if (len < bestLen) {
                    bestLen = len;
                    bestL = left;
                    bestR = right;
                }

                String g = gems[left];
                int c = cnt.get(g) - 1;
                if (c == 0) cnt.remove(g);
                else cnt.put(g, c);
                left++;
            }
        }

        return new int[] { bestL + 1, bestR + 1 };
    }
}
