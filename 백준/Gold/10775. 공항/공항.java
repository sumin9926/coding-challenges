import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int G,P,ans;
    static int[] gate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G=Integer.parseInt(br.readLine()); P=Integer.parseInt(br.readLine());
        gate=new int[G+1];
        for(int j=0; j<=G; j++){
            gate[j]=j;
        }

        for(int i=0; i<P; i++){
            int gateNum=Integer.parseInt(br.readLine()), fGateNum=Find(gateNum);
            if(fGateNum!=0){
                Union(fGateNum);
                ans++;
            }
            else break;
        }
        System.out.println(ans);
    }

    public static int Find(int v){
        if(v==gate[v]) return v;
        else return gate[v]=Find(gate[v]);
    }

    public static void Union(int fGateNum){
        gate[fGateNum]=Find(fGateNum-1);
    }
}