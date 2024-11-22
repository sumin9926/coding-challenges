import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
         Arrays.sort(strings, new Comparator<String>() { //comparator를 사용하여 정렬 기준 설정
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(n)==o2.charAt(n)) return o1.compareTo(o2); //비교할 문자가 같은 경우 전체 문자를 사전 순으로 정렬
                else return o1.charAt(n)-o2.charAt(n);
            }
        });
        return strings;
    }
}