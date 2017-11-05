package editor.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import Kwsn.*;
import Kwsn.Process;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import editor.canvas.Clip;
import editor.canvas.SensorType;
import editor.views.EditorWindow;

public class DataExport {
	
	/**
	 * Export topology data to file
	 * @param filePath file path
	 * @param sensorClip list of sensor
	 * @param channelClip list of channel
	 */
	public static void Export(String filePath, List<Clip> sensorClip, List<Clip> channelClip, EditorWindow editor) {
		try {
			InitializeData configData = editor.getData();
			CommonData commonData = new CommonData();
			commonData.maxSensorSendingRate = configData.getMaxSensorSendingRate();
			commonData.maxSensorProcessingRate = configData.getMaxSensorProcessingRate();
			commonData.maxChannelSendingRate = configData.getMaxChannelSendingRate();
			commonData.minSensorSendingRate = configData.getMinSensorSendingRate();
			commonData.minSensorProcessingRate = configData.getMinSensorProcessingRate();
			commonData.minChannelSendingRate = configData.getMinChannelSendingRate();
			commonData.sensorMaxBufferSize = configData.getSensorMaxBufferSize();
			commonData.sensorMaxQueueSize = configData.getSensorMaxQueueSize();
			commonData.channelMaxBufferSize = configData.getChannelMaxBufferSize();
			commonData.numberOfPackage = configData.getNumberOfPackage();
			
			Topology topology = DataConvert.GetConvertData(sensorClip, channelClip);
			topology.data = commonData;
			JAXBContext context = JAXBContext.newInstance(Topology.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(topology, new File(filePath));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void ExportKwsn (String filePath, List<Clip> sensorClip, List<Clip> channelClip, EditorWindow editor) {
		try {
			InitializeData configData = editor.getData();
			Wsn wsn = new Wsn();
			wsn.network = new Network();
			wsn.network.NumberOfPacket = configData.getNumberOfPackage();
			wsn.network.SensorMaxBufferSize = configData.getSensorMaxBufferSize();
			wsn.network.SensorMaxQueueSize = configData.getSensorMaxQueueSize();
			wsn.network.ChannelMaxBufferSize = configData.getChannelMaxBufferSize();
			wsn.network.processes = new ArrayList<>();
			Process currentProcess = new Process();
			wsn.network.processes.add(currentProcess);
			currentProcess.sensors = new Sensors();
			currentProcess.sensors.listSensor = new ArrayList<>();
			currentProcess.links = new Links();
			currentProcess.links.listLink = new ArrayList<>();
			for (Clip c : sensorClip) {
				Kwsn.Sensor s = new Kwsn.Sensor();
				s.Id = c.getId();
				s.Name = c.getName();
				s.MaxProcessingRate = configData.getMaxSensorProcessingRate();
				s.MaxSendingRate = configData.getMaxSensorSendingRate();
				if (c.getSensorType().equals(SensorType.SOURCE)) {
					s.Init = "True";
					s.Type = 1;
					s.token = c.getToken();
				} else {
					s.Init = "False";
					if(c.getSensorType().equals(SensorType.SINK)) {
						s.Type = 2;
					}else {
						s.Type = 3;
					}
				}
				s.pos = new Position();
				s.pos.X = c.getCenterX() / 100.0;
				s.pos.Y = c.getCenterY() / 100.0;
				s.energy = c.getEnergy();
				currentProcess.sensors.listSensor.add(s);
			}
			
			for (Clip c : channelClip) {
				Kwsn.Link l = new Link();
				l.id = c.getId();
				l.MaxSendingRate = configData.getMaxChannelSendingRate();
				l.From = c.getOutputPlace().getName();
				l.To = c.getInputPlace().getName();
				currentProcess.links.listLink.add(l);
			}
			
			JAXBContext context = JAXBContext.newInstance(Wsn.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(wsn, new File(filePath));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
