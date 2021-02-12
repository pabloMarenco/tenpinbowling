package com.javachallenge.tenpinbowling.utils.printers;

import com.javachallenge.tenpinbowling.entities.Frame;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class FilePrinterConsole implements FilePrinter {

    @Override
    public void printScoreBoard(Map<String, List<Frame>> playersScores) {
        List<Integer> yourValues = IntStream.range(1, 11)
                .boxed()
                .collect(Collectors.toList());
        System.out.print("Frame             ");
        yourValues.forEach(num -> System.out.print(num+"      "));
        playersScores.forEach((player, listFrames) -> {

            System.out.println("");
            System.out.println(player+"      ");
            System.out.print("Pinfalls      ");
            listFrames.forEach(frame -> System.out.print("  "+frame.getPinfalls()+"      "));
            System.out.println("");
            System.out.print("Score         ");
            listFrames.forEach(frame -> System.out.print("  "+frame.getScore()+"      "));
        });
    }
}
