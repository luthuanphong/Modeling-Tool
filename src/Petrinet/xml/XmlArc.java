package Petrinet.xml;

import javax.xml.bind.annotation.XmlElement;

public class XmlArc extends XmlPetrinetObject {
	@XmlElement(name = "transition")
	public String transition;
	@XmlElement(name = "place")
	public String place;
	@XmlElement(name = "weight")
	public int weight;
	@XmlElement(name = "direction")
	public XmlDirection direction;
}
