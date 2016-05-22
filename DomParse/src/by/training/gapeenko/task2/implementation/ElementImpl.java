package by.training.gapeenko.task2.implementation;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.DOMException;

import by.training.gapeenko.task2.inteface.Attribute;
import by.training.gapeenko.task2.inteface.Element;
import by.training.gapeenko.task2.inteface.Node;
import by.training.gapeenko.task2.inteface.NodeList;
import by.training.gapeenko.task2.inteface.Text;

public class ElementImpl implements Element{

    private String tagName;
    private Element parentElement;
    private List<Element> childElements;
    private List<Attribute> attributes;
    private Text textContent;

	@Override
	public short getNodeType() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getNodeValue() throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getParentNode() {
		// TODO Auto-generated method stub
		return parentElement;
	}

	@Override
	public Node getFirstChild() {
		// TODO Auto-generated method stub
		return childElements.get(0);
	}

	@Override
	public Node getLastChild() {
		// TODO Auto-generated method stub
		return childElements.get(childElements.size() - 1);
	}

	@Override
	public String getTagName() {
		// TODO Auto-generated method stub
		return tagName;
	}

	@Override
	public boolean hasAttribute(String name) {
		// TODO Auto-generated method stub
		return !attributes.isEmpty();
	}

	@Override
	public String getAttribute(String name) {
		// TODO Auto-generated method stub
        for(Attribute attribute : attributes){
            if(attribute.getName().equals(name))
                return attribute.getValue();
        }

        return null;

	}

	@Override
	public Attribute getAttributeNode(String name) {
		// TODO Auto-generated method stub
        for(Attribute attribute : attributes){
            if(attribute.getName().equals(name))
                return attribute;
        }

        return null;

	}

	@Override
	public void setAttribute(String name, String value) throws DOMException {
        for(Attribute attribute : attributes){
            if(attribute.getName().equals(name))
                attribute.setValue(value);
        }

	}

	@Override
	public void removeAttribute(String name) throws DOMException {
		// TODO Auto-generated method stub
        for(Attribute attribute : attributes){
            if(attribute.getName().equals(name))
                attributes.remove(attribute);
        }

	}

	@Override
	public NodeList getElementsByTagName(String name) {
        List<Element> searchingElements = new ArrayList<>();

        for(Element element : childElements) {
            if (element.getTagName().equals(name))
                searchingElements.add(element);

            searchingElements.addAll(element.getElementsByTagName(name));
        }
        return searchingElements;

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

}
