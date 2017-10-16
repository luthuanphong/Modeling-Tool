package Petrinet.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum XmlDirection {
	PLACE_TO_TRANSITION, 
	TRANSITION_TO_PLACE;

	public String value() {
		return name();
	}

	public static XmlDirection fromValue(String v) {
		return valueOf(v);
	}
}
