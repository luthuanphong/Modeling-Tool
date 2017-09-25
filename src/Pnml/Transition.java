package Pnml;

/**
 * Created by FredLu on 02/07/2017.
 */
import javax.xml.bind.annotation.*;
@XmlRootElement(name = "transition")
public class Transition {
    @XmlAttribute(name = "id")
    public String id;
    @XmlElement(name = "label")
    public String label;
}
