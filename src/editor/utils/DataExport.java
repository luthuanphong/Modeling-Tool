package editor.utils;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import editor.canvas.Clip;

public class DataExport {
	
	/**
	 * Export topology data to file
	 * @param filePath file path
	 * @param sensorClip list of sensor
	 * @param channelClip list of channel
	 */
	public static void Export(String filePath, List<Clip> sensorClip, List<Clip> channelClip) {
		try {
			Topology topology = DataConvert.GetConvertData(sensorClip, channelClip);
			JAXBContext context = JAXBContext.newInstance(Topology.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(topology, new File(filePath));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
