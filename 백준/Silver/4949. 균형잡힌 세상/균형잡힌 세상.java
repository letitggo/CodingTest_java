import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String ps = br.readLine();
            if (ps.equals(".")) break;
            if (isVPS(ps)) {
                System.out.println("yes");
            }else
                System.out.println("no");
        }

        br.close();
        bw.close();
    }

    private static boolean isVPS(String ps) {

        Stack<Character> stack = new Stack<>();

        for (char c : ps.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                char pop = stack.pop();
                if (pop != '(') return false;
            } else if (c == ']') {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (pop != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}



