import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] cnts = new int[10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int code=0;
        do{
            code = br.read();
            if(code>=48){
                int idx = code-48;
                cnts[idx]+=1;
            }
        }while(code!=10);

        for(int i=9; i>=0; i--){
            if(cnts[i]==0) continue;
            for(int j=0; j<cnts[i]; j++){
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}