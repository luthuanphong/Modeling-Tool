package Kwsn;

import Constants.EnergyConstants;
import Constants.TopologyConstants;

import java.io.File;
import java.util.HashMap;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class KwsnFileReader {

    /*Global instance*/
    private static KwsnFileReader fileReader;

    /*Get global instance*/
    public static KwsnFileReader getInstance(){
        if (fileReader == null) {
            fileReader = new KwsnFileReader();
        }

        return fileReader;
    }

    /*Private constructor only used to create a global instance*/
    private KwsnFileReader () {

    }

    /**
     * Read kwsn file
     * @param filePath kwsn file path
     * @return HashMap data
     */
    public HashMap<String,Object> readKwsn (String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wsn.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Wsn wsn = (Wsn) unmarshaller.unmarshal(new File(filePath));

            HashMap<String , Object> kwsnData = new HashMap<>();
            processData(kwsnData,wsn);

            return kwsnData;

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Get data to in wsn and store in Map
     * @param data HashMap used to store data
     * @param wsn Kwsn data readed from kwsn file
     */
    private void processData (HashMap<String ,Object> data,Wsn wsn) {

        data.put(TopologyConstants.SENSORS_MAX_BUFFER_SIZE_KEY,
                wsn.network.SensorMaxBufferSize);
        data.put(TopologyConstants.SENSORS_MAX_QUEUE_SIZE_KEY,
                wsn.network.SensorMaxQueueSize);
        data.put(TopologyConstants.CHANEL_MAX_BUFFER_SIZE_KEY,
                wsn.network.ChannelMaxBufferSize);
        data.put(TopologyConstants.SENSORS_MAX_PROCESSING_RATE_KEY,
                wsn.network.processes.get(0).sensors.listSensor.get(0).MaxProcessingRate);
        data.put(TopologyConstants.SENSORS_MAX_SENDING_RATE_KEY,
                wsn.network.processes.get(0).sensors.listSensor.get(0).MaxSendingRate);
        data.put(TopologyConstants.CHANNEL_MAX_SENDING_RATE_KEY,
                wsn.network.processes.get(0).links.listLink.get(0).MaxSendingRate);
        data.put(TopologyConstants.SENSORS_LIST_KEY,
                wsn.network.processes.get(0).sensors.listSensor);
        data.put(TopologyConstants.CHANNEL_LIST_KEY,
                wsn.network.processes.get(0).links.listLink);
        data.put(TopologyConstants.NUMBER_OF_PACKAGE,wsn.network.NumberOfPacket);
        data.put(TopologyConstants.SENSORS_MIN_SENDING_RATE_KEY,"1");
        data.put(TopologyConstants.SENSORS_MIN_PROCESSING_RATE_KEY,"1");
        data.put(TopologyConstants.CHANNEL_MIN_SENDING_RATE_KEY,"1");
        HashMap<String ,String > energyRule = new HashMap<>();
        energyRule.put(EnergyConstants.PROCESSING_MESSAGE_ENERGY_CONSUMPTION_KEY , "5");
        energyRule.put(EnergyConstants.SENDING_MESSAGE_ENERGY_COMSUMPTION_KEY,"5");
        energyRule.put(EnergyConstants.RECEIVE_MESSAGE_ENERGY_COMSUMPTION_KEY,"5");

        data.put(TopologyConstants.ENERGY_RULES_LIST_KEY,energyRule);
    }
}
