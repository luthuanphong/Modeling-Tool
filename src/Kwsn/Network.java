package Kwsn;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

public class Network {
    @XmlAttribute(name = "SensorMaxBufferSize")
    public String SensorMaxBufferSize;
    @XmlAttribute(name = "SensorMaxQueueSize")
    public String SensorMaxQueueSize;
    @XmlAttribute(name = "ChannelMaxBufferSize")
    public String ChannelMaxBufferSize;
    @XmlElement(name = "Process")
    public ArrayList<Process> processes = new ArrayList<>();
    @XmlAttribute(name = "NumberOfPackets")
    public String NumberOfPacket;
}
