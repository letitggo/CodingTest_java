import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Set<String> nameSet = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (name.equals("ENTER")) {
                answer += nameSet.size();
                nameSet.clear();
                continue;
            }
            if (!nameSet.contains(name)){
                nameSet.add(name);
            }
        }
        
        answer += nameSet.size();
        System.out.println(answer);
    }
}




