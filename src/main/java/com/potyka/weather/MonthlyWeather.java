package com.potyka.weather;

import com.potyka.common.BaseObject;
import com.potyka.common.CommonContainerForBaseObject;

/**
 * Az <Integer> arra utal, hogy egész típus lesz a keresett adat: a legkisebb hőmérsékletkülönbségű nap sorszáma
 * */
public class MonthlyWeather extends CommonContainerForBaseObject<Integer> {

  public Integer getDayIdWithSmallestTempretureSpread() {
    return super.getDataInDemand();
  }
  
  @Override
  protected BaseObject createInstanceOfBaseObject() {
    return new DailyWeather();
  }

}
