package com.javachallenge.tenpinbowling.utils.validators;

import com.javachallenge.tenpinbowling.entities.Frame;
import com.javachallenge.tenpinbowling.entities.Pinfalls;
import org.javatuples.Pair;

import java.util.List;
import java.util.Map;

public interface GameValidator {
    public Pair<Boolean, Map<String, List<Pinfalls>>> validateGame(List<String> inputFile);
}
