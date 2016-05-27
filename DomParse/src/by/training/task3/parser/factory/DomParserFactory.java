package by.training.task3.parser.factory;

public final class DomParserFactory {
	private static final DomParserFactory factory = new DomParserFactory();

	 public static DomParserFactory getInstance() { 
		          return factory; 
		    } 

}
