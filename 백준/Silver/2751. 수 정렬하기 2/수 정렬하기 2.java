import java.io.*;

class Main {
    static int[] nums, temps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        temps = new int[N];
        mergeSort(0, N-1);
        for (int num : nums) {
            bw.write(Integer.toString(num));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    // 인덱스 기반 병합 정렬 오름차순 구현
    public static void mergeSort(int start, int end) {
        if (start>=end) return;
        else {
            int mid = (end+start) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1,end);
            merge(start, mid, end);
        }
    }

    public static void merge(int start, int mid, int end) {
        int l = start, r = mid+1, idx = start;

        while (l <= mid && r <= end) {
            if (nums[l] <= nums[r]) {
                temps[idx++] = nums[l++];
            } else {
                temps[idx++] = nums[r++];
            }
        }

        while (l <= mid) {
            temps[idx++] = nums[l++];
        }

        while (r <= end) {
            temps[idx++] = nums[r++];
        }

        for(int i=start; i<=end; i++){
            nums[i]= temps[i];
        }
    }
}
