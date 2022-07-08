package com.potyka;

import com.potyka.football.FootballLeague;
import com.potyka.weather.MonthlyWeather;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * @author horakb
 */
public class DataAnalyzerMain {

  private static final Logger logger = Logger.getLogger(DataAnalyzerMain.class);

  public static final File weatherDataFile = new File("e:\\_SRC\\git\\kata04_step3\\target\\classes\\weather.dat");

  public static final File footballDataFile = new File("e:\\_SRC\\git\\kata04_step3\\target\\classes\\football.dat");

  public static void main(String[] args) {
    
    MonthlyWeather mw = new MonthlyWeather();
    mw.loadFromFile(weatherDataFile);
    logger.info("Ezen a napon volt a legkisebb a hőmérsékletkülönbség: " + mw.getDayIdWithSmallestTempretureSpread());

    FootballLeague league = new FootballLeague();
    league.loadFromFile(footballDataFile);
    logger.info("Ennek a csapatnak volt a legkisebb a gólkülönbsége: " + league.getTeamNameWithSmallestGoalDifference());
    
    
  }

}
