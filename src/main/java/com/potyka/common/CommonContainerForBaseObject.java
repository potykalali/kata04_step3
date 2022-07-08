package com.potyka.common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * Az osztály célja az adatfájl beolvasása egy "alaposztály" listába és elemzése.
 * */
public abstract class CommonContainerForBaseObject<T> {
  
  private static final Logger logger = Logger.getLogger(CommonContainerForBaseObject.class);

  private List<BaseObject> baseObjects = new ArrayList<>();
  
  // weather esetében DayId, football esetében name
  protected T getDataInDemand() {
    Collections.sort(baseObjects);
    return (T) baseObjects.get(0).getIdentifier();
  }
  
  public void loadFromFile(File dataFile) {
    try {
      for (String oneLine : Files.readAllLines(dataFile.toPath(), StandardCharsets.UTF_8)) {
        if (lineIsDataRecord(oneLine)) {
          BaseObject bd = createInstanceOfBaseObject();
          bd.parse(oneLine);
          this.baseObjects.add(bd);
        }
      }
    } catch (IOException e) {
      logger.error("Hiba az adatok beolvasása közben!", e);
    }
  }
  
  protected abstract BaseObject createInstanceOfBaseObject();
  
  protected List<BaseObject> getBaseObjects(){
    return this.baseObjects;
  }

  private boolean lineIsDataRecord(String oneLine) {
    try {
      return StringUtils.isNumeric(oneLine.replace(" ", "").substring(0, 1));
    } catch (Exception e) {
      return false;
    }
  }
  
}
