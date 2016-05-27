package by.training.task3.domains.intefrace;

import org.w3c.dom.DOMException;

public interface INode {

	short getNodeType();

	String getNodeValue() throws DOMException;

	INode getParentNode();

	INode getFirstChild();

	INode getLastChild();

}
