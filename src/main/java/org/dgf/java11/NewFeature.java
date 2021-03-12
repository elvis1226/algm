package org.dgf.java11;

public class NewFeature {
    public static void newFeatureForString() {

        String s1 = "dfdkfdjfg";
        s1.isBlank();

        String s2 = "hello\nworld";
        s2.lines().forEach(System.out::println);
    }

    public static void main(String[] argvs) {
        newFeatureForString();
    }
}
