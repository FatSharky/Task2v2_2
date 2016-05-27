package by.training.gapeenko.task2.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import by.training.task3.domains.impl.Attribute;
import by.training.task3.domains.impl.Document;
import by.training.task3.domains.impl.Element;
import by.training.task3.domains.impl.Text;

public class DomParser {

	private FileReader fileReader;
	private char currentSymbol;

	private Document documentImpl;

	public DomParser() {
	}

	public DomParser(String xmlFileURI) {
		File xmlFile = new File(xmlFileURI);
		try {
			fileReader = new FileReader(xmlFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Document parse() {
		while (readSymbol() != 0) {
			readTag(null);
		}

		return documentImpl;
	}

	private void readTag(Element parentElement) {
		Element element = new Element();
		boolean closedTag = false;
		boolean singleTag = false;
		boolean declaration = false;
		StringBuilder tagName = new StringBuilder();
		StringBuilder textBetweenTags = new StringBuilder();

		while (currentSymbol != '<' && currentSymbol != 0)
			textBetweenTags.append(readSymbol());
		if (currentSymbol == 0)
			return;

		while (readSymbol() != '>') {
			if (currentSymbol == '/') {
				if (tagName.length() == 0)
					closedTag = true;
				else
					singleTag = true;
				break;
			}
			if (currentSymbol == ' ')
				readAttribute(element);
			else
				tagName.append(currentSymbol);
		}

		if (parentElement != null) {
			textBetweenTags.deleteCharAt(textBetweenTags.length() - 1);
			parentElement.setTextContent(new Text(textBetweenTags.toString()));
		}

		element.setTagName(tagName.toString());

		if (tagName.length() != 0)
			if (tagName.charAt(0) == '?' && tagName.charAt(tagName.length() - 1) == '?')
				declaration = true;

		if (!closedTag && !declaration) {
			element.setParentElement(parentElement);
			if (parentElement != null)
				parentElement.addChildElement(element);
			else
				documentImpl = new Document(element);
		}
		if (!closedTag && !singleTag && !declaration) {
			readTag(element);
		} else if (!closedTag)
			readTag(parentElement);
		else
			readTag((Element) parentElement.getParentElement());
	}

	private void readAttribute(Element element) {
		Attribute attribute = new Attribute();
		StringBuilder attributeName = new StringBuilder();
		StringBuilder attributeValue = new StringBuilder();

		while (readSymbol() != '=')
			attributeName.append(currentSymbol);
		readSymbol();
		while (readSymbol() != '"')
			attributeValue.append(currentSymbol);

		attribute.setName(attributeName.toString());
		attribute.setValue(attributeValue.toString());
		element.addAttribute(attribute);
	}

	private char readSymbol() {
		int readSymbol = 0;
		try {
			readSymbol = fileReader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (readSymbol != -1)
			currentSymbol = (char) readSymbol;
		else
			currentSymbol = 0;

		return currentSymbol;
	}

}
