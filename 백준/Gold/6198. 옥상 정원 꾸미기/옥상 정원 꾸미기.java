import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] buildings=new long[n];
        for(int i=0; i<n; i++){
            buildings[i]=Long.parseLong(br.readLine());
        }

        Deque<Integer> dq=new ArrayDeque<>();
        long answer=0;

        for(int x=0; x<n; x++){
            while(!dq.isEmpty() && buildings[dq.peek()]<=buildings[x]){
                answer+=x-dq.peek()-1;
                dq.pop();
            }
            dq.push(x);
        }

        dq.pop(); //맨 마지막 건물 빼기
        while(!dq.isEmpty()){ //맨 마지막 건물을 제외하고 남아있는 건물이 있는 경우
            int index=dq.pop();
            if(buildings[index]>buildings[n-1])answer+=(n-1)-index;
        }
        System.out.println(answer);
    }
}