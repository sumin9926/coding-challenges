import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        TreeSet<Integer> treeSet=new TreeSet<Integer>((o1,o2)->o1-o2); //index가 다른 두 수를 더한 값을 저장하는 set
        for(int i=0; i<numbers.length-1;i++){
            for(int j=i+1; j< numbers.length; j++){
                treeSet.add(numbers[i]+numbers[j]);
            }
        }
        int[] answer=treeSet.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}