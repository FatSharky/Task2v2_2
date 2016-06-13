package by.training.task2_2.factory;

import by.training.task2_2.dom.DomParser;
import by.training.task2_2.domains.inter.IDomParser;

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
