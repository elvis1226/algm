package org.dgf.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordMatch {
    private final static Logger logger = LoggerFactory.getLogger(WordMatch.class);
    /*
After catching your classroom students cheating before, you realize your students are getting craftier and hiding words in 2D grids of letters.
The word may start anywhere in the grid, and consecutive letters can be either immediately below or immediately to the right of the previous letter.

Given a grid and a word, write a function that returns the location of the word in the grid as a list of coordinates. If there are multiple matches, return any one.

grid1 = [
	['c', 'c', 'x', 't', 'i', 'b'],
	['c', 'c', 'a', 't', 'n', 'i'],
	['a', 'c', 'n', 'n', 't', 't'],
	['t', 'c', 's', 'i', 'p', 't'],
	['a', 'o', 'o', 'o', 'a', 'a'],
	['o', 'a', 'a', 'a', 'o', 'o'],
	['k', 'a', 'i', 'c', 'k', 'i'],
]
word1 = "catnip"
word2 = "cccc"
word3 = "s"
word4 = "bit"
word5 = "aoi"
word6 = "ki"
word7 = "aaa"
word8 = "ooo"

grid2 = [['a']]
word9 = "a"

find_word_location(grid1, word1) => [ (1, 1), (1, 2), (1, 3), (2, 3), (3, 3), (3, 4) ]
find_word_location(grid1, word2) =>
       [(0, 1), (1, 1), (2, 1), (3, 1)]
    OR [(0, 0), (1, 0), (1, 1), (2, 1)]
    OR [(0, 0), (0, 1), (1, 1), (2, 1)]
    OR [(1, 0), (1, 1), (2, 1), (3, 1)]
find_word_location(grid1, word3) => [(3, 2)]
find_word_location(grid1, word4) => [(0, 5), (1, 5), (2, 5)]
find_word_location(grid1, word5) => [(4, 5), (5, 5), (6, 5)]
find_word_location(grid1, word6) => [(6, 4), (6, 5)]
find_word_location(grid1, word7) => [(5, 1), (5, 2), (5, 3)]
find_word_location(grid1, word8) => [(4, 1), (4, 2), (4, 3)]
find_word_location(grid2, word9) => [(0, 0)]

Complexity analysis variables:

r = number of rows
c = number of columns
w = length of the word


*/


        public static boolean check_point(char[][] grid, int rowIdx, int colIdx, String word, List<List<Integer>> result ) {
            if (word.isEmpty()) {
                return true;
            }
            if (rowIdx >= grid.length || colIdx >= grid[0].length) {
                return false;
            }

            char curChar = word.charAt(0);
            if(grid[rowIdx][colIdx] == curChar) {
                List<Integer> curPoint = new ArrayList<>();
                String remainig = word.substring(1);

                curPoint.add(rowIdx);
                curPoint.add(colIdx);
                result.add(curPoint);

                boolean right = check_point(grid, rowIdx, colIdx+1, remainig, result);
                if (right) {
                    return true;
                }

                boolean down = check_point(grid, rowIdx+1, colIdx, remainig, result);
                if(down) {
                    return true;
                }
                result.remove(result.size()-1);
            }

            return false;
        }
        public static List<List<Integer>> find_word_location(char[][] grid, String word) {
            List<List<Integer>> result = new ArrayList<>();


            for (int i = 0 ; i < grid.length; i ++) {
                for (int j = 0; j < grid[0].length; j++) {

                    boolean matched = check_point(grid, i, j, word, result);
                    if (matched) {
                         return result;
                    }

                }
            }


            return result;
        }

        public static void main(String[] argv) {
            char[][] grid1 = {
                    {'c', 'c', 'x', 't', 'i', 'b'},
                    {'c', 'c', 'a', 't', 'n', 'i'},
                    {'a', 'c', 'n', 'n', 't', 't'},
                    {'t', 'c', 's', 'i', 'p', 't'},
                    {'a', 'o', 'o', 'o', 'a', 'a'},
                    {'o', 'a', 'a', 'a', 'o', 'o'},
                    {'k', 'a', 'i', 'c', 'k', 'i'}
            };
            String word1 = "catnip";
            String word2 = "cccc";
            String word3 = "s";
            String word4 = "bit";
            String word5 = "aoi";
            String word6 = "ki";
            String word7 = "aaa";
            String word8 = "ooo";

            char[][] grid2 = {{'a'}};
            String word9 = "a";

            logger.info("{}",find_word_location(grid1,word1));
            logger.info("{}",find_word_location(grid1,word2));
            logger.info("{}",find_word_location(grid1,word3));
            logger.info("{}",find_word_location(grid1,word4));
            logger.info("{}",find_word_location(grid1,word5));
            logger.info("{}",find_word_location(grid1,word6));
            logger.info("{}",find_word_location(grid1,word7));
            logger.info("{}",find_word_location(grid1,word8));
            logger.info("{}",find_word_location(grid2,word9));
            logger.info("done");
        }


        public static Map<Character, Integer> buildCnt(String input) {
            Map<Character, Integer> result = new HashMap<>();

            for (Character c : input.toCharArray()) {
                if (result.containsKey(c)) {
                    result.computeIfPresent(c, (k, o)-> o+1);
                }
                else {
                    result.put(c, 1);
                }
            }
            return result;
        }


        public static String find_embedded_word(String[] words, String input)
        {
            String result = null;
            List<Map<Character, Integer>> wordCntList = new ArrayList<>();//W
            Map<Map<Character, Integer>, String> revertMap = new HashMap<>();//W

            //O(W*S)
            for (String word : words){
                Map<Character, Integer> wdMap = buildCnt(word);
                wordCntList.add(wdMap);
                revertMap.put(wdMap, word);
            }


            Map<Character, Integer> inputCntMap = buildCnt(input);

            Map<Character, Integer> matchedMap = null;

            //O(W*S)
            for (Map<Character, Integer> curMap : wordCntList) {
                boolean matched = true;

                for (Character key: curMap.keySet()) {
                    int keyCnt = curMap.get(key);
                    if (!inputCntMap.containsKey(key)) {
                        matched = false;
                        break;
                    }
                    int inputCnt = inputCntMap.get(key);
                    if( keyCnt > inputCnt){
                        matched = false;
                        break;
                    }
                }

                if (matched) {
                    matchedMap = curMap;
                }
            }

            if (matchedMap == null) {
                return null;
            }
            else{
                return revertMap.get(matchedMap);
            }
        }



}
