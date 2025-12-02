import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0, max=0;
        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();
        for(int i=0; i<=n; i++){
            graph.add(new LinkedList<Integer>());
        }
        
        // 간선 정보 넣기
        for(int i=0; i<edge.length; i++){
            int v1 = edge[i][0], v2 = edge[i][1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        Queue<Integer> pq = new LinkedList<>();
        int[] edges = new int[n+1];
        
        pq.offer(1);
        
        while(!pq.isEmpty()){
            int node = pq.poll();
            LinkedList<Integer> row = graph.get(node);
            for(int v: row){
                if(v!=1&&edges[v]==0){
                    edges[v]=edges[node]+1;
                    max = max>edges[v] ? max:edges[v];
                    pq.offer(v);
                }
            }
        }
        
        for(int i=1; i<n+1; i++){
            if(edges[i]==max) answer++;
        }
        
        return answer;
    }
}