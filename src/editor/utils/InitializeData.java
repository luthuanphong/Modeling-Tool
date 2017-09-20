/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.utils;

import java.util.List;
import java.util.Map;

import editor.canvas.Clip;
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
}
