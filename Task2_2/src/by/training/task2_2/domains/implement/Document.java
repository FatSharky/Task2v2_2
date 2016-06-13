package by.training.task2_2.domains.implement;

import by.training.task2_2.domains.inter.IDocument;
import by.training.task2_2.domains.inter.IElement;
import by.training.task2_2.domains.inter.INode;

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
