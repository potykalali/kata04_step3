package com.potyka.football;

import com.potyka.common.CommonContainerForBaseObject;

/**
 * A <String> arra utal, hogy String lesz a keresett adat: a csapat neve.  
 * */
public class FootballLeague extends CommonContainerForBaseObject<Team, String> {

  public String getTeamNameWithSmallestGoalDifference() {
    return super.getDataInDemand();
  }
  
  @Override
  protected Team createInstanceOfBaseObject() {
    return new Team();
  }

}
