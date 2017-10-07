package Kwsn;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Position")
public class Position {
	@XmlAttribute(name = "X")
	public float X;
	@XmlAttribute(name = "Y")
	public float Y;
}
