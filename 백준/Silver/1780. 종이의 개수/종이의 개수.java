import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static int[][] paper;
    static int N;
    static int[] answer=new int[3];

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        paper=new int[N][N];
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                paper[i][j]=Integer.parseInt(st.nextToken());
                if(paper[i][j]==-1) paper[i][j]=2;
            }
        }

        checkElement(0,0, N);


        System.out.println(answer[2]);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public static void checkElement(int x, int y, int size){
        boolean same=true;
        for(int nx=x; nx<x+size; nx++){
            for(int ny=y; ny<y+size; ny++){
                if(paper[nx][ny]!=paper[x][y]){//종이에 서로 다른 요소가 있는 경우
                    same=false;
                    break;
                }
            }
            if(!same) break;
        }
        if(same){
            answer[paper[x][y]]++;
        }
        else for(int i=1; i<=9; i++) dividePaper(i, x, y, size/3);
    }

    public static void dividePaper(int i, int x, int y, int size){
        switch(i){
            case 1: checkElement(x, y, size);
                    break;
            case 2: checkElement(x, y+size, size);
                    break;
            case 3: checkElement(x, y+2*size, size);
                    break;
            case 4: checkElement(x+size, y, size);
                    break;
            case 5: checkElement(x+size, y+size, size);
                    break;
            case 6: checkElement(x+size, y+2*size, size);
                    break;
            case 7: checkElement(x+2*size, y, size);
                    break;
            case 8: checkElement(x+2*size, y+size, size);
                    break;
            case 9: checkElement(x+2*size, y+2*size, size);
                    break;
        }
    }
}