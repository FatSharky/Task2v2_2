package by.training.task3.domains.impl;

import org.w3c.dom.DOMException;

import by.training.task3.domains.intefrace.IAttribute;
import by.training.task3.domains.intefrace.IElement;
import by.training.task3.domains.intefrace.INode;

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

	public void setOwnerElement(IElement ownerElement) {
		this.ownerElement = ownerElement;
	}

	@Override
	public short getNodeType() {
		return 2;
	}

	@Override
	public String getNodeValue() throws DOMException {
		return value;
	}

	@Override
	public INode getFirstChild() {
		return null;
	}

	@Override
	public INode getLastChild() {
		return null;
	}

}
