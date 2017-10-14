package com.sqa.gs.amazon;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class AmazonDataDrivenTest {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
