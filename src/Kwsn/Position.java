package Kwsn;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Position")
public class Position {
	@XmlAttribute(name = "X")
	public double X;
	@XmlAttribute(name = "Y")
	public double Y;
}
