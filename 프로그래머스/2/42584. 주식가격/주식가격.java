import java.util.*;

class price_time{
    int p, t;
    price_time(int p, int t){
        this.p=p;
        this.t=t;
    }
}

class Solution {
    public int[] solution(int[] prices) {
        int[] answer=new int[prices.length];
        Stack<price_time> pt=new Stack<>();
        pt.push(new price_time(prices[0],1));
                
        for(int i=2; i<=prices.length; i++){ // 상승장만 저장
            while(!pt.isEmpty() && prices[i-1]<pt.peek().p){ //주식 하락
                price_time tmp=pt.pop();
                answer[tmp.t-1]=i-tmp.t;
            }
            pt.push(new price_time(prices[i-1],i));
        }
        
        int size=pt.size();
        for(int i=0; i<size; i++){
            price_time tmp2=pt.pop();
            answer[tmp2.t-1]=prices.length-tmp2.t;
        }
        
        return answer;
    }
}