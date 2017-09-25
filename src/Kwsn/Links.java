package Kwsn;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Links")
public class Links {
    @XmlElement(name = "Link")
    public ArrayList<Link> listLink = new ArrayList<>();
}
