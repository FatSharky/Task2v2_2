package by.training.gapeenko.task2.parser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import by.training.gapeenko.task2.implementation.AttributeImpl;
import by.training.gapeenko.task2.implementation.DocumentImpl;
import by.training.gapeenko.task2.implementation.ElementImpl;
import by.training.gapeenko.task2.implementation.TextImpl;

public class DomParser {

	private FileReader fileReader;
	private char currentSymbol;

	private DocumentImpl documentImp;

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

	public DocumentImpl parse() {
		while (readSymbol() != 0) {
			readTag(null);
		}

		return documentImp;
	}

	private void readTag(ElementImpl parentElement) {
		ElementImpl element = new ElementImpl();
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
			parentElement.setTextContent(new TextImpl(textBetweenTags.toString()));
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
				documentImp = new DocumentImpl(element);
		}
		if (!closedTag && !singleTag && !declaration) {
			readTag(element);
		} else if (!closedTag)
			readTag(parentElement);
		else
			readTag((ElementImpl) parentElement.getParentElement());
	}

	private void readAttribute(ElementImpl element) {
		AttributeImpl attribute = new AttributeImpl();
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
