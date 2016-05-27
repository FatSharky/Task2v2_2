package by.training.task3.domains.intefrace;

import java.util.List;

import org.w3c.dom.DOMException;

public interface IElement extends INode {
	String getTagName();

	boolean hasAttribute();

	String getAttribute(String name);

	 IAttribute getAttributeNode(String name);

	 void setAttribute(String name, String value) throws DOMException;

	 void removeAttribute(String name) throws DOMException;

	List<IElement> getElementsByTagName(String name);

	String getInnerText();

}
