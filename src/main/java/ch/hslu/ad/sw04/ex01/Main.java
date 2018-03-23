package ch.hslu.ad.sw04.ex01;

import ch.hslu.ad.sw04.ex01.HashSet;

public class Main {
    public static void main(String[] args) {


        HashSet hs = new HashSet(5);
        hs.add(1);
        System.out.println(hs.toString());
        hs.add(2);
        System.out.println(hs.toString());
        hs.add(2002);
        System.out.println(hs.toString());
        hs.add(3);
        System.out.println(hs.toString());
        hs.add(4);
        System.out.println(hs.toString());
        hs.remove(2);
        System.out.println(hs.toString());
        System.out.println(hs.add(2002));
        System.out.println(hs.toString());
    }
}
