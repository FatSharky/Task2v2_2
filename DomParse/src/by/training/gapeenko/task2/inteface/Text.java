package by.training.gapeenko.task2.inteface;
import org.w3c.dom.DOMException;

public interface Text {
	public String getWholeText();

	public Text replaceWholeText(String content)
            throws DOMException;
}
