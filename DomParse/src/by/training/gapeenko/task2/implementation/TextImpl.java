package by.training.gapeenko.task2.implementation;

import org.w3c.dom.DOMException;

import by.training.gapeenko.task2.inteface.Node;
import by.training.gapeenko.task2.inteface.Text;

public class TextImpl implements Text {
	private String value;

	public TextImpl() {
	}

	public TextImpl(String value) {
		this.value = value;
	}

	@Override
	public short getNodeType() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String getNodeValue() throws DOMException {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public Node getParentNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getFirstChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getLastChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getWholeText() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void replaceWholeText(String content) {

		value = content;

	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "TextImpl [value=" + value + "]";
	}

}
