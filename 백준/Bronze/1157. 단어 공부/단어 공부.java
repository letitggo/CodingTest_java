import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        int[] counts = new int[26]; // 알파벳 개수 저장 배열
        
        // 각 문자 카운트
        for (char c : s.toCharArray()) {
            char upperChar = Character.toUpperCase(c);
            counts[upperChar - 'A']++;
        }
        
        int maxCount = -1;
        char maxChar = '?';
        int duplicate = 0;
        
        // 최대값 및 중복 체크
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                maxChar = (char) ('A' + i);
                duplicate = 1; // 새로운 최대값 발견 시 중복 초기화
            } else if (counts[i] == maxCount) {
                duplicate++; // 동일한 최대값 발견 시 중복 증가
            }
        }
        
        System.out.println(duplicate > 1 ? '?' : maxChar);
    }
}