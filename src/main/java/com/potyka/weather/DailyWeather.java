package com.potyka.weather;

import com.potyka.common.BaseObject;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Valójában nem DailyWeather, hanem DailyWeatherDATA lenne a helyes, hiszen nem az idő az objektum, hanem a napi adatok.
 * */
public class DailyWeather implements BaseObject<DailyWeather, Integer> {

  private static final Logger logger = Logger.getLogger(DailyWeather.class);

  // Dy MxT MnT AvT HDDay AvDP 1HrP TPcpn WxType PDir AvSp Dir MxS SkyC MxR MnR AvSLP

  private int dayNumber;

  private int maxTemperature;

  private int minTemperature;

  public DailyWeather() {
  }
  
  public DailyWeather(int dayNumber, int maxTemperature, int minTemperature) {
    super();
    this.dayNumber = dayNumber;
    this.maxTemperature = maxTemperature;
    this.minTemperature = minTemperature;
  }

  @Override
  public void parse(String oneDataRow) {
    try {

      List<String> splittedDataRow = Arrays.asList(oneDataRow.trim().replace("*", "").replaceAll(" +", " ").split(" "));
      dayNumber = Integer.valueOf(splittedDataRow.get(0));
      maxTemperature = Integer.valueOf(splittedDataRow.get(1));
      minTemperature = Integer.valueOf(splittedDataRow.get(2));
      logger.debug(splittedDataRow);

    } catch (Exception e) {
      logger.error("Nem sikerült a sor feldolgozása: " + oneDataRow, e);
    }
  }

  @Override
  public Integer getIdentifier() {
    return this.dayNumber;
  }
  
  @Override
  public String toString() {
    return "DailyWeather [dayNumber=" + dayNumber + ", maxTemperature=" + maxTemperature + ", minTemperature=" + minTemperature + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + dayNumber;
    result = prime * result + maxTemperature;
    result = prime * result + minTemperature;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    DailyWeather other = (DailyWeather) obj;
    if (dayNumber != other.dayNumber)
      return false;
    if (maxTemperature != other.maxTemperature)
      return false;
    if (minTemperature != other.minTemperature)
      return false;
    return true;
  }

  @Override
  public int compareTo(DailyWeather otherDailyWeather) {
    return this.getTemperatureSpread() - otherDailyWeather.getTemperatureSpread();
  }

  private int getTemperatureSpread() {
    return maxTemperature - minTemperature;
  }

}
