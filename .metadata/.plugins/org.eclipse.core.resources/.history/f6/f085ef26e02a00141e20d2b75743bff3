package com.devdroid.healthycompetition;

import java.util.Random;

public class RandomName {
	
	String[] firstName = new String[]{"Artie", "Rob", "Kenya", "Mathew", "Estella",
			"Brianne", "Alphonso", "Jani", "Tandra", "Weston", "Marlin", "Malorie"};
	
	String[] lastName = new String[]{"Dowdell", "Pettiford", "Loesch", "Bowie",
			"Slayden", "Blackstock", "Gresham", "Leaton", "Snavely", "Mantle", "Paterson", "Vallone"};
	
	public RandomName(){
		
	}
	
	public String getFullName(){
		// Will return random name from top
		Random r = new Random();
		int nF = firstName.length  + 1;
		int iF = r.nextInt() % nF;
		int firstInt = (int)(Math.random()*firstName.length);
		
		String name = firstName[firstInt];
		
		int nL = lastName.length  + 1;
		int iL = r.nextInt() % nL;
		int lastInt = (int)(Math.random()*lastName.length);
		
		name = name.concat(" " + lastName[lastInt]);
		
		return name;
	}
	

}
