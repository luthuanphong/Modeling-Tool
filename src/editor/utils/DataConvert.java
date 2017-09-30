package editor.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import editor.canvas.Clip;
import editor.canvas.ClipArc;
import editor.canvas.ClipPlace;
import editor.canvas.SensorType;
import javafx.geometry.Point2D;

public class DataConvert {
	
	public static final String SENSOR_KEY = "1";
	public static final String CHANNEL_KEY = "2";
	
	/**
	 * 
	 * @param sensorClip
	 * @param channelClip
	 * @return
	 */
	public static Topology GetConvertData(List<Clip> sensorClip, List<Clip> channelClip) {
		Topology topology = new Topology();
		topology.sensors = GetSensorConvertData(sensorClip);
		topology.channels = GetChannelConvertData(channelClip);
		return topology;
	}
	
	/**
	 * Revert data from topology file
	 * @param topology
	 */
	public static HashMap<String, List<Clip>> GetRevertData (Topology topology) {
		List<Clip> sensorClip = GetSensorClip(topology);
		List<Clip> channelClip = GetChannelClip(topology, sensorClip);
		HashMap<String, List<Clip>> map = new HashMap<>();
		map.put(SENSOR_KEY, sensorClip);
		map.put(CHANNEL_KEY, channelClip);
		return map;
	}
	
	/**
	 * Get sensor clip from file
	 * @param topology
	 * @return
	 */
	private static List<Clip> GetSensorClip (Topology topology) {
		List<Clip> list = new ArrayList<>();
		for (Sensor s : topology.sensors) {
			Clip c = new ClipPlace(new Point2D(s.X, s.Y));
			c.setStart(s.StartX,s.StartY);
			c.setEnd(s.EndX,s.EndY);
			c.setName(s.Name);
			c.setToken(Integer.parseInt(s.Token));
			c.setEnergy(s.Energy);
			c.setSensorType(s.Type);
			c.setId(s.Id);
			list.add(c);
		}
		return list;
	}
	
	/**
	 * Get channel clip from file
	 * @param topology
	 * @param sensorClip
	 * @return
	 */
	private static List<Clip> GetChannelClip (Topology topology , List<Clip> sensorClips) {
		List<Clip> list = new ArrayList<>();
		for(Channel chn : topology.channels) {
			Clip c = new ClipArc(
					new Point2D(chn.StartX, chn.StartY),
					new Point2D(chn.EndX, chn.EndY));
			c.setId(chn.Id);
			c.setName(chn.Name);
			GetRelatedSensor(sensorClips, c);
			list.add(c);
		}
		return list;
	}
	
	/**
	 * Get convert data of sensor
	 * @param sensorClip
	 */
	private static List<Sensor> GetSensorConvertData(List<Clip> sensorClip) {
		List<Sensor> list = new ArrayList<>();
		for(Clip c : sensorClip) {
			Sensor s = new Sensor();
			s.Id = c.getId();
			s.Name = c.getName();
			s.Token = c.getToken();
			s.Energy = c.getEnergy();
			s.Type = GetSensorTypeCode(c.getSensorType());
			s.X = c.getCenterX();
			s.Y = c.getCenterY();
			s.StartX = c.getStart().getX();
			s.StartY = c.getStart().getY();
			s.EndX = c.getEnd().getX();
			s.EndY = c.getEnd().getY();
			list.add(s);
		}
		return list;
	}
	
	/**
	 * Get convert data of channel
	 * @param channelClip
	 */
	private static List<Channel> GetChannelConvertData(List<Clip> channelClip) {
		List<Channel> list = new ArrayList<>();
		for(Clip c : channelClip) {
			Channel ch = new Channel();
			ch.Id = c.getId();
			ch.Name = c.getName();
			ch.StartX = c.getStart().getX();
			ch.StartY = c.getStart().getY();
			ch.EndX = c.getEnd().getX();
			ch.EndY = c.getEnd().getY();
			list.add(ch);
		}
		return list;
	}
	
	/**
	 * Return sensor type code from sensor category
	 * @param Type
	 * @return
	 */
	private static int GetSensorTypeCode (String Type) {
		switch (Type) {
		case SensorType.SOURCE:
			return 1;
		case SensorType.SINK:
			return 2;			
		case SensorType.INTERMEDIATE:
			return 3;
		default:
			return 0;
		}
	}
	
	/**
	 * Get sensor related with channel
	 * @param sensorClips
	 * @param point
	 */
	public static void GetRelatedSensor (List<Clip> sensorClips , Clip channel) {
		for (Clip c : sensorClips) {
			if(c.getCenterX() == channel.getStart().getX() && 
					c.getCenterY() == channel.getStart().getY()) {
				channel.setOutputPlace(c);
				c.getOutArc().add(channel);
			}
			if(c.getCenterX() == channel.getEnd().getX() && 
					c.getCenterY() == channel.getEnd().getY()) {
				channel.setInputPlace(c);
				c.getInputArc().add(channel);
			}
		}
	}
}
