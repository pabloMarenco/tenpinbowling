package com.javachallenge.tenpinbowling.utils.validators;

import com.javachallenge.tenpinbowling.utils.builders.PinfallsBuilder;
import com.javachallenge.tenpinbowling.entities.Pinfalls;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
@Qualifier("GameValidatorStrict")
public class GameValidatorStrict implements GameValidator{

    @Override
    public Pair<Boolean, Map<String, List<Pinfalls>>> validateGame(List<String> inputFile) {
        AtomicReference<Boolean> validFlag = new AtomicReference<>(true);
        Map<String, List<Pinfalls>> resultMapPlayer = new HashMap<String, List<Pinfalls>>();
        List<Pair<String, String>> pairOfvaluesPlayer = inputFile.stream()
                .map(b -> new Pair<String, String>(b.split(" ")[0], b.split(" ")[1])).collect(Collectors.toList());

        Map<String, List<String>> mapPlayers = pairOfvaluesPlayer.stream()
                .collect(Collectors.groupingBy(l->l.getValue(0).toString(),
                        Collectors.mapping(l1->l1.getValue(1).toString(),Collectors.toList())));

        mapPlayers.forEach((key,stringValuePins) -> {
            List<Pinfalls> pinfallsList = new ArrayList<>();
            List<String> lastBalls = new ArrayList<>();
            for(int i= 0; pinfallsList.size()<9;i++){
                if(stringValuePins.get(i).equals("10")){
                    pinfallsList.add(PinfallsBuilder.newStrike());
                } else {
                    pinfallsList.add(PinfallsBuilder.normalFrame(stringValuePins.get(i),stringValuePins.get(i+1)));
                    i++;
                }
                lastBalls = stringValuePins.subList(i+1,stringValuePins.size());
            }
            pinfallsList.add(PinfallsBuilder.lastFrame(lastBalls.get(0),lastBalls.get(1),lastBalls.get(2)));

            resultMapPlayer.put(key,pinfallsList);
        });

        return new Pair<Boolean, Map<String, List<Pinfalls>>>(Boolean.TRUE, resultMapPlayer);
    }
}
