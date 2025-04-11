import java.util.*;

class Solution {
    static class Node implements Comparable<Node> {
        int node, cost;
        
        Node(int node, int cost) {
            this.node=node;
            this.cost=cost;
        }
        
        public int compareTo(Node o) {
            return this.cost-o.cost; // 정렬 기준: 오름차순
        }
    }
    
    // 시작점부터 모든 노드 까지의 최단거리를 정수 배열로 반환하는 다익스트라 알고리즘 
    static int[] dijkstra(int start, List<List<Node>> graph, int n){ 
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node targetNode = pq.poll();
            if(targetNode.cost > dist[targetNode.node]) continue;
            
            for(Node linkedNode : graph.get(targetNode.node)) {
                int newCost = dist[targetNode.node]+linkedNode.cost;
                
                if(newCost < dist[linkedNode.node]) {
                    dist[linkedNode.node] = newCost;
                    pq.offer(new Node(linkedNode.node, newCost));
                }
            }
        }
        
        return dist;
    }
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<Node>> graph = new ArrayList<>();
        
        for(int i=0; i<=n ; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int[] fare : fares) {
            int firstNode = fare[0], secNode = fare[1], cost = fare[2];
            graph.get(firstNode).add(new Node(secNode, cost));
            graph.get(secNode).add(new Node(firstNode, cost));
        }
        
        int[] distS = dijkstra(s, graph, n);
        int[] distA = dijkstra(a, graph, n);
        int[] distB = dijkstra(b, graph, n);
        
        int answer = Integer.MAX_VALUE;
        
        for(int i=1; i<=n; i++) {
            if (distS[i] == Integer.MAX_VALUE || distA[i] == Integer.MAX_VALUE || distB[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            answer = Math.min(answer, distS[i]+distA[i]+distB[i]);
        }
        
        return answer;
    }
}
