/*
 * Copyright (C) 2017 Redjan Shabani
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.redis.stock.admin.utils;

import com.redis.stock.admin.Stock;
import com.redis.stock.admin.core.Input;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Redjan Shabani
 */
public class HTML {
	
	public static File save(Input input) {
		File dir = new File("./temp/input");
		dir.mkdirs();
		
		File file = new File(dir, input.getCode() + ".html");
		
		try {
			Document doc = documentFrom(input);
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "1");
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATIO‌​N, "yes");
				
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
         
			// Output to console for testing
			StreamResult consoleResult = new StreamResult(System.out);
			transformer.transform(source, consoleResult);
		} 
		catch (ParserConfigurationException | TransformerException ex) {
			Logger.getLogger(HTML.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return file;
	}
	
	private static Document documentFrom(Input input) throws ParserConfigurationException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.newDocument();
		
		Element html = doc.createElement("html");
		
		Element head = doc.createElement("head");
		//<editor-fold desc="HTML HEAD SECTION">		
		Element head1 = doc.createElement("title");
		head1.setTextContent("FLETE HYRJE: " + input.getCode());
		head.appendChild(head1);
		
//		<meta charset="UTF-8">
		Element head2 = doc.createElement("meta");
		head2.setAttribute("charset", "UTF-8");
		head.appendChild(head2);

//		<meta name="viewport" content="width=device-width, initial-scale=1.0">		
		Element head3 = doc.createElement("meta");
		head3.setAttribute("name", "viyewport");
		head3.setAttribute("content", "width=device-width, initial-scale=1.0");
		head.appendChild(head3);
		
//		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		Element head4 = doc.createElement("link");
		head4.setAttribute("rel", "stylesheet");
		head4.setAttribute("href", "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css");
		head.appendChild(head4);
		
//		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>		
		Element head5 = doc.createElement("script");
		head5.setAttribute("src", "https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js");
		head5.setTextContent("");
		head.appendChild(head5);
		
//		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		Element head6 = doc.createElement("script");
		head6.setAttribute("src", "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js");
		head6.setTextContent("");
		head.appendChild(head6);
			
		//</editor-fold>
		html.appendChild(head);	
		
		
		Element body = doc.createElement("body");
		//<editor-fold desc="HTML BODY SECTION">
		Element div = doc.createElement("div");
		div.setAttribute("class", "container");
		
		//EMERTIMI I MAGAZINES
		Stock stock = Stock.getInstance();	
		Element stockElem = doc.createElement("div");
		stockElem.setAttribute("class", "jumbotron text-center");		
		stockElem.appendChild(doc.createTextNode(stock.getCode() + " - " + stock.getName()));
		stockElem.appendChild(doc.createElement("br"));			
		stockElem.appendChild(doc.createTextNode(stock.getAddress()));
		stockElem.appendChild(doc.createElement("br"));		
		stockElem.appendChild(doc.createTextNode(stock.getPhone() + " | " + stock.getEmail()));
		stockElem.appendChild(doc.createElement("br"));		
		div.appendChild(stockElem);
		
		//TITULLI I DOKUMENTIT
		Element title = doc.createElement("h3");
		title.setAttribute("class", "text-center");
		title.setTextContent("FLETE HYRJE");
		div.appendChild(title);
		
		//KOKA E FATURES
		
	
		
		
		body.appendChild(div);
		//</editor-fold>
		html.appendChild(body);
		
		doc.appendChild(html);
		
		return doc;
	}
	
	
	public static void main(String[] args) throws IOException {
		Desktop.getDesktop().open(HTML.save(Input.read(217)));
	}
}
