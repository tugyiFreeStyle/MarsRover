package com.hepsiburada.marsrover.domain;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class RoverId {
    private String value;

    public static RoverId generate() {
        return new RoverId(UUID.randomUUID().toString());
    }
}
