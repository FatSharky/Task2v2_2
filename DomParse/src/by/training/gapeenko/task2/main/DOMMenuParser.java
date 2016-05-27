package by.training.gapeenko.task2.main;
import java.io.IOException;
import java.util.List;


import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import by.training.gapeenko.task2.list.Menu;
import by.training.gapeenko.task2.parser.DomParser;
import by.training.task3.domains.Food;
import by.training.task3.domains.intefrace.IDocument;
import by.training.task3.domains.intefrace.IElement;






public class DOMMenuParser {
	
	    private static final String xmlFileURI = "E:\\epam\\Task2v2_2\\DomParse\\src\\by\\training\\gapeenko\\task2\\parser\\Menu.xml";

	    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

	        Menu menu = new Menu();

	       DomParser myParser = new DomParser(xmlFileURI);
	        IDocument document = myParser.parse();
	        IElement menuElement = document.getDocumentElement();

	            List<IElement> element = menuElement.getElementsByTagName("food");
	            Food food = null;
	            for(IElement foodElement : element) {
	                food = new Food();
	                food.setId(foodElement.getAttribute("ID"));
	                food.setPhoto(foodElement.getElementsByTagName("type").get(0).getInnerText());
	                food.setName(foodElement.getElementsByTagName("photo").get(0).getInnerText());
	                food.setDescription(foodElement.getElementsByTagName("name").get(0).getInnerText());

	                menu.addFood(food);;
	            }
	            System.out.println(menu);
	        }

	      
	    }


