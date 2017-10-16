package Petrinet.xml;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "net")
public class XmlPetrinet {
	@XmlElement(name = "name")
	public String name;
	@XmlElement(name = "place")
	public ArrayList<XmlPlace> places = new ArrayList<XmlPlace>();
	@XmlElement(name = "transition")
	public ArrayList<XmlTransition> transitions = new ArrayList<XmlTransition>();
	@XmlElement(name = "arc")
	public ArrayList<XmlArc> arcs = new ArrayList<XmlArc>();
}
