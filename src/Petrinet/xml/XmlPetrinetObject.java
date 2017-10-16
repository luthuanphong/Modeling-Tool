package Petrinet.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class XmlPetrinetObject {
	@XmlAttribute(name = "id")
	public String id;
	@XmlElement(name = "label")
	public String label;
}
