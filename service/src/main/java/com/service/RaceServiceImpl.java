package com.service;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Random;
import java.util.Optional;
import com.model.*;

public class RaceServiceImpl implements RaceService {
	private List<Horse> horses;
	private int distanceToBarn = 20;
	private int distanceToGate;
	ArrayList<String> warcries = new ArrayList<String>(Arrays.asList(
			"Giddy up!",
			"Heave Ho!",
			"Eliaaaa!",
			"Alala",
			"Har Har Mahadev",
			"Vetrivel, Veeravel",
			null));

	public List<Horse> getHorses() {
		return horses;
	}

	public void startRace(int distance) {
			horses = horses.parallelStream()
				.filter(e -> e.getHealth() == true)
				.peek(e -> runTo(e, distance))
				.peek(e -> System.out.println(e.getName() + " speeds : "+ e.getSpeedList()))
				.collect(Collectors.toList());
	}

	public void runTo(Horse horse,int distance) {
		horse.setDistanceTraveled(0);
			while(horse.getDistanceTraveled() < distance) {
				int speed = gallop(horse);
				System.out.println(horse.getName() + "\t Speed: " + speed + "\t Distance Traveled: " + horse.getDistanceTraveled() + "\t Distance Left:" + (distance - horse.getDistanceTraveled()) + "\t Total Distance Traveled: " + horse.getTotalDistanceTraveled() );
	}
	System.out.println(horse.getName() + "\t is finished. \t" + horse.getWarcry());
	}

	public int gallop(Horse horse) {
		int speed = horse.getCurrentSpeed();
		horse.setDistanceTraveled(horse.getDistanceTraveled()+speed);
		horse.setTotalDistanceTraveled(horse.getTotalDistanceTraveled()+speed);
		// horse.speedList.add(new Integer(speed));
		return speed;
	}

	public int getHealthyHorsesCount() {
		int healthyHorses = (int) horses.stream()
		.filter(e -> e.getHealth() == true)
		.count();
		return healthyHorses;
	}

	public int generateHorses(int count, ArrayList<String> names) {
		Random r = new Random();
		horses = new ArrayList<Horse>();

		for(int i = 0; i < count; i++){
			horses.add(new Horse(names.get(i), r.nextBoolean(), Optional.ofNullable(warcries.get(r.nextInt(warcries.size()))).orElse("No warcry")));
		}

		System.out.println("healthy Horses");
		horses.stream()
		.filter(e -> e.getHealth() == true)
			.peek(e -> System.out.println(e.getName()))
			.count();

		return horses.size();
	}


}
