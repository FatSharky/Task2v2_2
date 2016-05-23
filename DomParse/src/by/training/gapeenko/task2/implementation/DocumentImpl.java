package by.training.gapeenko.task2.implementation;

import org.w3c.dom.DOMException;

import by.training.gapeenko.task2.inteface.Document;
import by.training.gapeenko.task2.inteface.Element;
import by.training.gapeenko.task2.inteface.Node;

public class DocumentImpl implements Document{
	private Element documentElement;

    public DocumentImpl(){
    }

    public DocumentImpl(Element documentElement){
        this.documentElement = documentElement;
    }


	@Override
	public short getNodeType() {
		return 0;
	}

	@Override
	public String getNodeValue() throws DOMException {
		return null;
	}

	@Override
	public Node getParentNode() {
		return null;
	}

	@Override
	public Node getFirstChild() {
		return documentElement;
	}

	@Override
	public Node getLastChild() {
		return documentElement;
	}

	@Override
	public Element createElement(String tagName) throws DOMException {
		return null;
	}

	@Override
	public Element getDocumentElement() {
		return documentElement;
	}

}
