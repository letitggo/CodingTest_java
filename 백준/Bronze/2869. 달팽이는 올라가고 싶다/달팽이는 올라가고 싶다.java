import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long V = Long.parseLong(st.nextToken());

        // (A - B) 만큼 낮과 밤에 걸쳐 올라가는 순진행 거리를 이용하여 계산
        long days = (V - A) / (A - B);
        if ((V - A) % (A - B) != 0) {
            days++; // 남은 거리가 있을 경우 하루 추가
        }

        // 마지막 낮에 정상에 도달하므로 하루를 더해줌
        System.out.println(days + 1);
    }
}
