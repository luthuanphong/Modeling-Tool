package Petrinet.xml;

import java.util.HashMap;
import java.util.Map;

public class IdToXmlObject {
	private XmlPnml xmlPnml;
	private Map<String, Object> map = new HashMap<String, Object>();

	public IdToXmlObject(XmlPnml xmlPnml) {
		this.xmlPnml = xmlPnml;
	}

	public Object getXmlObject(String id) {
		if (id.equals(null)) {
			return null;
		}
		
		if (id.equals("")) {
			return null;
		}

		if (map.containsKey(id)) {
			return map.get(id);
		}

		Object xmlObject = getXmlObjectFromXmlPetrinet(id, xmlPnml.petrinet);

		if (xmlObject != null) {
			map.put(id, xmlObject);
		}

		return xmlObject;
	}

	private Object getXmlObjectFromXmlPetrinet(String id, XmlPetrinet xmlPetrinet) {
		for (XmlPlace xmlPlace : xmlPetrinet.places) {
			if (xmlPlace.id.equals(id)) {
				return xmlPlace;
			}
		}

		for (XmlTransition xmlTransition : xmlPetrinet.transitions) {
			if (xmlTransition.id.equals(id)) {
				return xmlTransition;
			}
		}

		for (XmlArc xmlArc : xmlPetrinet.arcs) {
			if (xmlArc.id.equals(id)) {
				return xmlArc;
			}
		}

		return null;
	}
}
