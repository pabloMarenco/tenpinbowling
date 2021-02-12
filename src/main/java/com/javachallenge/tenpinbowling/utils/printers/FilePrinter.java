package com.javachallenge.tenpinbowling.utils.printers;

import com.javachallenge.tenpinbowling.entities.Frame;

import java.util.List;
import java.util.Map;

public interface FilePrinter {
    public void printScoreBoard(Map<String, List<Frame>> playersScores);
}
