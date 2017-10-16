package Petrinet.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class XmlTransition extends XmlPetrinetObject {
	@XmlElement(name = "incoming")
	public ArrayList<XmlArc> incoming = new ArrayList<XmlArc>();
	@XmlElement(name = "outgoing")
	public ArrayList<XmlArc> outgoing = new ArrayList<XmlArc>();
}
