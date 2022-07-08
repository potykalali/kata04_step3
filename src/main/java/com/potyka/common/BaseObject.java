package com.potyka.common;

/**
 * T lesz az, ami az adott implementáló osztály esetében kérdéses volt: DailyWeather-nél a nap sorszáma, Team-nél a csapat neve. 
 * G lesz az interface-t implementáló osztály.
 * */
public interface BaseObject<G, T> extends Comparable<G> {
  
  public T getIdentifier();
  
  public void parse(String oneLine);
  
  public int compareTo(G otherObject);
  
}
