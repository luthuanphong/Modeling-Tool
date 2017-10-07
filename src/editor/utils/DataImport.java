package editor.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import Constants.TopologyConstants;
import Kwsn.KwsnFileReader;
import Kwsn.Sensor;
import editor.canvas.Clip;
import editor.views.EditorWindow;

public class DataImport {

	/**
	 * 
	 * @param filePath
	 * @param editor
	 */
	public static void Import (File filePath, EditorWindow editor) {
		
		if(IsExtension(filePath.getAbsolutePath(), "topo")) {
			try {
				InitializeData configData = editor.getData();
				JAXBContext context = JAXBContext.newInstance(Topology.class);
				Unmarshaller unmarshaller = context.createUnmarshaller();
				
				Topology topology = (Topology) unmarshaller.unmarshal(filePath);	
				configData.setMinSensorSendingRate(topology.data.minSensorSendingRate);
				configData.setMinSensorProcessingRate(topology.data.minSensorProcessingRate);
				configData.setMinChannelSendingRate(topology.data.minChannelSendingRate);
				configData.setMaxSensorSendingRate(topology.data.maxSensorSendingRate);
				configData.setMaxSensorProcessingRate(topology.data.maxSensorProcessingRate);
				configData.setMaxChannelSendingRate(topology.data.maxChannelSendingRate);
				configData.setSensorMaxBufferSize(topology.data.sensorMaxBufferSize);
				configData.setSensorMaxQueueSize(topology.data.sensorMaxQueueSize);
				configData.setChannelMaxBufferSize(topology.data.channelMaxBufferSize);
				configData.setNumberOfPackage(topology.data.numberOfPackage);
				HashMap<String, List<Clip>> map = DataConvert.GetRevertData(topology);
				List<Clip> sensorClips = map.get(DataConvert.SENSOR_KEY);
				List<Clip> channelClips = map.get(DataConvert.CHANNEL_KEY);
				for(Clip c : sensorClips) {
					editor.getBoard().addClip(c);
				}
				
				for(Clip c : channelClips) {
					editor.getBoard().addClip(c);
				}
				
				editor.updateBoard();
				
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(IsExtension(filePath.getAbsolutePath(), "kwsn")) {
			HashMap<String,Object> topologyData = KwsnFileReader.getInstance().readKwsn(filePath.getAbsolutePath());
			InitializeData configData = editor.getData();
			configData.setMinSensorSendingRate((String)topologyData.get(TopologyConstants.SENSORS_MIN_SENDING_RATE_KEY));
			configData.setMinSensorProcessingRate((String)topologyData.get(TopologyConstants.SENSORS_MIN_PROCESSING_RATE_KEY));
			configData.setMinChannelSendingRate((String)topologyData.get(TopologyConstants.CHANNEL_MIN_SENDING_RATE_KEY));
			configData.setMaxSensorSendingRate((String)topologyData.get(TopologyConstants.SENSORS_MAX_SENDING_RATE_KEY));
			configData.setMaxSensorSendingRate((String)topologyData.get(TopologyConstants.SENSORS_MAX_PROCESSING_RATE_KEY));
			configData.setMaxChannelSendingRate((String)topologyData.get(TopologyConstants.CHANNEL_MAX_SENDING_RATE_KEY));
			configData.setSensorMaxBufferSize((String)topologyData.get(TopologyConstants.SENSORS_MAX_BUFFER_SIZE_KEY));
			configData.setSensorMaxQueueSize((String)topologyData.get(TopologyConstants.SENSORS_MAX_QUEUE_SIZE_KEY));
			configData.setChannelMaxBufferSize((String)topologyData.get(TopologyConstants.CHANEL_MAX_BUFFER_SIZE_KEY));
			configData.setNumberOfPackage((String)topologyData.get(TopologyConstants.NUMBER_OF_PACKAGE));
			
			List<Kwsn.Sensor> sensors =(List<Sensor>) topologyData.get(TopologyConstants.SENSORS_LIST_KEY);
			List<Kwsn.Link> links = (List<Kwsn.Link>) topologyData.get(TopologyConstants.CHANNEL_LIST_KEY);
			
			HashMap<String,List<Clip>> map = KwsnDataConvert.GetData(sensors, links);
			List<Clip> sensorClips = map.get(KwsnDataConvert.SENSOR_KEY);
			List<Clip> channelClips = map.get(KwsnDataConvert.CHANNEL_KEY);
			
			for(Clip c : sensorClips) {
				editor.getBoard().addClip(c);
			}
			
			for(Clip c : channelClips) {
				editor.getBoard().addClip(c);
			}
			
			editor.updateBoard();
		}
		
	}
	
	private static boolean IsExtension (String filePath , String expectedExrension) {
		String[] pathArray = filePath.split("\\.");
		return pathArray[pathArray.length - 1].equals(expectedExrension);
	}
}
