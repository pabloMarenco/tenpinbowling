package com.javachallenge.tenpinbowling;

import com.javachallenge.tenpinbowling.filereader.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BowlingMachineService {

    @Autowired
    @Qualifier("FileReaderScanner")
    FileReader fileReader;

    public void run() {
        List<String> scores = fileReader.readLines();
        System.out.println(scores);
    }
}
