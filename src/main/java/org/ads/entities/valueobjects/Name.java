package org.ads.entities.valueobjects;

import java.util.List;
import java.util.function.Supplier;

public final class Name implements Supplier<String> {

    private final List<String> firstNames;
    private final List<String> Lostnames;

    @Override
    public String get() {
        return null;
    }
}
