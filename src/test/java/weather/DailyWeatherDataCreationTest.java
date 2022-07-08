package weather;

import static org.junit.Assert.assertEquals;

import com.potyka.weather.DailyWeather;

import org.junit.Test;

public class DailyWeatherDataCreationTest {

  @Test
  public void testCreate() {
    String oneLine = "   1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5";
    DailyWeather dwParsed = new DailyWeather();
    dwParsed.parse(oneLine);
    
    DailyWeather dwOK = new DailyWeather(1, 88, 59);
    
    
    assertEquals(dwOK, dwParsed);
    
  }

}
