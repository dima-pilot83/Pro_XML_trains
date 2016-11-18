package ru.mail.dimapilot;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class AddtoXML {

	public static void add() throws SAXException, IOException {
		
		Trains tr = new Trains();
		
		
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			org.w3c.dom.Document document = documentBuilder.parse("1.xml");
			Element root = document.getDocumentElement();

			for (Train train2 : tr.getListtrain()) {

				Element newtrain = ((org.w3c.dom.Document) document).createElement("train");
				newtrain.setAttribute("id", Integer.toString(train2.getId()));

				Element from = ((org.w3c.dom.Document) document).createElement("from");
				from.appendChild(document.createTextNode(train2.getFrom()));
				newtrain.appendChild(from);

				Element to = ((org.w3c.dom.Document) document).createElement("to");
				to.appendChild(document.createTextNode(train2.getTo()));
				newtrain.appendChild(to);

				Element date = ((org.w3c.dom.Document) document).createElement("date");
				date.appendChild(document.createTextNode(train2.getDepartureDate()));
				newtrain.appendChild(date);

				Element time = ((org.w3c.dom.Document) document).createElement("departure");
				time.appendChild(document.createTextNode(train2.getDepartureTime()));
				newtrain.appendChild(time);

				root.appendChild(newtrain);
			}
			TransformerFactory traF = TransformerFactory.newInstance();
			Transformer transformer = traF.newTransformer();
			DOMSource source = new DOMSource(document);

			StreamResult stRes = new StreamResult("1.xml");

			transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

			transformer.transform(source, stRes);
		} catch (ParserConfigurationException | TransformerException e) {
			((Throwable) e).printStackTrace();
		}

		
	}
	
}
