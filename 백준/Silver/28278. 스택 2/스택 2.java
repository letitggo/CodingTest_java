import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack stack = new Stack(1_000_000);

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd){
                case 1 :
                    int data = Integer.parseInt(st.nextToken());
                    stack.push(data);
                    break;
                case 2 :
                    System.out.println(stack.pop());
                    break;
                case 3 :
                    System.out.println(stack.size());
                    break;
                case 4 :
                    System.out.println(stack.isEmpty());
                    break;
                case 5 :
                    System.out.println(stack.peek());
                    break;
            }
        }

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

    public void push(int data) {
        stack[++top] = data;
    }

    public int pop() {
        if (top == -1){
            return -1;
        }else {
            return stack[top--];
        }
    }
    public int isEmpty() {
        if (top == -1)
            return 1;
        else
            return 0;
    }

    public int size(){
        return top + 1;
    }

    public int peek(){
        if (top == -1)
            return -1;
        else
            return stack[top];
    }
}
