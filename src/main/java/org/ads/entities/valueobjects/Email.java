package org.ads.entities.valueobjects;

import java.util.Objects;
import java.util.function.Supplier;

public final class Email implements Supplier<String> {

    private final String value;

    private Email(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return Objects.equals(value, email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Email{" +
                "value='" + value + '\'' +
                '}';
    }

    public static Email of(String email) {
        Objects.requireNonNull(email, "email is requires");
        return new Email(email);
    }
}
