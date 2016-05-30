package by.training.task3.view;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import by.training.task3.domains.Menu;
import by.traning.task4.domains.interfaces.IDocument;
import by.traning.task4.domains.interfaces.IDomParser;
import by.traning.task4.domains.interfaces.IElement;
import by.traning.task4.domains.interfaces.IVariables;
import by.traning.task4.factory.DomFactory;

public class DOMMenuParser implements IVariables {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

		Menu menu = new Menu();

		DomFactory domParserFactory = DomFactory.getInstance();
		IDomParser domParser = domParserFactory.getDomParser();
		domParser.setXMLFile(XML_FILE_URI);
		IDocument document = domParser.parse();
		
		//IElement menuElement = 
	}
}
