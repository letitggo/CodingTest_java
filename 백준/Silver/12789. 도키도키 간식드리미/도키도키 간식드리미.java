import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int min = 1;
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (next > min){
                if (!stack.isEmpty()){
                    int size = stack.size();
                    for (int j = 0; j < size; j++) {
                        if (stack.peek() == min) {
                            stack.pop();
                            min++;
                        }
                    }
                }
                stack.push(next);
            }else if (next == min){
                min++;
            } else {
                System.out.println("Sad");
                return;
            }
        }

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            Integer next = stack.pop();
            if (min != next) {
                System.out.println("Sad");
                return;
            }else{
                min++;
            }
        }
        System.out.println("Nice");

        br.close();
        bw.close();
    }
}



