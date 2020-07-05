package com.hepsiburada.marsrover.domain;

import lombok.Getter;

@Getter
public class Y {
    private int value;

    public Y(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.valueOf(value));
        }
        this.value = value;
    }
}
