package editor.utils;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import editor.canvas.Clip;
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
	
}
