package by.traning.task4.domains.implement;

import by.traning.task4.domains.interfaces.INode;
import by.traning.task4.domains.interfaces.IText;

public class Text implements IText {
	private String value;

	public Text() {
	}

	public Text(String value) {
		this.value = value;
	}

	@Override
	public short getNodeType() {
		return 3;
	}

	@Override
	public String getNodeValue() {
		return value;
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
	public INode getParentNode() {
		return null;
	}

	@Override
	public INode getFirstChild() {
		return null;
	}

	@Override
	public INode getLastChild() {
		return null;
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
