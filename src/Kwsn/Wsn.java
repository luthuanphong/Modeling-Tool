package Kwsn;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "WSN")
public class Wsn {
    @XmlElement(name = "Network")
    public Network network;
}
