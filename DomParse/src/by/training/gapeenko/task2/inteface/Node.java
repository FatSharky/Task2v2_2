package by.training.gapeenko.task2.inteface;

import org.w3c.dom.DOMException;

public interface Node {

	public short getNodeType();

	public String getNodeValue() throws DOMException;

	public Node getParentNode();

	public Node getFirstChild();

	public Node getLastChild();

}
