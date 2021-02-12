package com.javachallenge.tenpinbowling.services;

import com.javachallenge.tenpinbowling.utils.builders.FrameBuilder;
import com.javachallenge.tenpinbowling.entities.Frame;
import com.javachallenge.tenpinbowling.entities.Pinfalls;
import com.javachallenge.tenpinbowling.utils.filereader.FileReader;
import com.javachallenge.tenpinbowling.utils.printers.FilePrinter;
import com.javachallenge.tenpinbowling.utils.validators.GameValidator;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BowlingMachineService {

    @Autowired
    @Qualifier("FileReaderScanner")
    FileReader fileReader;

    @Autowired
    @Qualifier("GameValidatorStrict")
    GameValidator gameValidatorStrict;

    @Autowired
    FilePrinter filePrinter;

    public void run(String[] args) {
        String filePath = args[0].toString();

        List<String> scores = fileReader.readLines(filePath);
        Pair<Boolean, Map<String, List<Pinfalls>>> playersPoints = gameValidatorStrict.validateGame(scores);
        if(playersPoints.getValue0()){
            filePrinter.printScoreBoard(calculateGame(playersPoints.getValue1()));
        }
    }

    private Map<String, List<Frame>> calculateGame(Map<String, List<Pinfalls>> playersPoints){
        Map<String, List<Frame>> resultMapPlayer = new HashMap<String, List<Frame>>();

        playersPoints.forEach((key ,value) -> {
            List<Frame> listFrames = new ArrayList<Frame>();

            for(int i=0;i<value.size();i++){
                if(i==0){
                    listFrames.add(FrameBuilder.newFrame(i+1, calculateScore(0,
                            value.subList(i,value.size())), value.get(i)));
                } else {
                    listFrames.add(FrameBuilder.newFrame(i + 1, calculateScore(listFrames.get(i - 1).getScore(),
                            value.subList(i, value.size())), value.get(i)));
                }
            }
            resultMapPlayer.put(key, listFrames);
        });
        return resultMapPlayer;
    }

    private int calculateScore(int lastScore, List<Pinfalls> listPinfalls){
        if(listPinfalls.size()==1){
            int value1 = listPinfalls.get(0).getIntBall1();
            int value2 = listPinfalls.get(0).getIntBall2();
            int value3 = listPinfalls.get(0).getIntBall3();
            return lastScore+value1+value2+value3;
        }

        if(listPinfalls.size()==2){
            if(listPinfalls.get(0).isStrike()){
                return lastScore + 10 + listPinfalls.get(1).getIntBall1() + listPinfalls.get(1).getIntBall2();
            }
        }


        if(listPinfalls.size()>2){
            if ((listPinfalls.get(0).isStrike()) && (listPinfalls.get(1).isStrike()) && (listPinfalls.get(2).isStrike())) {
                return lastScore + 30;
            }
        }

        if((listPinfalls.get(0).isStrike())&&(listPinfalls.get(1).isStrike())){
            return lastScore+20+listPinfalls.get(2).getIntBall1();
        }

        if((listPinfalls.get(0).isStrike())&&(listPinfalls.get(1).isSpare())){
            return lastScore+20;
        }

        if((listPinfalls.get(0).isStrike())){
            return lastScore+10+listPinfalls.get(1).getIntBall1()+listPinfalls.get(1).getIntBall2();
        }

        if((listPinfalls.get(0).isSpare())){
            return lastScore+10+listPinfalls.get(1).getIntBall1();
        }

        return lastScore+listPinfalls.get(0).getIntBall1()+listPinfalls.get(0).getIntBall2();
    }
}
