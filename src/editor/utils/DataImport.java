package editor.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

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
				JAXBContext context = JAXBContext.newInstance(Topology.class);
				Unmarshaller unmarshaller = context.createUnmarshaller();
				
				Topology topology = (Topology) unmarshaller.unmarshal(filePath);			
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
			
		}
		
	}
	
	private static boolean IsExtension (String filePath , String expectedExrension) {
		String[] pathArray = filePath.split("\\.");
		return pathArray[pathArray.length - 1].equals(expectedExrension);
	}
}
