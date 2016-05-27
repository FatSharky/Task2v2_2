package by.training.task3.domains.intefrace;

import org.w3c.dom.DOMException;

public interface IAttribute extends INode {
	 String getName();

	 IElement getOwnerElement();

	 String getValue();

	 void setValue(String value) throws DOMException;

	 boolean isId();
}
