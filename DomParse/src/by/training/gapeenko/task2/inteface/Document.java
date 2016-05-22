package by.training.gapeenko.task2.inteface;

import org.w3c.dom.DOMException;

public interface Document extends Node {
	public Element createElement(String tagName) throws DOMException;

	public Element getDocumentElement();
}
