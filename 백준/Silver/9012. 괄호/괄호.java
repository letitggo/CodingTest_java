import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> stack;
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            stack = new Stack<>();
            boolean isVPS = true;

            for (int j = 0; j < str.length(); j++) {
                String target = String.valueOf(str.charAt(j));
                if (target.equals("(")){
                    stack.push(target);
                }else {
                    try{
                        stack.pop();
                    } catch (Exception e){
                        isVPS = false;
                    }
                }
            }
            if (!isVPS){
                sb.append("NO").append("\n");
            }else{
                if (stack.isEmpty()) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        bw.write(sb + "");

        br.close();
        bw.close();
    }
}


