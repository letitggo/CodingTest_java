import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        Set<String> set = new HashSet<>();

        for (String s : phone_book) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append(s.charAt(i));
                if (set.contains(sb.toString())) {
                    return false;
                }
            }
            set.add(s);
        }

        return true;
    }
}