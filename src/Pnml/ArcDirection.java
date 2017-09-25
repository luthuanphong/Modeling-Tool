package Pnml;

/**
 * Created by FredLu on 02/07/2017.
 */
import javax.xml.bind.annotation.*;
@XmlType
@XmlEnum(String.class)
public enum ArcDirection {
    PLACE_TO_TRANSITION,
    TRANSITION_TO_PLACE;

    public String value() {
        return name();
    }

    public static ArcDirection fromValue(String v) {
        return valueOf(v);
    }
}
