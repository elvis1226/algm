package org.dgf.string;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatChar {
    public int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        if (string.length() <= 0) return -1;

        Map<Character, Integer> scan = new HashMap<>();
        for (int i = 0 ; i < string.length(); i++){
            char key = string.charAt(i);
            if(scan.containsKey(key)) {
                scan.put(key, scan.get(key)+1);
                continue;
            }
            scan.put(key, 1);
        }

        for (int i = 0; i < string.length();i++) {
            if (scan.get(string.charAt(i)) < 2) {
                return i;
            }
        }
        return -1;
    }
}
