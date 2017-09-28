/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Constants.TopologyConstants;
import Kwsn.Link;
import Kwsn.Sensor;
import editor.canvas.Clip;
import editor.canvas.SensorType;
import javafx.collections.ObservableList;

/**
 *
 * @author phongtl.hf
 */
public class InitializeData {
    
    private String minSensorSendingRate = "1";
    private String maxSensorSendingRate = "5";
    private String minSensorProcessingRate = "1";
    private String maxSensorProcessingRate = "5";
    private String minChannelSendingRate = "1";
    private String maxChannelSendingRate = "5";
    private String sensorMaxBufferSize = "5";
    private String sensorMaxQueueSize = "5";
    private String channelMaxBufferSize = "5";
    private String numberOfPackage = "10";
    private ObservableList<Clip> sensorClip;
    private ObservableList<Clip> channelClip;
    private List<Clip> originSensorClip;
    private List<Clip> originChannelClip;
    
    public void setMinSensorSendingRate (String value) {
        this.minSensorSendingRate = value;
    }
    
    public void setMaxSensorSendingRate (String value) {
        this.maxSensorSendingRate = value;
    }
    
    public void setMinSensorProcessingRate (String value) {
        this.minSensorProcessingRate = value;
    }
    
    public void setMaxSensorProcessingRate (String value) {
        this.maxSensorProcessingRate = value;
    }
    
    public void setMinChannelSendingRate (String value) {
        this.minChannelSendingRate = value;
    }
    
    public void setMaxChannelSendingRate (String value) {
        this.maxChannelSendingRate = value;
    }
    
    public void setNumberOfPackage (String value) {
        this.numberOfPackage = value;
    }
    
    public void setSensorClip(ObservableList<Clip> value) {
    	this.sensorClip = value;
    }
    
    public void setChannelClip (ObservableList<Clip> value) {
    	this.channelClip = value;
    }
    
    public void setOriginSensorClip (List<Clip> value) {
    	this.originSensorClip = value;
    }
    
    public void setOriginChannelClip (List<Clip> value) {
    	this.originChannelClip = value;
    }
    
    public String getMinSensorSendingRate () {
        return this.minSensorSendingRate;
    }
    
    public String getMaxSensorSendingRate () {
        return this.maxSensorSendingRate;
    }
    
    public String getMinSensorProcessingRate () {
        return this.minSensorProcessingRate;
    }
    
    public String getMaxSensorProcessingRate () {
        return this.maxSensorProcessingRate;
    }
    
    public String getMinChannelSendingRate () {
        return this.minChannelSendingRate;
    }
    
    public String getMaxChannelSendingRate () {
        return this.maxChannelSendingRate;
    }
    
    public String getNumberOfPackage () {
        return this.numberOfPackage;
    }
    
    public ObservableList<Clip> getSensorClip () {
    	return this.sensorClip;
    }
    
    public ObservableList<Clip> getChannelClip () {
    	return this.channelClip;
    }
    
    public List<Clip> getOriginalSensorClip () {
    	return this.originSensorClip;
    }
    
    public List<Clip> getOriginalChannelClip () {
    	return this.originChannelClip;
    }
    
    public HashMap<String,Object> getTopologyData () {
    	HashMap<String, Object> map = new HashMap<>();
    	//sensor
    	map.put(TopologyConstants.SENSORS_MAX_BUFFER_SIZE_KEY, this.getSensorMaxBufferSize());
    	map.put(TopologyConstants.SENSORS_MAX_QUEUE_SIZE_KEY, this.getSensorMaxQueueSize());
    	map.put(TopologyConstants.SENSORS_MAX_SENDING_RATE_KEY,this.maxSensorSendingRate);
    	map.put(TopologyConstants.SENSORS_MAX_PROCESSING_RATE_KEY, this.maxSensorProcessingRate);
    	map.put(TopologyConstants.SENSORS_MIN_SENDING_RATE_KEY, this.minSensorSendingRate);
    	map.put(TopologyConstants.SENSORS_MIN_PROCESSING_RATE_KEY,this.minSensorProcessingRate);
    	map.put(TopologyConstants.SENSORS_LIST_KEY, this.getSensorFromClip());
    	
    	map.put(TopologyConstants.CHANEL_MAX_BUFFER_SIZE_KEY, this.getChannelMaxBufferSize());
    	map.put(TopologyConstants.CHANNEL_MAX_SENDING_RATE_KEY, this.maxChannelSendingRate);
    	map.put(TopologyConstants.CHANNEL_MIN_SENDING_RATE_KEY, this.minChannelSendingRate);
    	map.put(TopologyConstants.CHANNEL_LIST_KEY, this.getChannelFromClip());
    	
    	map.put(TopologyConstants.NUMBER_OF_PACKAGE, this.numberOfPackage);
    	//Energy
    	return map;
    }

	public String getSensorMaxBufferSize() {
		return sensorMaxBufferSize;
	}

	public void setSensorMaxBufferSize(String sensorMaxBufferSize) {
		this.sensorMaxBufferSize = sensorMaxBufferSize;
	}

	public String getSensorMaxQueueSize() {
		return sensorMaxQueueSize;
	}

	public void setSensorMaxQueueSize(String sensorMaxQueueSize) {
		this.sensorMaxQueueSize = sensorMaxQueueSize;
	}

	public String getChannelMaxBufferSize() {
		return channelMaxBufferSize;
	}

	public void setChannelMaxBufferSize(String channelMaxBufferSize) {
		this.channelMaxBufferSize = channelMaxBufferSize;
	}
	
	/**
	 * Get sensor from Clip
	 */
    private List<Sensor> getSensorFromClip () {
    	List<Sensor> list = new ArrayList<>();
    	for(Clip c : this.originSensorClip) {
    		Sensor s = new Sensor();
    		s.Id = c.getId();
    		s.Name = c.getName();
    		s.energy = c.getEnergy();
    		s.token = c.getToken();
    		switch (c.getSensorType()) {
			case SensorType.SOURCE:
				s.Type = 1;
				break;
			case SensorType.SINK:
				s.Type = 2;
				break;
			case SensorType.INTERMEDIATE:
				s.Type = 3;
				break;
			default:
				break;
			}
    		list.add(s);
    	}
    	return list;
    }
    
    /**
     * Get Channel from clip 
     * @return
     */
    private List<Link> getChannelFromClip () {
    	List<Link> list = new ArrayList<>();
    	for(Clip c : this.originChannelClip) {
    		Link l = new Link();
    		l.id = c.getId();
    		l.From = c.getOutputPlace().getId();
    		l.To = c.getInputPlace().getId();
    	}
     	return list;
    }
}
