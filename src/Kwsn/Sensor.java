package Kwsn;

import Converter.Sensor.BaseSensor;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Sensor")
public class Sensor {
    public String MinSendingRate;
    public String MinProcessingRate;
    @XmlAttribute(name = "MaxSendingRate")
    public String MaxSendingRate;
    @XmlAttribute(name = "MaxProcessingRate")
    public String MaxProcessingRate;
    @XmlAttribute(name = "id")
    public String Id;
    @XmlAttribute(name = "Name")
    public String Name;
    @XmlAttribute(name = "Init")
    public String Init;
    @XmlAttribute(name = "SType")
    public int Type;
    @XmlElement(name = "Position")
    public Position pos;
    @XmlAttribute(name = "Energy")
    public float energy;
    @XmlAttribute(name = "Token")
    public String token;
    public BaseSensor pnmlSensor;
    

}
