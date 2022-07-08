package com.potyka.weather;

import com.potyka.common.CommonContainerForBaseObject;

/**
 * Az <Integer> arra utal, hogy egész típus lesz a keresett adat: a legkisebb hőmérsékletkülönbségű nap sorszáma
 * */
public class MonthlyWeather extends CommonContainerForBaseObject<DailyWeather, Integer> {

  public Integer getDayIdWithSmallestTempretureSpread() {
    return super.getDataInDemand();
  }
  
  @Override
  protected DailyWeather createInstanceOfBaseObject() {
    return new DailyWeather();
  }

}
