package org.dgf.other;

import com.google.common.collect.ImmutableList;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SentenceAna{

    public static Map<Character, Integer> getCharSeq(String word) {
        Map<Character, Integer> res = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character cur = word.charAt(i);
            if (res.containsKey(cur)) {
                res.put(cur, res.get(cur) +1);
            }
            else {
                res.put(cur, 1);
            }
        }
        return res;
    }

    public static Map<Map<Character, Integer>, List<String>> getWordAnagram(List<String> wordSet) {

        Map<Map<Character, Integer>, List<String>> charSeqMap = new HashMap<>();

        for (String wd : wordSet) {
            Map<Character, Integer> key = getCharSeq(wd);
            if (!charSeqMap.containsKey(key) ) {
                charSeqMap.put(key, new ArrayList<>());
            }
            charSeqMap.get(key).add(wd);
        }

        Map<Map<Character, Integer>, List<String>> wdAnaMap =
                charSeqMap.entrySet().stream().filter(e -> {
                    if (e.getValue().size() > 1) {
                        System.out.println("size " + e.getValue().size() + ", " +e.getValue());
                        return true;
                    }
                    else return false;
                }
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return wdAnaMap;
    }

    public static long countOneSentence(Map<Map<Character, Integer>, List<String>> wordAnaMap, Set<String> anaWdSet, String sentence) {
        if (sentence.length() <= 0 ) return 0;

        String[] sensArr = sentence.split(" ");
        List<String> senWds = Stream.of(sensArr).filter(w -> anaWdSet.contains(w)).collect(Collectors.toList());
        if (senWds.size() <= 0) {
            System.out.println("no ana on sentence that match with words");
            return 1;
        }


        long res = 1;
        for (String s : senWds) {
            Map<Character, Integer> key = getCharSeq(s);
            int curOpt = wordAnaMap.get(key).size();
            res *= curOpt;
        }

        return res;
    }

    public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {
        List<Long> res = new ArrayList<>();


        Map<Map<Character, Integer>, List<String>> wordAnaMap = getWordAnagram(wordSet);
        Set<String> andWdSet = wordAnaMap.values().stream().flatMap(x->x.stream()).collect(Collectors.toSet());

        System.out.println("andWdSet " + andWdSet);
        for (String sen : sentences) {
            System.out.println("start " + sen);
            long cnt = countOneSentence(wordAnaMap, andWdSet, sen);
            res.add(cnt);
        }
        return res;

    }

    public static void main(String[] argv) {
        List<String> words = ImmutableList.of("the", "our", "rur", "in", "tac", "atc");
        List<String> sens = ImmutableList.of("tac the atc", "in the tac", "atc our in");
        List<Long> rs = countSentences(words, sens);
        rs.stream().forEach(System.out::println);
    }
}
