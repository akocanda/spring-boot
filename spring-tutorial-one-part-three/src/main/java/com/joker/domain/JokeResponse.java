package com.joker.domain;

public class JokeResponse {
    private String type;
    private Joke value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Joke getValue() {
        return value;
    }

    public void setValue(Joke joke) {
        this.value = joke;
    }
}
