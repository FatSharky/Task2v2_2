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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNodeValue() throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getParentNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getFirstChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getLastChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element createElement(String tagName) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Element getDocumentElement() {
		// TODO Auto-generated method stub
		return documentElement;
	}

}
