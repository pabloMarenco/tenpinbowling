package com.javachallenge.tenpinbowling.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PinfallsTest {

    private Pinfalls pinfallsStrike;
    private Pinfalls pinfallsSpare;
    private Pinfalls pinfallsLastFrame;

    @BeforeEach
    public void setUp(){
        pinfallsStrike = new Pinfalls("X");
        pinfallsSpare = new Pinfalls("7","/");
        pinfallsLastFrame = new Pinfalls("X","8","2");
    }

    @Test
    @DisplayName("Ensure to get the first ball of the Pinfall object")
    void getIntBall1() {
        assertEquals(10, pinfallsLastFrame.getIntBall1(), "Value 10 obtained from a strike");
    }

    @Test
    @DisplayName("Ensure to get the second ball of the Pinfall object")
    void getIntBall2() {
        assertEquals(8, pinfallsLastFrame.getIntBall2(), "Value 10 obtained from an 8 pin hit");
    }

    @Test
    @DisplayName("Ensure to get the third ball of the Pinfall object")
    void getIntBall3() {
        assertEquals(2, pinfallsLastFrame.getIntBall3(), "Value 10 obtained from an 8 pin hit");
    }

    @Test
    void isStrike() {
        assertEquals(Boolean.TRUE, pinfallsStrike.isStrike(), "True value obtained from an strike Pinfall");
    }

    @Test
    void isSpare() {
        assertEquals(Boolean.TRUE, pinfallsSpare.isSpare(), "True value obtained from an spare Pinfall");
    }
}