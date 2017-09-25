package Kwsn;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Sensors")
public class Sensors {
    @XmlElement(name = "Sensor")
    public ArrayList<Sensor> listSensor = new ArrayList<>();
}
