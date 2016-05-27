package by.training.task3.domains.impl;

import org.w3c.dom.DOMException;

import by.training.task3.domains.intefrace.INode;
import by.training.task3.domains.intefrace.IText;

public class Text implements IText {
	private String value;

	public Text() {
	}

	public Text(String value) {
		this.value = value;
	}

	@Override
	public String getWholeText() {
		return value;
	}

	@Override
	public void replaceWholeText(String content) {

		value = content;

	}

	@Override
	public String getNodeValue() throws DOMException {
		return value;
	}

	@Override
	public INode getParentNode() {
		return null;
	}

	@Override
	public INode getFirstChild() {
		return null;
	}

	@Override
	public short getNodeType() {
		return 3;
	}

	@Override
	public INode getLastChild() {
		return null;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Text other = (Text) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	

}
