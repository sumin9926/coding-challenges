import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Meeting {
        int startTime, endTime;

        Meeting(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(startTime, endTime);
        }

        // 회의가 가장 빨리 끝나는 순서대로 나열
        Arrays.sort(meetings, (a, b) -> {
            if (a.endTime == b.endTime) return a.startTime - b.startTime;
            else return a.endTime - b.endTime;
        });

        int lastTime = 0, answer = 0;
        for (int i = 0; i < N; i++) {
            if (meetings[i].startTime >= lastTime) {
                answer++;
                lastTime = meetings[i].endTime;
            }
        }
        System.out.print(answer);
    }
}
