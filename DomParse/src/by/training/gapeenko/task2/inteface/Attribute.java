package by.training.gapeenko.task2.inteface;

import org.w3c.dom.DOMException;

public interface Attribute extends Node {
	public String getName();

	public Element getOwnerElement();

	public String getValue();

	public void setValue(String value) throws DOMException;

	public boolean isId();
}
