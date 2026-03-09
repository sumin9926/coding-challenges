import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];

        String s= br.readLine();
        int index=0;
        for(char x: s.toCharArray()){
            arr[index++]=x-'0';
        }

        Stack<Integer> stack=new Stack<>();
        stack.push(arr[0]);

        int k=K;
        for(int i=1; i<N; i++){
            while(!stack.isEmpty() && stack.peek()<arr[i] && k>0){
                stack.pop();
                k--;
            }
            stack.push(arr[i]);
        }

        while(k>0){
           stack.pop();
           k--;
        }

        /* 방법 1
        int answer=0;

        for(int figures=0; figures<N-K; figures++){
            int multiplicand=(int)Math.pow(10.0,figures);//곱하는 수
            int multiplier=stack.pop(); //곱해지는 수

            answer+=multiplicand*multiplier;
        }*/

        /*방법 2*/
        StringBuilder sb=new StringBuilder();
        for(int num: stack){
            sb.append(num);
        }

        System.out.println(sb);
    }
}