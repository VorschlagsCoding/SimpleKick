package me.vorschlagscoding.simplekick.utils;

public class Util {

	public static String toString(int start, String[] str) {
		String result = "";
		for(int i = start; i < str.length; i++) {
			if(result.length() == 0) {
				result = str[1];
			} else {
				result = result + " " + str[i];
			}
		}
		return result;
	}
	
}
