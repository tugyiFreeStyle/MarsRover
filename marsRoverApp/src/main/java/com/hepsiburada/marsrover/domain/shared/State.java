package com.hepsiburada.marsrover.domain.shared;

public abstract class State<T> {

    public class Result {
        private T current;

        public Result(T current) {
            this.current = current;
        }
        public T getCurrent() {
            return current;
        }
    }

    protected Result toResult(T state) {
        return new Result(state);
    }
}
