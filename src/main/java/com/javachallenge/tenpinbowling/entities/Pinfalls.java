package com.javachallenge.tenpinbowling.entities;

import lombok.Value;

@Value
public class Pinfalls {

    private String ball1;

    private String ball2;

    private String ball3;

    public Pinfalls(String ball2) {
        this.ball1 = null;
        this.ball2 = ball2;
        this.ball3 = null;
    }

    public int getIntBall1() {

        int numball1;
        try {
            numball1 = Integer.parseInt(ball1);
        }
        catch (NumberFormatException e)
        {
            if(ball1=="F"){
                return 0;
            }

            if(ball1=="X"){
                return 10;
            }

            return 0;
        }
        return numball1;
    }

    public int getIntBall2() {
        if (ball2 != null) {
            if (ball2 == "/") {
                return Integer.parseInt(ball2);
            }
            if (ball2 == "X") {
                return 10;
            }
            return Integer.parseInt(ball2);
        }
        return 0;
    }

    public int getIntBall3(){
        if (ball3 != null) {
            if (ball3 == "/") {
                return Integer.parseInt(ball3);
            }
            if (ball3 == "X") {
                return 10;
            }
            return Integer.parseInt(ball3);
        }
        return 0;
    }

    public Pinfalls(String ball1, String ball2) {
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = null;
    }

    public Pinfalls(String ball1, String ball2, String ball3) {
        this.ball1 = ball1;
        this.ball2 = ball2;
        this.ball3 = ball3;
    }

    public Boolean isStrike(){
        if(ball1==null||ball1=="X"){
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public Boolean isSpare(){
        if(ball2=="/"){
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Override
    public String toString() {
        return  (ball1==null ? "" :ball1) + " " + (ball2==null ? "" :ball2) + " " + (ball3==null ? "" :ball3);
    }
}
