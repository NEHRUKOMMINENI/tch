package com.teh.csv.search;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.bean.CsvToBeanBuilder;
import com.teh.csv.search.dto.Bank;

public class CsvSeacrhApplication {

	private static final String fileName = "ProgrammingAssignment.csv";

	private static List<Bank> banks = new ArrayList<>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Application Started ....");

		readFile();

		showOptions();
		while (true) {

			try {

				int option = scanner.nextInt();
				if (option == 7)
					break;
				search(option,scanner);
				showOptions();
			} catch (Exception e) {
			}
		}
		scanner.close();
		System.out.println("Application Stopped ....");

	}

	private static void showOptions() {

		System.out.println("Please Enter the option on which you want to search :");
		System.out.println("1 - zip code");
		System.out.println("2 - State");
		System.out.println("3 - City");
		System.out.println("4 - Type");
		System.out.println("5 - Bank Name");
		System.out.println("6 - City & State");
		System.out.println("7 - For Exit");

	}

	private static void search(int option,Scanner scanner) {

		switch (option) {
		case 1:
			System.out.println("Please enter zip code : ");
			String zipCode = scanner.next();
			System.out.println("\n ---- Your Seacrh Result --- \n");
			banks.stream().filter(b -> b.getZipCode().equals(zipCode)).forEach(System.out::println);
			System.out.println("\n --- *** --- \n");
			break;
		case 2:
			System.out.println("Please enter State : ");
			String state = scanner.next();
			System.out.println("\n ---- Your Seacrh Result --- \n");
			banks.stream().filter(b -> b.getState().equalsIgnoreCase(state)).forEach(System.out::println);
			System.out.println("\n --- *** --- \n");
			break;
		case 3:
			System.out.println("Please enter City : ");
			String city = scanner.next();
			System.out.println("\n ---- Your Seacrh Result --- \n");
			banks.stream().filter(b -> b.getCity().equalsIgnoreCase(city)).forEach(System.out::println);
			System.out.println("\n --- *** --- \n");
			break;
		case 4:
			System.out.println("Please enter Type : ");
			String type = scanner.next();
			System.out.println("\n ---- Your Seacrh Result --- \n");
			banks.stream().filter(b -> b.getType().equalsIgnoreCase(type)).forEach(System.out::println);
			System.out.println("\n --- *** --- \n");
			break;
		case 5:
			System.out.println("Please enter Bank Name : ");
			String name = scanner.next();
			System.out.println("\n ---- Your Seacrh Result --- \n");
			banks.stream().filter(b -> b.getBankName().equalsIgnoreCase(name)).forEach(System.out::println);
			System.out.println("\n --- *** --- \n");
			break;
		case 6:
			System.out.println("Please enter City : ");
			String c = scanner.next();
			System.out.println("Please enter State : ");
			String s = scanner.next();
			System.out.println("\n ---- Your Seacrh Result --- \n");
			banks.stream().filter(b -> b.getState().equalsIgnoreCase(s) && b.getCity().equalsIgnoreCase(c))
					.forEach(System.out::println);
			System.out.println("\n --- *** --- \n");
			break;
		default:
			System.err.println("\n Invalid Choice :\n\n");
			break;
		}

	}

	private static void readFile() {
		try {
			System.out.println("Start Reading CSV : " + fileName);
			banks = new CsvToBeanBuilder<Bank>(new FileReader(fileName)).withType(Bank.class).build().parse();

			System.out.println("CSV Reading Completed : " + fileName);
		} catch (Exception e) {
			System.err.println("Error while reading file from : " + fileName);
			System.exit(1);
		}

	}

}
