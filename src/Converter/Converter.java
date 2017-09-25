package Converter;

import Constants.TopologyConstants;
import Kwsn.Link;
import Kwsn.Sensor;

import java.util.HashMap;
import java.util.List;

public abstract class Converter {

    protected HashMap<String , Object> topologyData;

    /*Public method region*/

    /**
     * set topology data got from kwsn file or user input on GUI
     * @param data
     */
    public void setTopologyData (HashMap<String,Object> data) {
        this.topologyData = data;
    }

    /**
     * Output the pnml file based on topology data
     * @param folderPath output folder path
     */
    public abstract void outputPnmlFile (String folderPath);

    /**
     * Output the transition process file in normal mode
     * @param folderPath output folder path
     */
    public abstract void outputProcessFile (String folderPath);

    /**
     * Output the transition prcess file in minimize mode
     * @param folderPath output folder path
     */
    public abstract void outputMinimizeProcessFile (String folderPath);

    /*Protected method region*/

    /**
     * Get list of sensor
     * @return list of sensor
     */
    protected List<Sensor> getListSensor () {
        return (List<Sensor>)
                this.topologyData.getOrDefault(TopologyConstants.SENSORS_LIST_KEY,null);
    }

    /**
     * Get list of channel
     * @return list of channel
     */
    protected List<Link> getListChannel () {
        return (List<Link>)
                this.topologyData.getOrDefault(TopologyConstants.CHANNEL_LIST_KEY,null);
    }

    /**
     * Get sensor max buffer size got from kwns file or user input on GUI
     * @return max buffer size in string type or null
     */
    protected String getSensorMaxBufferSize () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.SENSORS_MAX_BUFFER_SIZE_KEY,null);
    }

    /**
     * Get sensor max queue size got from kwsn file or user input on GUI
     * @return max queue size in string type or null
     */
    protected String getSensorMaxQueueSize () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.SENSORS_MAX_QUEUE_SIZE_KEY, null);
    }

    /**
     * Get channel max buffer size got from kwns file or user input on GUI
     * @return
     */
    protected String getChannelMaxBufferSize () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.CHANEL_MAX_BUFFER_SIZE_KEY, null);
    }

    /**
     * Get sensor max sending rate value
     * @return value in string type or null
     */
    protected String getSensorMaxSendingRate () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.SENSORS_MAX_SENDING_RATE_KEY , null);
    }

    /**
     * Get sensor max processing rate value
     * @return value in string type or null
     */
    protected String getSensorMaxProcessingRate () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.SENSORS_MAX_PROCESSING_RATE_KEY, null);
    }

    /**
     * Get channel max sending rate value
     * @return value in string type or null
     */
    protected String getChannelMaxSendingRate () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.CHANNEL_MAX_SENDING_RATE_KEY, null);
    }

    /**
     * Get number of package will send
     * @return
     */
    public String getNumberOfPackage () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.NUMBER_OF_PACKAGE,null);
    }

    /**
     * Get minimum sensor sending rate
     * @return sending rate
     */
    public String getSensorMinSendingRate () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.SENSORS_MIN_SENDING_RATE_KEY,null);
    }

    /**
     * Get minimum sensor processing rate
     * @return processing rate
     */
    public String getSensorMinProcessingRate () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.SENSORS_MIN_PROCESSING_RATE_KEY,null);
    }

    /**
     * Get minimum channel sending rate
     * @return sending rate
     */
    public String getChannelMinSendingRate () {
        return (String)
                this.topologyData.getOrDefault(TopologyConstants.CHANNEL_MIN_SENDING_RATE_KEY,null);
    }

    /**
     * Get energy rule
     * @return return energy rule in map datastruct or null
     */
    protected HashMap<String , String > getEnergyRule () {
        return (HashMap<String , String>)
                this.topologyData.getOrDefault(TopologyConstants.ENERGY_RULES_LIST_KEY,null);
    }
}
