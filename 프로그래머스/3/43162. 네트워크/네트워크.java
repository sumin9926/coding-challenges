class Solution {
    int[] isVisited;
    
    public void dfs(int startNode, int n, int[][] computers){
        if(isVisited[startNode]==1) return;
        else{
            isVisited[startNode]=1;
            for(int c=0; c<n; c++){
                if(isVisited[c]!=1 && computers[startNode][c]==1){
                    dfs(c, n, computers);
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        isVisited = new int[n];
        
        for(int i=0; i<n; i++){
            if(isVisited[i]==0){
                answer++;
                dfs(i, n, computers);
            }
        }
        
        
        return answer;
    }
}