package Petrinet.xml;

import javax.xml.bind.annotation.XmlElement;

public class XmlPlace extends XmlPetrinetObject {
	@XmlElement(name = "token")
	public int token;
}
