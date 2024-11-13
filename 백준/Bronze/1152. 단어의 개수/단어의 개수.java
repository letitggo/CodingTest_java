import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> strList = new ArrayList<>();

        String str = br.readLine().trim();

        if(!str.isEmpty()){
            strList.addAll(Arrays.asList(str.split(" ")));
            bw.write(strList.size() + "\n");
        }else {
            bw.write(0 + "\n");
        }




        br.close();
        bw.close();
    }
}