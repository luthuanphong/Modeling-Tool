package editor.utils;

import java.util.ArrayList;
import java.util.List;

import editor.canvas.Clip;
import editor.canvas.SensorType;

public class DataConvert {
	
	public static Topology GetConvertData(List<Clip> sensorClip, List<Clip> channelClip) {
		Topology topology = new Topology();
		topology.sensors = GetSensorConvertData(sensorClip);
		topology.channels = GetChannelConvertData(channelClip);
		return topology;
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
			s.startX = c.getStart().getX();
			s.startY = c.getStart().getY();
			s.endX = c.getEnd().getX();
			s.endY = c.getEnd().getY();
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
}
