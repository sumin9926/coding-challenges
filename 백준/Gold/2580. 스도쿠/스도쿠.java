import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    static int[][] board=new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<9; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                board[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }

    //DFS로 구현. 각 행에 대한 탐색 진행
    public static void sudoku(int nR, int nC){ //탐색한 행과 열의 개수를 매개변수로
        if(nC==9){ //하나의 행 탐색 완료
            sudoku(nR+1,0); //다음 행 탐색 시작
            return;
        }

        if(nR==9){ //맨 마지막 행까지 모든 값에 대해 탐색을 완료함
            //답 출력
            StringBuilder sb=new StringBuilder();
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    sb.append(board[i][j]).append(' ');
                }
                sb.append('\n'); //줄 바꿔주기
            }
            System.out.println(sb);
            System.exit(0);
        }

        //공란 찾기
        if(board[nR][nC]==0){
            for(int i=1; i<=9; i++) { //0~9까의 값 시도
                if(isPossible(nR,nC,i)){
                    board[nR][nC]=i; //조건에 맞는 값 넣기
                    sudoku(nR,nC+1);
                }//nR번째 행에 있는 nC+1번 값 탐색 (board[nR][nC+1])
            }
            board[nR][nC]=0;
            return;
        }

        sudoku(nR,nC+1); //board[nR][nC]!=0일 경우에도 이어서 다음 값 탐색
    }

    //넣으려는 숫자가 조건에 부합하는지 확인하는 함수
    public static boolean isPossible (int R, int C, int value){
        //특정 행의 숫자가 넣으려는 값과 중복되는지 체크
        for(int i=0; i<9; i++) if(board[R][i]==value) return false;

        //특정 열의 숫자가 넣으려는 값과 중복되는지 체크
        for(int j=0; j<9; j++) if(board[j][C]==value) return false;

        //3*3범위 내의 숫자가 숫자가 넣으려는 값과 중복되는지 체크
        int SR=(R/3)*3;
        int SC=(C/3)*3; //3*3 시작(왼쪽 상단) 좌표
        for(int k=SR; k<SR+3; k++){
            for(int l=SC; l<SC+3; l++){
                if(board[k][l]==value) return false;
            }
        }

        return true; // 넣으려는 값과 중복되는 숫자가 없음
    }


}