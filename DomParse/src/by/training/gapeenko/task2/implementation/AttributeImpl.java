package by.training.gapeenko.task2.implementation;

import org.w3c.dom.DOMException;

import by.training.gapeenko.task2.inteface.Attribute;
import by.training.gapeenko.task2.inteface.Element;
import by.training.gapeenko.task2.inteface.Node;

public class AttributeImpl implements Attribute {

	private Element ownerElement;
	private String name;
	private String value;

	public AttributeImpl() {
	}

	public AttributeImpl(String name, String value) {
		this.name = name;
	}

	@Override
	public short getNodeType() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String getNodeValue() throws DOMException {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public Node getParentNode() {

		return ownerElement;
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
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public Element getOwnerElement() {
		// TODO Auto-generated method stub
		return ownerElement;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void setValue(String value) throws DOMException {
		this.value = value;

	}

	@Override
	public boolean isId() {
		return name.equals("ID");
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwnerElement(Element ownerElement) {
		this.ownerElement = ownerElement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((ownerElement == null) ? 0 : ownerElement.hashCode());
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
		AttributeImpl other = (AttributeImpl) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ownerElement == null) {
			if (other.ownerElement != null)
				return false;
		} else if (!ownerElement.equals(other.ownerElement))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AttrubuteImpl [ownerElement=" + ownerElement + ", name=" + name + ", value=" + value + "]";
	}

}
