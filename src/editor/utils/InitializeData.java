/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editor.utils;

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
}
