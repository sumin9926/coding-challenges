import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set=new HashSet<Integer>(); //index가 다른 두 수를 더한 값을 저장하는 set
        for(int i=0; i<numbers.length-1;i++){
            for(int j=i+1; j< numbers.length; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer=set.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}