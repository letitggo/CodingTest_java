import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Queue queue = new Queue(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push" :
                    queue.push(Integer.parseInt(st.nextToken()));
                    break;
                case "front" :
                case "back":
                    sb.append(queue.peek(cmd)).append("\n");
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
            }
        }

        bw.write(sb + "");

        br.close();
        bw.close();
    }
}

class Queue{
    int[] queue;
    int size;
    int front;
    int rear;

    public Queue(int size){
        this.size = size;
        queue = new int[size];
        this.front = this.rear = 0;
    }

    public int size() {
        return rear - front;
    }

    public void push(int item) {
        queue[rear++] = item;
    }

    public int pop(){
        if (rear == front)
            return -1;
        else
            return queue[front++];
    }

    public int peek(String cmd){
        if (rear == front)
            return -1;
        else if (cmd.equals("front"))
            return queue[front];
        else {
            return queue[rear-1];
        }
    }

    public boolean isEmpty(){
        return front == rear;
    }

}



