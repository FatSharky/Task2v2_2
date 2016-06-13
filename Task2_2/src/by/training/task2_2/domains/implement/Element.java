package by.training.task2_2.domains.implement;

import java.util.ArrayList;
import java.util.List;

import by.training.task2_2.domains.inter.IAttribute;
import by.training.task2_2.domains.inter.IElement;
import by.training.task2_2.domains.inter.INode;
import by.training.task2_2.domains.inter.IText;


public class Element implements IElement {
	private String tagName;
	private IElement parentElement;
	private List<IElement> childElements;
	private List<IAttribute> attributes;
	private IText textContent;

	public Element() {
		childElements = new ArrayList<>();
		attributes = new ArrayList<>();
	}

	public Element(String tagName, IText textContent, List<IAttribute> attributes, List<IElement> childElements,
			Element parentElement) {
		this.tagName = tagName;
		this.textContent = textContent;
		this.attributes = attributes;
		this.childElements = childElements;
		this.parentElement = parentElement;
	}

	public String getTagName() {
		return tagName;
	}

	@Override
	public boolean hasAttribute() {
		return !attributes.isEmpty();
	}

	@Override
	public String getAttribute(String name) {
		for (IAttribute attribute : attributes) {
			if (attribute.getName().equals(name))
				return attribute.getValue();
		}

		return null;
	}

	@Override
	public IAttribute getAttributeNode(String name) {
		for (IAttribute attribute : attributes) {
			if (attribute.getName().equals(name))
				return attribute;
		}

		return null;
	}

	@Override
	public void setAttribute(String name, String value) {
		for (IAttribute attribute : attributes) {
			if (attribute.getName().equals(name))
				attribute.setValue(value);
		}
	}

	@Override
	public void removeAttribute(String name) {
		for (IAttribute attribute : attributes) {
			if (attribute.getName().equals(name))
				attributes.remove(attribute);
		}
	}

	@Override
	public List<IElement> getElementsByTagName(String name) {
		List<IElement> searchingElements = new ArrayList<>();

		for (IElement element : childElements) {
			if (element.getTagName().equals(name))
				searchingElements.add(element);

			searchingElements.addAll(element.getElementsByTagName(name));
		}
		return searchingElements;
	}

	@Override
	public String getInnerText() {
		return textContent.getWholeText();
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public IElement getParentElement() {
		return parentElement;
	}

	public void setParentElement(Element parentElement) {
		this.parentElement = parentElement;
	}

	public List<IElement> getChildElements() {
		return childElements;
	}

	public void setChildElements(List<IElement> childElements) {
		this.childElements = childElements;
	}

	public void addChildElement(Element childElement) {
		this.childElements.add(childElement);
	}

	public List<IAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<IAttribute> attributes) {
		this.attributes = attributes;
	}

	public void addAttribute(IAttribute attribute) {
		this.attributes.add(attribute);
	}

	public IText getTextContent() {
		return textContent;
	}

	public void setTextContent(IText textContent) {
		this.textContent = textContent;
	}

	@Override
	public short getNodeType() {
		return 1;
	}

	@Override
	public String getNodeValue() {
		return null;
	}

	@Override
	public INode getParentNode() {
		return parentElement;
	}

	@Override
	public INode getFirstChild() {
		return childElements.get(0);
	}

	@Override
	public INode getLastChild() {
		return childElements.get(childElements.size() - 1);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((childElements == null) ? 0 : childElements.hashCode());
		result = prime * result + ((parentElement == null) ? 0 : parentElement.hashCode());
		result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
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
		Element other = (Element) obj;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
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
		if (tagName == null) {
			if (other.tagName != null)
				return false;
		} else if (!tagName.equals(other.tagName))
			return false;
		if (textContent == null) {
			if (other.textContent != null)
				return false;
		} else if (!textContent.equals(other.textContent))
			return false;
		return true;
	}
	

}
