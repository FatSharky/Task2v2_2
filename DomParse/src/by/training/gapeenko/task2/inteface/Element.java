package by.training.gapeenko.task2.inteface;
import org.w3c.dom.DOMException;

public interface Element extends Node {
	public String getTagName();

	public boolean hasAttribute(String name);

	public String getAttribute(String name);

	public Attribute getAttributeNode(String name);

	public void setAttribute(String name, String value) throws DOMException;

	public void removeAttribute(String name) throws DOMException;

	 public NodeList getElementsByTagName(String name);

	


}
