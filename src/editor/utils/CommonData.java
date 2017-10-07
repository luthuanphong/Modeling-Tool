package editor.utils;

import javax.xml.bind.annotation.XmlElement;

public class CommonData {
	@XmlElement
	public String minSensorSendingRate;
	@XmlElement
	public String maxSensorSendingRate;   
	@XmlElement
	public String minSensorProcessingRate;
	@XmlElement
	public String maxSensorProcessingRate;
	@XmlElement
	public String minChannelSendingRate;
	@XmlElement
	public String maxChannelSendingRate;
	@XmlElement
	public String sensorMaxBufferSize;
	@XmlElement
	public String sensorMaxQueueSize;
	@XmlElement
	public String channelMaxBufferSize;
	@XmlElement
	public String numberOfPackage; 
}
