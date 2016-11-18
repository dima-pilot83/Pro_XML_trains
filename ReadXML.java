package ru.mail.dimapilot;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

	private static int minTime;
	private static int maxTime;

	public void setMinTime(int minTime) {
		this.minTime = minTime;
	}

	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}

	public static void read() {

		try {
			File xmlFile = new File("1.xml");

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

			Document document = documentBuilder.parse(xmlFile);

			Element root = document.getDocumentElement();
			System.out.println("Main element: " + root.getNodeName());
			System.out.println("----------------------");

			NodeList nodeList = root.getChildNodes();
			NamedNodeMap attributes = root.getAttributes();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;

					String st1 = element.getElementsByTagName("departure").item(0).getChildNodes().item(0)
							.getNodeValue();
					String st2 = st1.substring(0, 2) + st1.substring(3, 5);
					int myInt = Integer.parseInt(st2);

					if (myInt >= minTime && myInt <= maxTime) {

						System.out.println("Train:" + node.getAttributes().getNamedItem("id").getNodeValue());

						System.out.println("From: "
								+ element.getElementsByTagName("from").item(0).getChildNodes().item(0).getNodeValue());

						System.out.println("To: "
								+ element.getElementsByTagName("to").item(0).getChildNodes().item(0).getNodeValue());

						System.out.println("Date: "
								+ element.getElementsByTagName("date").item(0).getChildNodes().item(0).getNodeValue());

						System.out.println("Departure: " + element.getElementsByTagName("departure").item(0)
								.getChildNodes().item(0).getNodeValue());

						System.out.println("----------------------");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
