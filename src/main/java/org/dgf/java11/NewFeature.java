package org.dgf.java11;

import java.util.function.Function;

public class NewFeature {
    public static void newFeatureForString() {

        String s1 = "dfdkfdjfg";
        s1.isBlank();

        String s2 = "hello\nworld";
        s2.lines().forEach(System.out::println);

        String s3 = "  aaaa  abbbb  ";
        s3.strip();
        s3.stripLeading();
        s3.stripTrailing();

        String s4 = "=".repeat(10);
    }

    public static void newFeatureForLocalVar() {

        Function<Integer, Integer> f = (var x) -> x.intValue();
    }

    public static void main(String[] argvs) {
        newFeatureForString();
    }
}
