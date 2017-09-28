package editor.utils;

import javax.xml.bind.annotation.*;
@XmlRootElement(name = "Sensor")
@XmlAccessorType(XmlAccessType.FIELD)
public class Sensor {
	
	@XmlElement(name = "Id")
	public String Id;
	@XmlElement(name = "Name")
	public String Name;
	@XmlElement(name = "Token")
	public String Token;
	@XmlElement(name = "Energy")
	public float Energy;
	@XmlElement(name = "Type")
	public int Type;
	@XmlElement(name = "StartX")
	public double startX;
	@XmlElement(name = "StartY")
	public double startY;
	@XmlElement(name = "EndX")
	public double endX;
	@XmlElement(name = "EndY")
	public double endY;
}
