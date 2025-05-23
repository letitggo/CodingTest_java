import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);
        Set<String> set = new HashSet<>();

        for (String s : phone_book) {
            for (int i = 1; i <= s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    return false;
                }
            }
            set.add(s);
        }

        return true;
    }
}