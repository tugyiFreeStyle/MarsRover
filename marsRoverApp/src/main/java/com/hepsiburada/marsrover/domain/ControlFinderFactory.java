package com.hepsiburada.marsrover.domain;

import com.hepsiburada.marsrover.domain.controls.left.LeftControlFinder;
import com.hepsiburada.marsrover.domain.controls.move.MoveControlFinder;
import com.hepsiburada.marsrover.domain.controls.right.RightControlFinder;
import com.hepsiburada.marsrover.domain.shared.ControlFinder;
import com.hepsiburada.marsrover.domain.shared.ControlType;

public class ControlFinderFactory {
    private ControlFinderFactory() {
    }

    public static ControlFinder get(ControlType type) {
        switch (type) {
            case L:
                return new LeftControlFinder();

            case R:
                return new RightControlFinder();

            default:
                return new MoveControlFinder();
        }
    }
}