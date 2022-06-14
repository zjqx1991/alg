package com.raven.alg.linked;


public class LinkedDemo {
    public static void main(String[] args) {

        SingleLinked singleLinked = new SingleLinked();

        SingleLinked singleLinked1 = new SingleLinked(1);
        SingleLinked singleLinked2 = new SingleLinked(2);
        SingleLinked singleLinked3 = new SingleLinked(3);
        SingleLinked singleLinked4 = new SingleLinked(4);

        singleLinked.add(singleLinked3);
        singleLinked.add(singleLinked2);
        singleLinked.add(singleLinked1);
        singleLinked.add(singleLinked4);

        singleLinked.list();
    }
}
