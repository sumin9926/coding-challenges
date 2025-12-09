import java.util.*;

class Solution {
    
    static class DualPriorityQueue{
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        Map<Integer, Integer> count = new HashMap<>();
        int size=0;
        
        void insert(int num){
            maxQ.offer(num);
            minQ.offer(num);
            count.put(num, count.getOrDefault(num,0)+1);
            size++;
        }
        
        void lazyClean(PriorityQueue<Integer> pq){
            while(!pq.isEmpty()){
                int num = pq.peek();
                int cnt = count.getOrDefault(num, 0);
                if(cnt==0){
                    pq.poll();
                }else{
                    break;
                }
            }
        }
        
        void pollMin(){
            if(size==0) return;
            lazyClean(minQ);
            if(minQ.isEmpty()) return;
                
            int num = minQ.poll();
            int cnt = count.get(num);
                
            count.put(num, cnt-1);
            size--;
        }
        
        void pollMax(){
            if(size==0) return;
            lazyClean(maxQ);
            if(maxQ.isEmpty()) return;
                
            int num = maxQ.poll();
            int cnt = count.get(num);
                
            count.put(num, cnt-1);
            size--;
        }
        
        int getMin(){
            if(size==0) return 0;
            lazyClean(minQ);
            if(minQ.isEmpty()) return 0;
            return minQ.peek();
        }
        
        int getMax(){
            if(size==0) return 0;
            lazyClean(maxQ);
            if(maxQ.isEmpty()) return 0;
            return maxQ.peek();
        }
    }
    
    public int parseNum(String str){
        return Integer.parseInt(str.replaceAll("[^0-9-]",""));
    }
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        DualPriorityQueue dpq = new DualPriorityQueue();
        
        for(String str : operations){
            int num = parseNum(str);
            if(str.charAt(0)=='I'){
                dpq.insert(num);
            }else{
                if(num==-1){
                    dpq.pollMin();
                }else{
                    dpq.pollMax();
                }
            }
        }
        
        answer[0] = dpq.getMax();
        answer[1] = dpq.getMin();
        
        return answer;
    }
}