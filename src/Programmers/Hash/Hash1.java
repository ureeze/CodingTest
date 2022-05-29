package Programmers.Hash;

import java.util.*;

public class Hash1 {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean flag = true;
        int len = phoneBook.length;
        for (int i = 0; i < len - 1; i++) {
            String num = phoneBook[i];
            if (phoneBook[i + 1].startsWith(num)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Hash1 h = new Hash1();
        System.out.println(h.solution(new String[]{"119", "97674223", "1195524421"}));
    }
}