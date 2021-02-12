package com.javachallenge.tenpinbowling.utils.builders;

import com.javachallenge.tenpinbowling.entities.Pinfalls;

public class PinfallsBuilder {

    static final String STRIKE = "X";
    static final String SPARE = "/";

    public static Pinfalls normalFrame(String ball1, String ball2){
        int numball1;
        int numball2;
        try {
            numball1 = Integer.parseInt(ball1);
        }
        catch (NumberFormatException e)
        {
            numball1 = 0;
        }

        try {
            numball2 = Integer.parseInt(ball2);
        }
        catch (NumberFormatException e)
        {
            numball2 = 0;
        }

        if(numball1+numball2==10) {
            return new Pinfalls(Integer.toString(numball1), SPARE);
        } else {
            return new Pinfalls(ball1, ball2);
        }
    }

    public static Pinfalls lastFrame(String ball1, String ball2, String ball3){
        int numball1;
        int numball2;
        int numball3;
        try {
            numball1 = Integer.parseInt(ball1);
        }
        catch (NumberFormatException e)
        {
            numball1 = 0;
        }

        try {
            numball2 = Integer.parseInt(ball2);
        }
        catch (NumberFormatException e)
        {
            numball2 = 0;
        }

        try {
            numball3 = Integer.parseInt(ball3);
        }
        catch (NumberFormatException e)
        {
            numball3 = 0;
        }

        return new Pinfalls( (numball1==10?STRIKE:Integer.toString(numball1)),
                (numball1+numball2==10?SPARE:Integer.toString(numball2)),
                (numball3==10?STRIKE:Integer.toString(numball3)));
    }

    public static Pinfalls newStrike() {
        return new Pinfalls(STRIKE);
    }
}
