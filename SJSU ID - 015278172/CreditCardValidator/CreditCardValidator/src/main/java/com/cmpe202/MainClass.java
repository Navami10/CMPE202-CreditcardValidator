package com.cmpe202;

import java.io.FileNotFoundException;
import java.util.List;

import com.cmpe202.parsers.CSVFileParser;
import com.cmpe202.parsers.JSONFileParser;
import com.cmpe202.parsers.Parser;
import com.cmpe202.parsers.XMLFileParser;

public class MainClass {

	public static void main(String[] args) {
		System.out.print(args);
		String inputFile = "C:\\202Project\\individual-project-Navami10\\SJSU ID - 015278172\\CreditCardValidator\\CreditCardValidator\\Sample.json";
		String outputFile = "OutputSample2.json";
		System.out.println("Input filename: " + inputFile);
		System.out.println("Output filename: " + outputFile);
		Parser p = new Parser();
		if(inputFile.endsWith(".xml")) {
			p.changeParser(new XMLFileParser());
		}
		else if(inputFile.endsWith(".json")) {
			p.changeParser(new JSONFileParser());
		}
		else if(inputFile.endsWith(".csv")) {
			p.changeParser(new CSVFileParser());
		}
		List<CreditCard> c = p.parseFile(inputFile);
		try {
			p.writeToFile(c, outputFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
