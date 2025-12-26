class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(s<n) return new int[]{-1};
        
        int q = s/n;
        int r = s%n;
        
        for(int i=0; i<n-r; i++){
            answer[i]=q;
        }
        for(int i=n-r; i<n; i++){
            answer[i]=q+1;
        }
        
        return answer;
    }
}