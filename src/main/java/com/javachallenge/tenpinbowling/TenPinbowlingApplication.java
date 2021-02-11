package com.javachallenge.tenpinbowling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.io.IOException;

@SpringBootApplication
public class TenPinbowlingApplication {

	public static void main(String[] args) throws IOException {
		ApplicationContext applicationContext = SpringApplication.run(TenPinbowlingApplication.class, args);
		BowlingMachineService bowlingMachineService = applicationContext.getBean(BowlingMachineService.class);
		bowlingMachineService.run();
	}

}
