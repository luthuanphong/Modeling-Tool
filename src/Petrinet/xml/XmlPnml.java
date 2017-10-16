package Petrinet.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pnml")
public class XmlPnml {
	@XmlElement(name = "net")
	public XmlPetrinet petrinet;
}
