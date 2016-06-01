package by.training.task2_2.domains.inter;

import java.util.List;

public interface IElement extends INode {

	String getTagName();

	boolean hasAttribute();

	String getAttribute(String name);

	IAttribute getAttributeNode(String name);

	void setAttribute(String name, String value);

	void removeAttribute(String name);

	List<IElement> getElementsByTagName(String name);

	String getInnerText();

}
