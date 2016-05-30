package by.traning.task4.factory;

import by.traning.task4.dom.DomParser;
import by.traning.task4.domains.interfaces.IDomParser;

public class DomFactory {
	private static final DomFactory factory = new DomFactory();
	public DomFactory() {
		
	}
	public static DomFactory getInstance()  {
		return factory;
	}
	public IDomParser getDomParser(){
		return new DomParser();
	}
	
}
