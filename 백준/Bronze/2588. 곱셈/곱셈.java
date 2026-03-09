import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int first=Integer.parseInt(br.readLine());
    int sec=Integer.parseInt(br.readLine());
    int tmp=sec;
    while(tmp!=0){
        System.out.println(first*(tmp%10));
        tmp/=10;
    }
    System.out.println(first*sec);
    }
}