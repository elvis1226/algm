package org.dgf.other;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Linkage {
    static Logger logger = LoggerFactory.getLogger(Linkage.class);

    static class Link {
        private int start;
        private int end;
        public Link(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    public static boolean isConnected(List<Link> input, int from, int to) {
        boolean result = false;

        Map<Integer, List<Integer>> maps = input.stream().collect(
                Collectors.toMap(Link::getStart,
                                 x -> ImmutableList.of(x.getEnd()),
                                 (x, y) -> Stream.concat(x.stream(), y.stream()).collect(toList())
                                )
        );
        //logger.info("{}",maps);
        Set<Integer> chkSet = maps.get(from).stream().collect(Collectors.toSet());
        while (chkSet != null && chkSet.size() > 0) {
            if (chkSet.contains(to)) {
                result = true;
                break;
            }
            else {
                chkSet = chkSet.stream().map(x-> maps.get(x))
                                        .filter(x -> x!= null)
                                        .flatMap(x-> x.stream())
                                        .collect(Collectors.toSet());
            }
        }
        logger.info("{} -> {} : {}", from, to, result);
        return result;
    }

    public static void main(String[] argv) {
        logger.info("");
        List<Link> items = ImmutableList.of(new Link(1,3), new Link(2,4), new Link(3,6),new Link(3,7),new Link(4, 5), new Link(5, 7), new Link(6,8), new Link(7,9));
        //True
        logger.info("True");
        Linkage.isConnected(items, 1, 8);
        Linkage.isConnected(items, 1, 9);
        Linkage.isConnected(items, 1, 3);
        Linkage.isConnected(items, 1, 7);
        Linkage.isConnected(items, 1, 6);
        Linkage.isConnected(items, 2, 4);
        Linkage.isConnected(items, 2, 5);
        Linkage.isConnected(items, 2, 7);
        Linkage.isConnected(items, 2, 9);
        Linkage.isConnected(items, 4, 9);
        logger.info("False");
        //False
        Linkage.isConnected(items, 1, 5);
        Linkage.isConnected(items, 1, 2);
        Linkage.isConnected(items, 1, 4);
        Linkage.isConnected(items, 2, 6);
        Linkage.isConnected(items, 2, 1);
        Linkage.isConnected(items, 2, 8);
        Linkage.isConnected(items, 3, 5);

    }
}
