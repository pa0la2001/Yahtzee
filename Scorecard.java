package com.grupi2c.yahtzee.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;

public class Scorecard {
	private String[] scorecard;
	private String treNjelloj = "1{3}..|2{3}..|(.+2{3}.+)|3{3}.+|.3{3}.|..3{3}|..4{3}|.4{3}.|4{3}..|..5{3}|.5{3}.|5{3}..|..6{3}";
	private String katerNjelloj = "1{4}.|.2{4}|2{4}.|.3{4}|3{4}.|.4{4}|4{4}.|.5{4}|5{4}.|.6{4}";
	private String fullHouse = "(1{2}2{3})|(1{2}3{3})|(1{2}4{3})|(1{2}5{3})|(1{2}6{3})|(1{3}2{2})|(1{3}3{2})|(1{3}4{2})|(1{3}5{2})|(1{3}6{2})|(2{2}3{3})|(2{2}4{3})|(2{2}5{3})|(2{2}6{3})|(2{3}3{2})|(2{3}4{2})|(2{3}5{2})|(2{3}6{2})|(3{2}4{3})|(3{2}5{3})|(3{2}6{3})|(3{3}4{2})|(3{3}5{2})|(3{3}6{2})|(4{2}5{3})|(4{2}6{3})|(4{3}5{2})|(4{3}6{2})|(5{2}6{3})|(5{3}6{2})";
	private String smallStreet = "11234|1234.|.2345|2345.|.3456|34566|12.34|23.45|34.56";
	private String bigStreet = "12345|23456";
	private String yahtzee = "1{5}|2{5}|3{5}|4{5}|5{5}|6{5}";
	private String chance = "[1-6]{5}";
	private String[] scores2 = new String[] {treNjelloj, katerNjelloj, fullHouse, smallStreet, bigStreet, yahtzee,
			chance };

	// Llogaritjet e tabeles se pikeve dhe kontrollet realizohen ketu
	public Scorecard() {
		scorecard = new String[13];
		for (int i = 0; i < scorecard.length; i++) {
			scorecard[i] = "0";
		}
	}

	// Merr si  input zaret dhe zgjedhjen e pikeve ne nje matrice
	public int calculateScore(boolean[] selectedScore, int[] tempArray) {
		int score = 0;
		// Vendos totalin ne String per  regEx
		int[]  totalCheck = new int[5];
		for (int i = 0; i < 5; i++) {
			totalCheck[i] = tempArray[i];
		}
		Arrays.sort(totalCheck);
		String totalString = Arrays.toString(totalCheck);
		totalString = totalString.replaceAll("\\p{P}", "");
		totalString = totalString.replaceAll(" ", "");
		// Fillo duke kerkuar per 1-6 si opsion
		for (int i = 0; i < scorecard.length; i++) {
			if (i < 6) {
				if (selectedScore[i] == true) {
					int valueSelected = i + 1;
					for (int e : totalCheck) {
						if (e == valueSelected) {
							score = (score + e);
						}
					}
				}
				// Pastaj kontrollo per secilin opsion nga 1-6, si dhe opsionet e tjera
			} else if (i >= 6 && i < 13) {
				if (selectedScore[i] == true) {
					int j = i - 6;
					if (regEx(totalString, j) == false) {
						score = 0;
						break;
					}
					switch (j) {
					case 0: // Tre njelloj
					case 1: // Kater njelloj
					case 6: // Cdo zgjedhje
						for (int e : totalCheck) {
							score = score + e;
						}
						break;
					case 2:
						score = 25;
						break;
					case 3:
						score = 30;
						break;
					case 4:
						score = 35;
						break;
					case 5: // Yahtzee
						score = 50;
						break;
					}
				}

			}
		}
		// Rikthe rezulatatin aktual
		return score;
	}

	// Metode regEx
	public final boolean regEx(String toCheck, int j) {
		Pattern p = Pattern.compile(scores2[j]);
		Matcher m = p.matcher(toCheck);
		return m.matches();
	}

	// Vendos piket bazuar ne piket aktualr
	public void setScore(JLabel[] actualScores) {
		for (int i = 0; i < scorecard.length; i++) {
			scorecard[i] = actualScores[i].getText();
			;
		}
	}

	public String[] getScore() {
		return scorecard;
	}

}
