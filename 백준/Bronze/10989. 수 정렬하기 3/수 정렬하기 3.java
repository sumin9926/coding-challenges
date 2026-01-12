import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());

        // 카운팅 배열
        int[] countingArr = new int[10001];

        for(int i=0; i<N; i++){
            int idx = Integer.parseInt(br.readLine());
            countingArr[idx]+=1;
        }

        for(int i=0; i< countingArr.length; i++){
            int cnt = countingArr[i];
            if(cnt>0){
                for(int j=0; j<cnt; j++){
                    bw.write(Integer.toString(i));
                    bw.newLine();
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
