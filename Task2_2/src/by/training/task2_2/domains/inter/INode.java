package by.training.task2_2.domains.inter;

public interface INode {

	short getNodeType();

	String getNodeValue();

	INode getParentNode();

	INode getFirstChild();

	INode getLastChild();

}
