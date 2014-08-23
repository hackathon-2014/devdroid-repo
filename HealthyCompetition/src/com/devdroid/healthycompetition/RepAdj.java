package com.devdroid.healthycompetition;

import android.util.Log;

public class RepAdj {

	String[] repsChanged;

	public void upProgress() {

		Log.d("Progress: ", "turned up!"); // placeholder
	}

	// ****************************************************************************************************//
	// this function handles the registration condition settings
	// ****************************************************************************************************//
	public String[] regConditions(Integer sex, Integer age, Integer fitnessLevel) {

		// for access to the base-value rep array
		Movement m = new Movement();
		String[] modArray = new String[m.reps.length];
		Double adjustment;

		for (int i = 0; i < modArray.length; i++) {

			modArray[i] = m.reps[i];
		}

		// check for male**********
		// *************************//
		if (sex == 1) { // 1 = male?
			// 100% of base-value rep array

			// conditions for age of male
			// **************************//
			if (age == 0) {
				repsChanged = modArray;
			} else if (age == 1) {
				adjustment = 0.9;
				repsChanged = adjustReps(adjustment, modArray);
				for (int i = 0; i < repsChanged.length; i++) {
					// Log.d("35-44", "new in: " + repsChanged[i]);
				}
			} else if (age == 2) {
				adjustment = 0.7;
				repsChanged = adjustReps(adjustment, modArray);
				for (int i = 0; i < repsChanged.length; i++) {
					// Log.d("45-54", "new in: " + repsChanged[i]);
				}
			}

			// conditions for fitness level of male
			// ************************************//
			if (fitnessLevel == 1) { // out of shape
				adjustment = 0.9;
				repsChanged = adjustReps(adjustment, repsChanged);
				for (int i = 0; i < repsChanged.length; i++) {
					// Log.d("out of shape", "new in: " + repsChanged[i]);
				}
			} else if (fitnessLevel == 2) { // avg shape
				for (int i = 0; i < repsChanged.length; i++) {
					// 100% of reps
					// Log.d("out of shape", "new in: " + repsChanged[i]);
				}
			} else {// it can only equal 3 //
				adjustment = 1.1;
				repsChanged = adjustReps(adjustment, modArray);
				for (int i = 0; i < repsChanged.length; i++) {
					// Log.d("out of shape", "new in: " + repsChanged[i]);
				}
			}
		}

		// check for female**********
		// *************************//
		if (sex == 0) { // 0 = female?
			// 60% of base-value rep array
			adjustment = 0.6;
			repsChanged = adjustReps(adjustment, modArray);

			// conditions for age of female
			// **************************//
			if (age == 0) {
				repsChanged = modArray;
			} else if (age == 1) {
				adjustment = 0.9;
				repsChanged = adjustReps(adjustment, modArray);
				for (int i = 0; i < repsChanged.length; i++) {
					// Log.d("35-44", "new in: " + repsChanged[i]);
				}
			} else if (age == 2) {
				adjustment = 0.7;
				repsChanged = adjustReps(adjustment, modArray);
				for (int i = 0; i < repsChanged.length; i++) {
					// Log.d("45-54", "new in: " + repsChanged[i]);
				}
			}

			// conditions for fitness level of female
			// ************************************//
			if (fitnessLevel == 1) { // out of shape?
				adjustment = 0.9;
				repsChanged = adjustReps(adjustment, repsChanged);
				for (int i = 0; i < repsChanged.length; i++) {
					// Log.d("fout of shape", "new in: " + repsChanged[i]);
				}
			} else if (fitnessLevel == 2) { // avg shape?
				for (int i = 0; i < repsChanged.length; i++) {
					// 100% of reps
					// Log.d("fout of shape", "new in: " + repsChanged[i]);
				}
			} else {// it can only equal 3 //
				adjustment = 1.1;
				repsChanged = adjustReps(adjustment, modArray);
				for (int i = 0; i < repsChanged.length; i++) {
					// Log.d("fout of shape", "new in: " + repsChanged[i]);
				}
			}

		}

		return repsChanged;
	}

	// ****************************************************************************************************//

	public String[] adjustReps(Double adjustment, String[] modArray) {

		Double[] dubModArray = new Double[modArray.length];
		Integer[] intArray = new Integer[modArray.length];

		// flag the run and change all values to doubles
		for (int i = 0; i < modArray.length; i++) {

			if (i == 6) {
				modArray[i] = "9999"; // flag run element
				dubModArray[i] = Double.valueOf(modArray[i]);
			} else {
				dubModArray[i] = Double.valueOf(modArray[i]);
			}
		}

		// replace flag and fill modArray w modified reps
		for (int i = 0; i < modArray.length; i++) {

			if (i == 6) {
				modArray[i] = "1/4 mile";
			} else {
				// adjust reps
				dubModArray[i] = dubModArray[i] * adjustment;
				// round values and put in int array
				intArray[i] = (int) Math.round(dubModArray[i]);
				// change to string
				modArray[i] = Integer.toString(intArray[i]);
			}
		}

		return modArray;
	}
}
