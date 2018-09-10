package com.service;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import org.junit.Test;
import org.junit.Before;
import com.model.*;

public class RaceServiceTest{

  @InjectMocks
  RaceServiceImpl race = new RaceServiceImpl();

  @Mock
  private Horse horseMock;

  @Before
  public void setup() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGenerateHorsesIsFilled() {
      ArrayList<String> names = new ArrayList<String>();
      names.add("sample");
      int size = race.generateHorses(1,names);
      assertEquals("Failure - horse size != 1", 1,size);
  }


  @Test
  public void testGenerateHorsesNameToUpperCase() {
      ArrayList<String> names = new ArrayList<String>();
      names.add("sample");
      race.generateHorses(1,names);
      race.getHorses().get(0).setHealth(true);
      assertEquals("Failure - horse name is not capitalized", "SAMPLE",race.getHorses().get(0).getName());
  }

  @Test
  public void testGenerateHorsesNameNormalIfUnhealthy() {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Sample");
    race.generateHorses(1,names);
    race.getHorses().get(0).setHealth(false);
    assertEquals("Failure - horse name is not capitalized", "Sample",race.getHorses().get(0).getName());
  }

  @Test
  public void testGetHealthyHorsesCountEqualToZero(){
    ArrayList<String> names = new ArrayList<String>();
    names.add("Sample");
    race.generateHorses(1,names);
    race.getHorses().get(0).setHealth(false);
    assertEquals("Failure - healthy horse count not equal to zero", 0,race.getHealthyHorsesCount());
  }

  @Test
  public void testGetHealthyHorsesCountEqualToOne(){
    ArrayList<String> names = new ArrayList<String>();
    names.add("Sample");
    race.generateHorses(1,names);
    race.getHorses().get(0).setHealth(true);
    assertEquals("Failure - healthy horse count not equal to one", 1,race.getHealthyHorsesCount());
  }

  @Test
  public void testRunToMustBeGreaterThanOrEqualToDistance() {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Sample");
    race.generateHorses(1,names);
    Horse horse1 = race.getHorses().get(0);
    race.runTo(horse1,50);
    assertTrue("mustBeGreaterthan50",horse1.getDistanceTraveled()>= 50);
  }

  @Test
  public void testRunToMock() {
    when(horseMock.getCurrentSpeed()).thenReturn(5);
    assertEquals("Speed = 5",5,race.gallop(horseMock));
  }

  @Test
  public void testStartRaceVerify() {
    ArrayList<String> names = new ArrayList<String>();
    names.add("Sample");
    names.add("Sample2");
    race.generateHorses(2,names);
    race.getHorses().get(0).setHealth(true);
    race.getHorses().get(1).setHealth(false);
    race.startRace(50);
    assertEquals("Size must be equal to 1",1,race.getHorses().size());
  }

}
