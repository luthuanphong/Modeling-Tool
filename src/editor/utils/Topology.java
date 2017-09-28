package editor.utils;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Topology")
public class Topology {
	@XmlElement(name = "Sensor")
	public List<Sensor> sensors;
	@XmlElement(name = "Channel")
	public List<Channel> channels;
	
}
