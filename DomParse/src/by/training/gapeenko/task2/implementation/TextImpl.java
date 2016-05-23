package by.training.gapeenko.task2.implementation;

import org.w3c.dom.DOMException;

import by.training.gapeenko.task2.inteface.Node;
import by.training.gapeenko.task2.inteface.Text;

public class TextImpl implements Text {
	private String value;

	public TextImpl() {
	}

	public TextImpl(String value) {
		this.value = value;
	}

	@Override
	public short getNodeType() {
		return 3;
	}

	@Override
	public String getNodeValue() throws DOMException {
		return value;
	}

	@Override
	public Node getParentNode() {
		return null;
	}

	@Override
	public Node getFirstChild() {
		return null;
	}

	@Override
	public Node getLastChild() {
		return null;
	}

	@Override
	public String getWholeText() {
		return value;
	}

	@Override
	public void replaceWholeText(String content) {

		value = content;

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
		TextImpl other = (TextImpl) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TextImpl [value=" + value + "]";
	}

}
