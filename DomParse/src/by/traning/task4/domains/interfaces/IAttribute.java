package by.traning.task4.domains.interfaces;

public interface IAttribute extends INode {

	String getName();

	IElement getOwnerElement();

	String getValue();

	void setValue(String value);

	boolean isId();

}
