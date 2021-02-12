package com.javachallenge.tenpinbowling.utils.builders;

import com.javachallenge.tenpinbowling.entities.Frame;
import com.javachallenge.tenpinbowling.entities.Pinfalls;

public class FrameBuilder {
    public static Frame newFrame(int frame, int score, Pinfalls pinfalls) {
        return new Frame(frame, score, pinfalls);
    }
}
