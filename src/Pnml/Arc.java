package Pnml;

/**
 * Created by FredLu on 02/07/2017.
 */
import javax.xml.bind.annotation.*;
@XmlRootElement(name = "arc")
public class Arc {
    @XmlAttribute(name = "name")
    public String id;
    @XmlElement(name = "label")
    public String label;
    @XmlElement(name = "transition")
    public String transition;
    @XmlElement(name = "place")
    public String place;
    @XmlElement(name = "weight")
    public int weight;
    @XmlElement(name = "direction")
    public ArcDirection direction;
}
