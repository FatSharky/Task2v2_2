package by.training.task3.domains.impl;

import org.w3c.dom.DOMException;

import by.training.task3.domains.intefrace.IDocument;
import by.training.task3.domains.intefrace.IElement;
import by.training.task3.domains.intefrace.INode;

public class Document implements IDocument {
	private IElement documentElement;

	public Document() {
	}

	public Document(IElement documentElement) {
		this.documentElement = documentElement;
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
	public IElement getDocumentElement() {

		return documentElement;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentElement == null) ? 0 : documentElement.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (documentElement == null) {
			if (other.documentElement != null)
				return false;
		} else if (!documentElement.equals(other.documentElement))
			return false;
		return true;
	}
	

}
