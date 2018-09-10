package com.app;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import com.service.RaceServiceImpl;
import com.util.Validate;
import org.apache.commons.lang3.math.NumberUtils;

public class Main {
	public static void main(String[] args) {
		NumberUtils numberUtil = new NumberUtils();
		RaceServiceImpl race = new RaceServiceImpl();
		int healthyHorses=0;
		int count=0;
		int distance=0;
		ArrayList<String> names = new ArrayList<String>();

		do {
			distance = Validate.integerInput("Enter distance to gate: ",1);
			count = Validate.integerInput("Enter number of horses: ", 2);

			for(int i = 0; i < count; i++) {
				names.add(new String(Validate.stringInput("Enter name of horse #"+ (i+1) + ": ")));
			}
			 race.generateHorses(count,names);

		}while(race.getHealthyHorsesCount() < 2);

		System.out.println("Race to barn will start");
		race.startRace(20);
		System.out.println("Race to gate will start");
		race.startRace(distance);
	}


}
