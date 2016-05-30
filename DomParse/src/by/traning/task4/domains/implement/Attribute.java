package by.traning.task4.domains.implement;

import by.traning.task4.domains.interfaces.IAttribute;
import by.traning.task4.domains.interfaces.IElement;
import by.traning.task4.domains.interfaces.INode;

public class Attribute implements IAttribute {
	private IElement ownerElement;
	private String name;
	private String value;

	public Attribute() {
	}

	public Attribute(String name, String value) {
		this.name = name;
		this.value = value;
	}

	@Override
	public String getNodeValue() {
		return value;
	}

	@Override
	public INode getParentNode() {
		return ownerElement;
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public IElement getOwnerElement() {
		return ownerElement;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;

	}

	@Override
	public boolean isId() {
		return name.equals("ID");
	}

	public void setOwnerElement(IElement ownerElement) {
		this.ownerElement = ownerElement;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public short getNodeType() {

		return 2;
	}

	@Override
	public INode getFirstChild() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public INode getLastChild() {
		// TODO Auto-generated method stub
		return null;
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
		Attribute other = (Attribute) obj;
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
	

}
