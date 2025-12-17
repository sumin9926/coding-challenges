class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] isWin = new boolean[n+1][n+1];
        
        // 승자=true, 패자 or 알수없음=false
        for(int i=0; i<results.length; i++){
            int winner = results[i][0], loser=results[i][1];
            isWin[winner][loser] = true;
        }
        
        //각 선수간의 경기 결과 구하기
        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(isWin[i][k] && isWin[k][j]) isWin[i][j] = true;
                }
            }
        }
        
        for(int i=1; i<n+1; i++){
            boolean flag = true;
            for(int j=1; j<n+1; j++){
                if(i==j) continue;
                if(!isWin[i][j] && !isWin[j][i]){ //[i,j]와[j,i]가 false일 경우 결과를 알 수 없음
                    flag=false;
                    break;
                }
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}