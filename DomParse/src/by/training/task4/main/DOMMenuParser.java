package by.training.task4.main;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import by.training.task2_2.domains.Dish;
import by.training.task2_2.domains.Kind;
import by.training.task2_2.domains.Menu;
import by.training.task2_2.domains.inter.IDocument;
import by.training.task2_2.domains.inter.IDomParser;
import by.training.task2_2.domains.inter.IElement;
import by.training.task2_2.factory.DomFactory;

public class DOMMenuParser {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

		Menu menu = new Menu();

		DomFactory domParserFactory = DomFactory.getInstance();
		IDomParser domParser = domParserFactory.getDomParser();
		domParser.setXMLFile(KindNames.XML_FILE_URI);
		IDocument document = domParser.parse();

		IElement menuElement = document.getDocumentElement();
		List<IElement> kindElements = menuElement.getElementsByTagName(KindNames.KIND_TAG);
		for (IElement kindElement : kindElements) {
			Kind kind = new Kind();
			kind.setName(kindElement.getElementsByTagName(KindNames.KIND_NAME_TAG).get(0).getInnerText());
			menu.addKind(kind);

			List<IElement> dishElements = kindElement.getElementsByTagName(KindNames.DISH_TAG);
			for (IElement dishElement : dishElements) {
				Dish dish = new Dish();
				dish.setPhoto(dishElement.getElementsByTagName(KindNames.PHOTO_TAG).get(0).getInnerText());
				dish.setName(dishElement.getElementsByTagName(KindNames.NAME_TAG).get(0).getInnerText());
				dish.setDescription(dishElement.getElementsByTagName(KindNames.DESCRIPTION_TAG).get(0).getInnerText());
				dish.setPortion(dishElement.getElementsByTagName(KindNames.PORTION_TAG).get(0).getInnerText());
				dish.setPrice(Integer.parseInt(dishElement.getElementsByTagName(KindNames.PRICE_TAG).get(0).getInnerText()));
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
