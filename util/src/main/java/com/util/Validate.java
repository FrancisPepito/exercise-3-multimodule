package com.util;
import java.util.Scanner;
import java.util.LinkedList;
import org.apache.commons.lang3.math.NumberUtils;

public class Validate{
	private static Scanner s = new Scanner(System.in);
	private static NumberUtils numberUtil = new NumberUtils();

	private Validate(){}

	public static int integerInput(String message) {
		Scanner s = new Scanner(System.in);
		int input=0;
		System.out.print(message);
		try {
			input = numberUtil.toInt(s.nextLine());
		}catch (Exception ex){
			System.out.println("Invalid Input");
			return integerInput(message);
		}
		return input;
	}

	public static int integerInput(String message,int min) {
		Scanner s = new Scanner(System.in);
		int input=0;
		System.out.print(message);
		try {
			input = numberUtil.toInt(s.nextLine());
			if(input < min){
				System.out.println("Input must not be less than "+min);
				return integerInput(message,min);
			}
		}catch (Exception ex){
			System.out.println("Invalid Input");
			return integerInput(message,min);
		}
		return input;
	}

	public static String stringInput(String message) {
		String input="";
		try {
			System.out.print(message);
			input = s.nextLine();
			if(input.contains("\t")) {
				System.out.println("String must not contain a horizontal tab space");
				return stringInput(message);
			}
		} catch(Exception ex) {
			System.out.println("Invalid Input");
			ex.printStackTrace();
		}
		return input;
	}

	public static boolean arrayIndex(LinkedList<LinkedList<String>> list, int row, int col) {
		try {
			list.get(row).get(col);
			return true;
		}catch(Exception ex) {
			System.out.println("Invalid index");
			return false;
		}
	}
	public static boolean arrayIndex(LinkedList<LinkedList<String>> list, int index) {
		try {
			list.get(index);
			return true;
		}catch(Exception ex) {
			System.out.println("Invalid index");
			return false;
		}
	}

}
