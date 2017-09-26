package edu.nyit.CSCI455.MeterProject;

import org.springframework.data.annotation.Id;

public class DataRun {
  @Id
  public String id;

  public String[][] data_1;

  public DataRun() {
    data_1 = new String[2][100];
  }

}
