package edu.gatech.seclass;

public class Demo {

	public static void main(String[] args) {
		MyWeirdString myweirdstring = new MyWeirdString();
		
		// TODO Auto-generated method stub
		myweirdstring.setWeirdString("I'd better put s0me d1gits in this 5tr1n9, right?");
		myweirdstring.convertDigitsToRomanNumeralsInSubstring(40, 45);
		System.out.println(myweirdstring.getWeirdString());
	}

}
