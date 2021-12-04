package org.dgf.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    public static void main(String[] argv) {
        Map<String, List<String>> map = new HashMap<>();
        map.putIfAbsent("abc", new ArrayList<>()).add("124");
    }
}
