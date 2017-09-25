package Pnml;

/**
 * Created by FredLu on 02/07/2017.
 */
import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement(name = "net")
public class Net {
    @XmlElement(name = "name")
    public String Name;
    @XmlElement(name = "place")
    public ArrayList<Place> places;
    @XmlElement(name = "transition")
    public ArrayList<Transition> transitions;
    @XmlElement(name = "arc")
    public ArrayList<Arc> arcs;

    public Net(){
        places = new ArrayList<Place>();
        transitions = new ArrayList<Transition>();
        arcs = new ArrayList<Arc>();
    }
}
