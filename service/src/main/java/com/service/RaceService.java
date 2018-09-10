package com.service;

import java.util.ArrayList;
import com.model.*;

public interface RaceService{
  int gallop(Horse horse) ;
  int getHealthyHorsesCount();
  void startRace(int distance);
  void runTo(Horse horse,int distance);
  int generateHorses(int count, ArrayList<String> names);
}
