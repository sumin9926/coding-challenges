import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0, cam=-30_001;
        Arrays.sort(routes, (a,b)->a[1]-b[1]);
        
        for(int i=0; i<routes.length; i++){
            if(cam<routes[i][0]){ // 카메라가 차량 진입 위치 이전에 설치되었을 경우 새로운 카메라 필요
                cam = routes[i][1];
                answer++;
            }
        }
        
        
        return answer;
    }
}