package net.chilly.mistbornmod.entity;

import java.util.Arrays;
import java.util.Comparator;

public enum KolossAgeState {
    YOUNG(0),
    MIDDLE(1),
    OLD(2),
    VERY_OLD(3);


    private static final KolossAgeState[] BY_ID = Arrays.stream(values()).sorted(
            Comparator.comparingInt(KolossAgeState::getId)).toArray(KolossAgeState[]::new);
    private final int id;

    KolossAgeState(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static KolossAgeState byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
