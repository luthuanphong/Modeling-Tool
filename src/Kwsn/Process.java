package Kwsn;

import javax.xml.bind.annotation.*;

public class Process {
    @XmlElement(name = "Sensors")
    public Sensors sensors;
    @XmlElement(name = "Links")
    public Links links;
}
