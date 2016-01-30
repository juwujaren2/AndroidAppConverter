package edu.gatech.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyWeirdStringTest {

	private MyWeirdStringInterface myweirdstring;

	@Before
	public void setUp() throws Exception {
		myweirdstring = new MyWeirdString();
	}

	@After
	public void tearDown() throws Exception {
		myweirdstring = null;
	}

	@Test
	//This test checks that this method works as expected for a string containing a combination of digits and letters
	public void testCountDigits1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		assertEquals(5, myweirdstring.countDigits());
	}

	@Test
	//This test confirms that this method works as expected for a string that contains no digits
	public void testCountDigits2() {
		myweirdstring.setWeirdString("Does this have any digits?");
		assertEquals(0, myweirdstring.countDigits());
	}

	@Test
	//This test checks for how this method handles special characters instead of letters and digits
	public void testCountDigits3() {
		myweirdstring.setWeirdString("! @$ # *() ^%*&");
		assertEquals(0, myweirdstring.countDigits());
	}

	@Test
	//This test checks that this method handles consecutive digits suitably
	public void testCountDigits4() {
		myweirdstring.setWeirdString("1234567 7654321");
		assertEquals(14, myweirdstring.countDigits());
	}

	@Test
	public void testGetEvenCharacters1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		assertEquals("' etrptsm 1isi hs5rn,rgt", myweirdstring.getEvenCharacters());
	}

	@Test
	//This test checks that this method handles empty strings appropriately
	public void testGetEvenCharacters2() {
		myweirdstring.setWeirdString("");
		assertEquals("", myweirdstring.getEvenCharacters());
	}

	@Test
	//This test checks that this method handles single characters suitably
	public void testGetEvenCharacters3() {
		myweirdstring.setWeirdString("j");
		assertEquals("", myweirdstring.getEvenCharacters());
	}

	@Test
	//This test checks that this method handles string with characters and spaces appropriately
	public void testGetEvenCharacters4() {
		myweirdstring.setWeirdString(" j u n i t ");
		assertEquals("junit", myweirdstring.getEvenCharacters());
	}

	@Test
	public void testGetOddCharacters1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		assertEquals("Idbte u 0edgt nti t19 ih?", myweirdstring.getOddCharacters());
	}

	@Test
	//test single character
	public void testGetOddCharacters2() {
		myweirdstring.setWeirdString("j");
		assertEquals("j", myweirdstring.getOddCharacters());
	}

	@Test
	//test empty string
	public void testGetOddCharacters3() {
		myweirdstring.setWeirdString("");
		assertEquals("", myweirdstring.getOddCharacters());
	}

	@Test
	//test spaces and letters
	public void testGetOddCharacters4() {
		myweirdstring.setWeirdString(" j u n i t ");
		assertEquals("      ", myweirdstring.getOddCharacters());
	}

	@Test
	public void testConvertDigitsToRomanNumeralsInSubstring1() {
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(40, 45);
		assertEquals("I'd better put s0me d1gits in this 5tr1nIX, right?", myweirdstring.getWeirdString());
	}

	@Test(expected = MyIndexOutOfBoundsException.class)
	//This test checks whether this method suitably throws a MyIndexOutOfBoundsException
	public void testConvertDigitsToRomanNumeralsInSubstring2() {
		myweirdstring.setWeirdString("Janice Uwujaren");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(1, 99);
	}

	@Test(expected = IllegalArgumentException.class)
	//This test checks whether this method suitably throws an IllegalArgumentException
	public void testConvertDigitsToRomanNumeralsInSubstring3() {
		myweirdstring.setWeirdString("Janice Uwujaren");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(9, 5);
	}

	@Test
	//String with digits and letters but digits will not be converted based on range - this confirms that it is accounting for the range and not converting all digits
	public void testConvertDigitsToRomanNumeralsInSubstring4() {
		myweirdstring.setWeirdString("Janice 12281999");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(1, 7);
		assertEquals("Janice 12281999", myweirdstring.getWeirdString());
	}

	@Test
	//This test checks whether the method works as expected to replace digits to Roman numerals between digits
	public void testConvertDigitsToRomanNumeralsInSubstring5() {
		myweirdstring.setWeirdString("Janice 12281999");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(10, 13);
		assertEquals("Janice 12IIVIIIIIX99", myweirdstring.getWeirdString());
	}

	@Test
	//This test checks whether the method suitably works as expected for the entire length of the string that's all digits
	public void testConvertDigitsToRomanNumeralsInSubstring6() {
		myweirdstring.setWeirdString("12281999");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(1, 8);
		assertEquals("IIIIIVIIIIIXIXIX", myweirdstring.getWeirdString());
	}

}
