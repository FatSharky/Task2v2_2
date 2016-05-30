package by.traning.task4.dom;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import by.traning.task4.domains.implement.Attribute;
import by.traning.task4.domains.implement.Document;
import by.traning.task4.domains.implement.Element;
import by.traning.task4.domains.implement.Text;
import by.traning.task4.domains.interfaces.IDomParser;
import by.traning.task4.domains.interfaces.IVariables;

public class DomParser implements IVariables, IDomParser {
	private FileReader fileReader;
	private char currentSymbol;

	private Document document;

	public DomParser() {
	}

	@Override
	public void setXMLFile(String xmlFileURI) {
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

		return document;
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

	private void readTag(Element parentElement) {
		Element element = new Element();

		boolean closedTag = false;
		boolean singleTag = false;
		boolean declaration = false;

		StringBuilder tagName = new StringBuilder();

		String textBetweenTags = readText();

		if (currentSymbol == 0)
			return;

		while (readSymbol() != END_TAG) {

			if (currentSymbol == CLOSE_TAG) {

				if (tagName.length() == 0)
					closedTag = true;
				else
					singleTag = true;
				break;
			}
			if (currentSymbol == SPACE)
				readAttribute(element);
			else
				tagName.append(currentSymbol);
		}

		if (tagName.length() != 0)
			if (tagName.charAt(0) == QUESTION && tagName.charAt(tagName.length() - 1) == QUESTION)
				declaration = true;

		if (closedTag) {
			parentElement.setTextContent(new Text(textBetweenTags.toString()));
		}

		if (!closedTag && !declaration) {
			element.setTagName(tagName.toString());
			element.setParentElement(parentElement);
			if (parentElement != null)
				parentElement.addChildElement(element);
			else
				document = new Document(element);
		}

		if (!closedTag && !singleTag && !declaration) {

			readTag(element);
		}

		else if (!closedTag)
			readTag(parentElement);

		else
			readTag((Element) parentElement.getParentElement());

	}

	private String readText() {
		StringBuilder textBetweenTags = new StringBuilder();

		while (currentSymbol != START_TAG && currentSymbol != 0)
			textBetweenTags.append(readSymbol());

		if (textBetweenTags.length() != 0)
			textBetweenTags.deleteCharAt(textBetweenTags.length() - 1);

		return textBetweenTags.toString();
	}

	private void readAttribute(Element element) {
		Attribute attribute = new Attribute();
		StringBuilder attributeName = new StringBuilder();
		StringBuilder attributeValue = new StringBuilder();

		while (readSymbol() != EQUALLY)
			attributeName.append(currentSymbol);

		readSymbol();

		while (readSymbol() != QUOTES)
			attributeValue.append(currentSymbol);

		attribute.setName(attributeName.toString());
		attribute.setValue(attributeValue.toString());
		element.addAttribute(attribute);
	}

}
