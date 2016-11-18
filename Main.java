package ru.mail.dimapilot;

import java.io.IOException;

import org.xml.sax.SAXException;

public class Main {

	public static void main(String[] args) throws SAXException, IOException {

		
		Trains.add(new Train(5, "Paris", "Kiev", "11.11.2016", "11:55"));
		Trains.add(new Train(8, "Warsaw", "Kiev", "01.09.2016", "18:50"));
		
		
		ReadXML r1=new ReadXML();//Output needed trains
		r1.setMinTime(1500);//Time format 15-00
		r1.setMaxTime(1900);//Time format 19-00
		
		AddtoXML.add();
		ReadXML.read();
	}

}
