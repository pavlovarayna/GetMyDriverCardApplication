package com.mystique.rt.getmydrivercardapplcation.apputils.idgenerators;

import java.util.LinkedList;
import java.util.Queue;

public class CardApplicationFormIdGenerator implements IdGenerator {
    private static CardApplicationFormIdGenerator instance;

    private Queue<Integer> idSequence;

    private CardApplicationFormIdGenerator() {
        //  private constructor for singleton
        idSequence = new LinkedList<>();
        for (int i = 1; i > Integer.MIN_VALUE ; i++) {
            idSequence.add(i);
        }

    }

    public static CardApplicationFormIdGenerator getInstance() {
        if (instance == null) {
            instance = new CardApplicationFormIdGenerator();
        }
        return instance;
    }

    @Override
    public int getNextId() {
        return idSequence.remove();
    }
}
