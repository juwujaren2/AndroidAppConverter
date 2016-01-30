package edu.gatech.seclass;

public class MyWeirdString implements MyWeirdStringInterface {

	private String myString;

    private static String[] romanNumerals = { "0", "I", "II", "III",  "IV", "V", "VI", "VII", "VIII", "IX" };	
	
	@Override
	public void setWeirdString(String string) {
		// TODO Auto-generated method stub
		myString = string;
	}

	@Override
	public String getWeirdString() {
		// TODO Auto-generated method stub
		return myString;
	}

	@Override
	public String getEvenCharacters() {
		
		String output = ""; 
		
		//iterate through string characters and output only if character is an even index
		for (int i = 0; i < myString.length(); i++ ) {
			if (i % 2 != 0) {
				output += myString.charAt(i);
			}
		}		
		return output;
	}

	@Override
	public String getOddCharacters() {
		
		String output = "";
		
		//iterate through string characters and output only if character is an odd index
		for (int i = 0; i < myString.length(); i++ ) {
			if (i % 2 == 0) {
				output += myString.charAt(i);
			}
		}
		return output;
	}

	@Override
	public int countDigits() {
		
		int count = 0;
		
		//count character only if it is a digit
		for (int i = 0; i < myString.length(); i++) {
			if (Character.isDigit(myString.charAt(i))) {
					count++;
			}
		}
		return count;
	}

	@Override
	public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition)
			throws MyIndexOutOfBoundsException, IllegalArgumentException {
		
		if (startPosition < 1) {
			throw new MyIndexOutOfBoundsException("The start position is out of bounds");
		}
		if (endPosition > myString.length()) {
			throw new MyIndexOutOfBoundsException("The end position is out of bounds");
		}
		if (startPosition > endPosition) {
			throw new IllegalArgumentException("Start position cannot be greater than end position");
		}
		
		//make positions usable with arrays
		startPosition--;
		
		String subString = myString.substring(startPosition, endPosition);
		
		for (int i = 0; i < subString.length(); i++) {
			char currentChar = subString.charAt(i);
			if (Character.isDigit(currentChar)) {
				String charVal = Character.toString(currentChar);
				int intVal = Integer.parseInt(charVal);
				subString = subString.replace(charVal, romanNumerals[intVal]);
			}
		}		
		StringBuilder sb = new StringBuilder(myString);
		myString = sb.delete(startPosition, endPosition).toString();
		myString = sb.insert(startPosition, subString).toString();
	}

}
