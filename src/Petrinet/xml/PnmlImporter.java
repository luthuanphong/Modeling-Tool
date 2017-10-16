package Petrinet.xml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Petrinet.Arc;
import Petrinet.Pnml;
import Petrinet.Petrinet;
import Petrinet.Place;
import Petrinet.Transition;

public class PnmlImporter {
	private XmlPnml xmlPnml;
	private IdToXmlObject idToXmlObject;
	private Map<Object, Object> map = new HashMap<Object, Object>();

	public Pnml readFromFile(String path) throws JAXBException, IOException {

		// create JAXB context and initializing Unmarshaller
		JAXBContext context = JAXBContext.newInstance(XmlPnml.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		// this will create Java object - pnml from the XML file
		xmlPnml = (XmlPnml) unmarshaller.unmarshal(new File(path));

		idToXmlObject = new IdToXmlObject(xmlPnml);

		return getPnml();
	}
	
	private Pnml getPnml() {
		Pnml pnml = new Pnml();
		Petrinet petrinet = getNewPetrinet(xmlPnml.petrinet);
		pnml.setPetrinet(petrinet);
		return pnml;
	}

	private Object getObjectFromId(String id) {
		return getObject(idToXmlObject.getXmlObject(id));
	}

	private Object getObject(Object xmlObject) {
		if (map.containsKey(xmlObject)) {
			return map.get(xmlObject);
		}

		Object object = null;

		if (xmlObject instanceof XmlPlace) {
			object = getNewPlace((XmlPlace) xmlObject);
		}
		if (xmlObject instanceof XmlArc) {
			object = getNewArc((XmlArc) xmlObject);
		}
		if (xmlObject instanceof XmlTransition) {
			object = getNewTransition((XmlTransition) xmlObject);
		}
		if (xmlObject instanceof XmlPetrinet) {
			object = getNewPetrinet((XmlPetrinet) xmlObject);
		}
		if (object != null) {
			map.put(xmlObject, object);
		}

		return object;
	}

	private Petrinet getNewPetrinet(XmlPetrinet xmlPetrinet) {

		Petrinet petrinet = new Petrinet(xmlPetrinet.name);

		for (XmlPlace xmlPlace : xmlPetrinet.places) {
			petrinet.add((Place) getObject(xmlPlace));
		}

		for (XmlTransition xmlTransition : xmlPetrinet.transitions) {
			petrinet.add((Transition) getObject(xmlTransition));
		}
		
		for (XmlArc xmlArc : xmlPetrinet.arcs) {
			petrinet.add((Arc) getObject(xmlArc));
		}

		return petrinet;
	}

	private Place getNewPlace(XmlPlace xmlPlace) {
		Place place = new Place(xmlPlace.id, xmlPlace.label, xmlPlace.token);
		return place;
	}

	private Transition getNewTransition(XmlTransition xmlTransition) {
		Transition transition = new Transition(xmlTransition.id, xmlTransition.label);
		return transition;
	}

	private Arc getNewArc(XmlArc xmlArc) {
		Arc arc = null;
		if (xmlArc.direction == XmlDirection.PLACE_TO_TRANSITION) {
			arc = new Arc(xmlArc.id, xmlArc.label, (Place) getObjectFromId(xmlArc.place),
					(Transition) getObjectFromId(xmlArc.transition), xmlArc.weight);
		} else if (xmlArc.direction == XmlDirection.TRANSITION_TO_PLACE) {
			arc = new Arc(xmlArc.id, xmlArc.label, (Transition) getObjectFromId(xmlArc.transition),
					(Place) getObjectFromId(xmlArc.place), xmlArc.weight);
		}
		return arc;
	}
}
