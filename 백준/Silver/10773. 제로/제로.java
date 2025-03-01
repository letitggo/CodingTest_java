import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack(100_000);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int item = Integer.parseInt(br.readLine());
            if (item == 0) {
                int pop = stack.pop();
                answer -= pop;
            } else{
                stack.push(item);
                answer += item;
            }
        }

        System.out.println(answer);

        br.close();
        bw.close();
    }
}

class Stack {
    int top;
    int size;
    int[] stack;

    public Stack(int size) {
        this.size = size;
        top = -1;
        stack = new int[size];
    }

    public void push(int item) {
        stack[++top] = item;
    }

    public int pop() {
        if (top != -1) {
            return stack[top--];
        }
        return -1;
    }
}

