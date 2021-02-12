package com.javachallenge.tenpinbowling.entities;

import lombok.Value;

@Value
public class Frame {
    private int frame;
    private int score;
    private Pinfalls pinfalls;
}
