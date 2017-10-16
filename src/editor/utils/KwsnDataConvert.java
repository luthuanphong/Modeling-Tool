package editor.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Kwsn.Link;
import editor.canvas.Clip;
import editor.canvas.ClipArc;
import editor.canvas.ClipPlace;
import javafx.geometry.Point2D;

public class KwsnDataConvert {
	
	public static final String SENSOR_KEY = "1";
	public static final String CHANNEL_KEY = "2";
	
	public static HashMap<String,List<Clip>> GetData(List<Kwsn.Sensor> sensors, List<Kwsn.Link> links) {
		HashMap<String, List<Clip>> map = new HashMap<>();
		List<Clip> sensorsClip = GetSensorClip(sensors);
		List<Clip> channelsClip = GetChannelClip(sensorsClip, links);
		for(Clip c : sensorsClip) {
			c.setName(c.getId());
		}
		map.put(SENSOR_KEY, sensorsClip);
		map.put(CHANNEL_KEY, channelsClip);
		return map;
	}
	
	private static List<Clip> GetSensorClip (List<Kwsn.Sensor> sensors) {
		
		List<Clip> list = new ArrayList<Clip>();
		
		for(Kwsn.Sensor s : sensors) {
			Clip c =  new ClipPlace(new Point2D(s.pos.X*100, s.pos.Y*100));
			c.setStart(c.getCenterX()-16,c.getCenterY()-16);
			c.setEnd(c.getCenterX()+16,c.getCenterY()+16);
			c.setName(s.Name);
			c.setId(s.Id);
			c.setEnergy(s.energy);
			switch (s.Type) {
			case 1:
				c.setSensorType(1);
				c.setToken(1);
				break;
			case 2:
				c.setSensorType(2);
				break;
			case 3:
				c.setSensorType(3);
				break;
			default:
				break;
			}
			list.add(c);
		}
		
		return list;
	}
	
	private static List<Clip> GetChannelClip (List<Clip> sensors ,List<Kwsn.Link> links) {
		List<Clip> list = new ArrayList<>();
		for(Link link : links) {
			Clip from = GetRelatedSensorClip(sensors, link.From);
			Clip to = GetRelatedSensorClip(sensors, link.To);
			Clip c = new ClipArc(new Point2D(from.getCenterX(), from.getCenterY()),
					new Point2D(to.getCenterX(), to.getCenterY()));
			c.setId(link.id);
			c.setName(link.id);
			c.setOutputPlace(from);
			c.setInputPlace(to);
			from.getOutArc().add(c);
			to.getInputArc().add(c);
			list.add(c);
		}
		return list;
	}
	
	private static Clip GetRelatedSensorClip (List<Clip> sensors, String name) {
		for(Clip c : sensors) {
			if(c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}
}
