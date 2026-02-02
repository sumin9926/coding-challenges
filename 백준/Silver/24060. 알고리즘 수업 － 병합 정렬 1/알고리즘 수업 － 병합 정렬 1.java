import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] A, tmp;
    static int saveCnt = 0, kNum = 0, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        A = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        tmp = new int[size];
        mergeSort(0, size - 1); // 오름차순 정렬
        if (saveCnt < k) System.out.print(-1);
        else System.out.print(kNum);
    }

    static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);

            merge(start, mid, end);
        }
    }

    static void merge(int start, int mid, int end) {
        int li = start, ri = mid + 1, ti = start;

        while (li <= mid && ri <= end) {
            if (A[li] <= A[ri]) {
                tmp[ti++] = A[li++];
            } else {
                tmp[ti++] = A[ri++];
            }
        }

        //왼쪽 배열 남음
        while (li <= mid) {
            tmp[ti++] = A[li++];
        }
        //오른쪽 배열 남음
        while (ri <= end) {
            tmp[ti++] = A[ri++];
        }

        for (int i = start; i <= end; i++) {
            saveCnt++;
            if (saveCnt == k) {
                kNum = tmp[i];
            }
            A[i] = tmp[i];
        }
    }
}
