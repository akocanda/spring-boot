package com.oreilly.demo.domain;

import java.util.Objects;

public class Greeting {
    public Greeting (String inputGreeting) {
        this.greeting = inputGreeting;
    }

    public Greeting() { }

    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Greeting)) return false;
        Greeting gr = (Greeting) o;
        return Objects.equals(greeting, gr.greeting);
    }

    @Override
    public int hashCode() {
        return Objects.hash(greeting);
    }

    @Override
    public String toString() {
        return greeting;
    }
}
