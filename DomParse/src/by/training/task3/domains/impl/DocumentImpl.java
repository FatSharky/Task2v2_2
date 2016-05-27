package by.training.task3.domains.impl;

import org.w3c.dom.DOMException;

import by.training.task3.domains.intefrace.IDocument;
import by.training.task3.domains.intefrace.IElement;
import by.training.task3.domains.intefrace.INode;

public class DocumentImpl implements IDocument{
	private IElement documentElement;

    public DocumentImpl(){
    }

    public DocumentImpl(IElement documentElement){
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
	public INode getParentNode() {
		return null;
	}

	@Override
	public INode getFirstChild() {
		return documentElement;
	}

	@Override
	public INode getLastChild() {
		return documentElement;
	}

	@Override
	public IElement createElement(String tagName) throws DOMException {
		return null;
	}

	@Override
	public IElement getDocumentElement() {
		return documentElement;
	}

}
