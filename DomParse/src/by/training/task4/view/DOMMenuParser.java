package by.training.task4.view;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import by.training.task4.domains.Dish;
import by.training.task4.domains.Kind;
import by.training.task4.domains.Menu;
import by.traning.task4.domains.interfaces.IDocument;
import by.traning.task4.domains.interfaces.IDomParser;
import by.traning.task4.domains.interfaces.IElement;
import by.traning.task4.domains.interfaces.ITagNames;
import by.traning.task4.domains.interfaces.IVariables;
import by.traning.task4.factory.DomFactory;

public class DOMMenuParser implements IVariables, ITagNames {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

		Menu menu = new Menu();

		DomFactory domParserFactory = DomFactory.getInstance();
		IDomParser domParser = domParserFactory.getDomParser();
		domParser.setXMLFile(XML_FILE_URI);
		IDocument document = domParser.parse();

		IElement menuElement = document.getDocumentElement();
		List<IElement> kindElements = menuElement.getElementsByTagName(KIND_TAG);
		for (IElement kindElement : kindElements) {
			Kind kind = new Kind();
			kind.setName(kindElement.getElementsByTagName(KIND_NAME_TAG).get(0).getInnerText());
			menu.addKind(kind);

			List<IElement> dishElements = kindElement.getElementsByTagName(DISH_TAG);
			for (IElement dishElement : dishElements) {
				Dish dish = new Dish();
				dish.setPhoto(dishElement.getElementsByTagName(PHOTO_TAG).get(0).getInnerText());
				dish.setName(dishElement.getElementsByTagName(NAME_TAG).get(0).getInnerText());
				dish.setDescription(dishElement.getElementsByTagName(DESCRIPTION_TAG).get(0).getInnerText());
				dish.setPortion(dishElement.getElementsByTagName(PORTION_TAG).get(0).getInnerText());
				dish.setPrice(Integer.parseInt(dishElement.getElementsByTagName(PRICE_TAG).get(0).getInnerText()));
				kind.addDish(dish);
			}
		}

		System.out.println("Меню:\n");
		for (Kind kind : menu.getKinds()) {
			System.out.println(kind.getName());
			for (Dish dish : kind.getDishes()) {
				System.out.println("Фото: " + dish.getPhoto() + " Название: " + dish.getName() + " Описание: "
						+ dish.getDescription() + " Порция: " + dish.getPortion() + " Цена: " + dish.getPrice());
			}
		}
	}

}
