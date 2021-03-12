package org.dgf.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CharacterAndDocument {
    public Map<Character, Integer> buildMap(String input) {
        Map<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i) ;
            if (result.containsKey(c)) {
                result.put(c, result.get(c) + 1);
            }
            else {
                result.put(c, 1);
            }
        }

        return result;
    }

    public boolean generateDocument(String characters, String document) {
        // Write your code here.
        Map<Character, Integer> charMap = buildMap(characters);
        Map<Character, Integer> docMap = buildMap(document);

        for(Map.Entry<Character, Integer> chs : docMap.entrySet()) {
            if (!charMap.containsKey(chs.getKey())){
                return false;
            }
            else {
                if (chs.getValue() > charMap.get(chs.getKey())) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean generateDocument2(String characters, String document) {
        char[] chars = characters.toCharArray();
        char[] docs = document.toCharArray();

        Arrays.sort(chars);
        Arrays.sort(docs);

        int i = 0, j = 0;
        while  (i < docs.length && j < chars.length) {
            if (docs[i] == chars[j]) {
                i++;
                j++;
                continue;
            }

            while (j < chars.length && docs[i] != chars[j]) {
                j++;
            }
        }

        if (i < docs.length && j >= chars.length) {
            return false;
        }

        return true;
    }

    
}
