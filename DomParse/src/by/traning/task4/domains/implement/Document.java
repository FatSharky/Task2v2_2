package by.traning.task4.domains.implement;

import by.traning.task4.domains.interfaces.IDocument;
import by.traning.task4.domains.interfaces.IElement;
import by.traning.task4.domains.interfaces.INode;

public class Document implements IDocument {
	private IElement documentElement;

	public Document() {
	}

	public Document(IElement documentElement) {
		this.documentElement = documentElement;
	}

	@Override
	public IElement getDocumentElement() {
		return documentElement;
	}

	@Override
	public short getNodeType() {
		return 0;
	}

	@Override
	public String getNodeValue() {
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

}
