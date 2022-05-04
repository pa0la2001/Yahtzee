package com.grupi2c.yahtzee.utils;

import java.util.ArrayList;

public class Utils {

	public static boolean isAllTrue(boolean[] checks) {
		for (boolean check : checks) {
			if (!check) {
				return false;
			}
		}
		return true;
	}

	public static boolean isAllFalse(boolean[] checks) {
		for (boolean check : checks) {
			if (check) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPresentInArrayListString(ArrayList<String> checks, String toBeChecked) {
		if (checks.contains(toBeChecked)) {
			return true;
		}
		return false;
	}
}
