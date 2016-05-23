import java.io.IOException;
import java.util.List;


import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import by.training.gapeenko.task2.entity.Food;
import by.training.gapeenko.task2.inteface.Document;
import by.training.gapeenko.task2.inteface.Element;
import by.training.gapeenko.task2.list.Menu;
import by.training.gapeenko.task2.parser.DomParser;






public class DOMMenuParser {
	
	    private static final String xmlFileURI = "E:\\epam\\Task2v2_2\\DomParse\\Menu.xml";

	    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

	        Menu menu = new Menu();

	       DomParser myParser = new DomParser(xmlFileURI);
	        Document document = myParser.parse();
	        Element menuElement = document.getDocumentElement();

	            List<Element> element = menuElement.getElementsByTagName("food");
	            Food food = null;
	            for(Element foodElement : element) {
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


