package Pnml;

/**
 * Created by FredLu on 02/07/2017.
 */
import javax.xml.bind.annotation.*;
@XmlRootElement(name = "pnml")
public class Pnml {
    @XmlElement(name = "net")
    public Net net;

    public Pnml(){
        this.net = new Net();
    }
}
