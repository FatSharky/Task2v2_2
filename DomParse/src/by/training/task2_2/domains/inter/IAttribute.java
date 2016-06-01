package by.training.task2_2.domains.inter;


public interface IAttribute extends INode {

	String getName();

	IElement getOwnerElement();

	String getValue();

	void setValue(String value);

	boolean isId();

}
