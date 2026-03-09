import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int X=Integer.parseInt(st.nextToken()), Y=Integer.parseInt(st.nextToken()),
        W=Integer.parseInt(st.nextToken()), S=Integer.parseInt(st.nextToken());
        int min=Math.min(X,Y), max=Math.max(X,Y);
        long answer=0;

        if(S<W){ //지그재그 형태로 이동
            if((X+Y)%2==0) answer=(long)max*S;
            else answer=(long)(max-1)*S+W;
        }
        else if(S>=W*2) answer=(long)(X+Y)*W;
        else{ //S<2W
            answer=(long)S*min + (long) W *(max-min);
        }

        System.out.println(answer);
    }
}