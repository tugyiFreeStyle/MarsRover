package com.hepsiburada.marsrover.domain.shared;


public interface Strategy<T> {

    T find(T data);
}
