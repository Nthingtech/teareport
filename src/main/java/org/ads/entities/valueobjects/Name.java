package org.ads.entities.valueobjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public final class Name implements Supplier<String> {

    private final List<String> firstNames;
    private final List<String> lastNames;

    private Name(List<String> firstNames, List<String> lastNames) {
        if (firstNames == null || firstNames.isEmpty()){
            throw new IllegalArgumentException("Não pode haver nomes vazios.");
        }
        if (lastNames == null || lastNames.isEmpty()) {
            throw new IllegalArgumentException("Não pode haver sobrenomes vazios.");
        }
        this.firstNames = new ArrayList<>(firstNames);
        this.lastNames = new ArrayList<>(lastNames);
    }

    @Override
    public String get() {
        StringBuilder sb = new StringBuilder();
            for (String firstname : firstNames) {
                sb.append(firstname).append(" ");
        }
        for (String lastname : lastNames) {
            sb.append(lastname).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return Objects.equals(firstNames, name.firstNames) && Objects.equals(lastNames, name.lastNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNames, lastNames);
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstNames=" + firstNames +
                ", lastnames=" + lastNames +
                '}';
    }

    public static Name of(List<String> firstNames, List<String> lastNames) {
        Objects.requireNonNull(firstNames, "Name is required");
        Objects.requireNonNull(lastNames, "Last Name is required");
        return new Name(firstNames, lastNames);
    }
}
