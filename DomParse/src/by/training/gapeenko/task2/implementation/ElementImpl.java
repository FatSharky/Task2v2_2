package by.training.gapeenko.task2.implementation;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.DOMException;

import by.training.gapeenko.task2.inteface.Attribute;
import by.training.gapeenko.task2.inteface.Element;
import by.training.gapeenko.task2.inteface.Node;
import by.training.gapeenko.task2.inteface.Text;

public class ElementImpl implements Element {

	private String tagName;
	private Element parentElement;
	private List<Element> childElements;
	private List<Attribute> attributes;
	private Text textContent;

	public ElementImpl() {
		childElements = new ArrayList<>();
		attributes = new ArrayList<>();
	}

	public ElementImpl(String tagName, Text textContent, List<Attribute> attributes, List<Element> childElements,
			Element parentElement) {
		this.tagName = tagName;
		this.textContent = textContent;
		this.attributes = attributes;
		this.childElements = childElements;
		this.parentElement = parentElement;
	}

	@Override
	public short getNodeType() {
		return 1;
	}

	@Override
	public String getNodeValue() throws DOMException {
		return null;
	}

	@Override
	public Node getParentNode() {
		return parentElement;
	}

	@Override
	public Node getFirstChild() {
		return childElements.get(0);
	}

	@Override
	public Node getLastChild() {
		return childElements.get(childElements.size() - 1);
	}

	@Override
	public String getTagName() {
		return tagName;
	}

	@Override
	public boolean hasAttribute() {
		return !attributes.isEmpty();
	}

	@Override
	public String getAttribute(String name) {
		for (Attribute attribute : attributes) {
			if (attribute.getName().equals(name))
				return attribute.getValue();
		}

		return null;

	}

	@Override
	public Attribute getAttributeNode(String name) {
		for (Attribute attribute : attributes) {
			if (attribute.getName().equals(name))
				return attribute;
		}

		return null;

	}

	@Override
	public void setAttribute(String name, String value) throws DOMException {
		for (Attribute attribute : attributes) {
			if (attribute.getName().equals(name))
				attribute.setValue(value);
		}

	}

	@Override
	public void removeAttribute(String name) throws DOMException {
		for (Attribute attribute : attributes) {
			if (attribute.getName().equals(name))
				attributes.remove(attribute);
		}

	}

	@Override
	public List<Element> getElementsByTagName(String name) {
		List<Element> searchingElements = new ArrayList<>();

		for (Element element : childElements) {
			if (element.getTagName().equals(name))
				searchingElements.add(element);

			searchingElements.addAll(element.getElementsByTagName(name));
		}
		return searchingElements;

	}

	public void addChildElement(Element childElement) {
		this.childElements.add(childElement);
	}

	public void addAttribute(Attribute attribute) {
		this.attributes.add(attribute);
	}

	@Override
	public String getInnerText() {
		return textContent.getWholeText();
	}

	public Text getTextContent() {
		return textContent;
	}

	public void setTextContent(Text textContent) {
		this.textContent = textContent;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Element> getChildElements() {
		return childElements;
	}

	public void setChildElements(List<Element> childElements) {
		this.childElements = childElements;
	}

	public Element getParentElement() {
		return parentElement;
	}

	public void setParentElement(Element parentElement) {
		this.parentElement = parentElement;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "ElementImpl [tagName=" + tagName + ", parentElement=" + parentElement + ", childElements="
				+ childElements + ", attributes=" + attributes + ", textContent=" + textContent + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((childElements == null) ? 0 : childElements.hashCode());
		result = prime * result + ((parentElement == null) ? 0 : parentElement.hashCode());
		result = prime * result + ((textContent == null) ? 0 : textContent.hashCode());
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
		ElementImpl other = (ElementImpl) obj;
		if (childElements == null) {
			if (other.childElements != null)
				return false;
		} else if (!childElements.equals(other.childElements))
			return false;
		if (parentElement == null) {
			if (other.parentElement != null)
				return false;
		} else if (!parentElement.equals(other.parentElement))
			return false;
		if (textContent == null) {
			if (other.textContent != null)
				return false;
		} else if (!textContent.equals(other.textContent))
			return false;
		return true;
	}

}
