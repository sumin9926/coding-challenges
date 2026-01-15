import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Coordinate{
        int x, y;
        Coordinate(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Coordinate[] cors = new Coordinate[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken()), y=Integer.parseInt(st.nextToken());
            cors[i]=new Coordinate(x,y);
        }

        Arrays.sort(cors,(a,b)->{
            if(a.y==b.y) return a.x-b.x;
            else return a.y-b.y;
        });

        for(Coordinate c:cors){
            sb.append(c.x).append(" ").append(c.y).append('\n');
        }
        System.out.println(sb);
    }
}
