package by.training.gapeenko.task2.inteface;

import org.w3c.dom.DOMException;

public interface Node {
	public static final short ELEMENT_NODE = 1;
	public static final short ATTRIBUTE_NODE = 2;

	public short getNodeType();

	public String getNodeValue() throws DOMException;

	public NodeList getParentNode();

	public NodeList getChildNodes();

	public String getTextContent();
}
