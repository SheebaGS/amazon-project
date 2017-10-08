/**
 * File Name: AppBasicsTest.java<br>
 * GS, Sheeba<br>
 * Created: Oct 7, 2017
 */
package com.sqa.gs.helpers;

import org.testng.*;
import org.testng.annotations.*;

/**
 * AppBasicsTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author GS, Sheeba
 * @version 1.0.0
 * @since 1.0
 */
public class AppBasicsTest {

	@Test
	public void testRequestDouble() {
		double curWallet = AppBasics.requestDouble("How much money do you have on hand?");
		Assert.assertEquals(5.0, curWallet, .1);
	}

	@Test
	public void testRequestInt() {
		int num = AppBasics.requestInt("What should the int value be?");
		Assert.assertEquals(10, num);
	}

	@Test
	public void testRequestString() {
		String favColor = AppBasics.requestString("Can I get your favorite color?");
		Assert.assertEquals("blue", favColor);
	}
}
