package by.traning.task4.domains.interfaces;

public interface INode {

	short getNodeType();

	String getNodeValue();

	INode getParentNode();

	INode getFirstChild();

	INode getLastChild();

}
