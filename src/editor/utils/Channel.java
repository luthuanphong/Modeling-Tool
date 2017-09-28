package editor.utils;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Channel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Channel {
	@XmlElement(name = "Id")
	public String Id;
	@XmlElement(name = "Name")
	public String Name;
	@XmlElement(name = "StartX")
	public double StartX;
	@XmlElement(name = "StartY")
	public double StartY;
	@XmlElement(name = "EndX")
	public double EndX;
	@XmlElement(name = "EndY")
	public double EndY;
}
