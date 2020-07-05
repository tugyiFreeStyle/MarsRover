package com.hepsiburada.marsrover.domain;

import lombok.Getter;

@Getter
public class X {
    private int value;

    public X(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(String.valueOf(value));
        }
        this.value = value;
    }
}
