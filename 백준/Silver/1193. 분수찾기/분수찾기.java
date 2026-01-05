import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int line=0, max=0;

        while(max<X){
            line++;
            max+=line;
        }

        if(line%2==0){
            System.out.print((line-(max-X))+"/"+(1+(max-X)));
        }else{
            System.out.print((1+(max-X))+"/"+(line-(max-X)));
        }

    }
}