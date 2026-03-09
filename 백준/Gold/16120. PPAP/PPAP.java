import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String sp=br.readLine();

        Deque<Character> dq=new ArrayDeque<>();
        int cntP=0, splen=sp.length();
        for(int i=0; i<splen; i++){
            char x=sp.charAt(i);

            if(i+1<splen && x=='A' && cntP>=2 && sp.charAt(i+1)=='P'){
                if(sp.charAt(i-1)=='A') break;
                dq.pop();
                cntP--;
                i++;
                continue;
            }
            if(x=='P') {
                cntP++;
                dq.push(x);
            }
            //중도 종료 조건
            if(x=='A' && cntP<2){
                System.out.println("NP");
                return;
            }
        }
        //ppap 문자열은 문자 p로부터 시작된 문자열이기 때문에, 문자열의 모든 ppap를 p로 만들었을 때 마지막에는 p가 하나만 남아야한다.
        if(dq.size()==1 && dq.peek()=='P') System.out.println("PPAP");
        else System.out.println("NP");
    }
}