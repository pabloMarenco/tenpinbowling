package com.javachallenge.tenpinbowling.utils.filereader;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
@Qualifier("FileReaderScanner")
public class FileReaderTxt implements FileReader {

    private static String GAME_POINTS= "src/main/resources/game.txt";

    public final List<String> readLines(){
        List<String> result = new ArrayList<>();
        Scanner inFile1 = null;
        try {
            inFile1 = new Scanner(new File(GAME_POINTS)).useDelimiter(",\\s*");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (inFile1.hasNext()) {
            result.add(inFile1.nextLine());
        }

        return result;
    }
}
