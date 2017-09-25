package Converter;

import Converter.Channel.BaseChannel;
import Converter.Channel.BroadcastChannel;
import Converter.Coding.Common.BaseType;
import Converter.Coding.Common.CommonVariable;
import Converter.Coding.Common.Variable;
import Converter.Coding.Program.*;
import Converter.Sensor.BaseSensor;
import Converter.Sensor.SensorFactory;
import Converter.Sensor.SensorType;
import Kwsn.Link;
import Kwsn.Sensor;
import Pnml.Pnml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BroadcastConverter extends Converter {

    private List<Variable> variables;

    private List<String> programs;

    public BroadcastConverter (HashMap<String,Object> data) {
        this.setTopologyData(data);
        variables = new ArrayList<>();
        variables.add(new Variable(BaseType.BOOLEAN, CommonVariable.CONGESTION,"false"));
        variables.add(new Variable(BaseType.INT, CommonVariable.SENSOR_MAX_BUFFER_SIZE, getSensorMaxBufferSize()));
        variables.add(new Variable(BaseType.INT, CommonVariable.SENSOR_MAX_QUEUE_SIZE, getSensorMaxQueueSize()));
        variables.add(new Variable(BaseType.INT, CommonVariable.SENSOR_MAX_PROCESSING_RATE, getSensorMaxProcessingRate()));
        variables.add(new Variable(BaseType.INT, CommonVariable.SENSOR_MAX_SENDING_RATE, getSensorMaxSendingRate()));
        variables.add(new Variable(BaseType.INT, CommonVariable.CHANNEL_MAX_BUFFER_SIZE, getChannelMaxBufferSize()));
        variables.add(new Variable(BaseType.INT, CommonVariable.CHANNEL_MAX_SENDING_RATE, getChannelMaxSendingRate()));
        variables.add(new Variable(BaseType.INT, CommonVariable.NUMBER_OF_PACkAGE, getNumberOfPackage()));
        variables.add(new Variable(BaseType.INT, CommonVariable.SENSOR_MIN_SENDING_RATE, getSensorMinSendingRate()));
        variables.add(new Variable(BaseType.INT, CommonVariable.SENSOR_MIN_PROCESSING_RATE, getSensorMinProcessingRate()));
        variables.add(new Variable(BaseType.INT, CommonVariable.CHANNEL_MIN_SENDING_RATE, getChannelMinSendingRate()));

        programs = new ArrayList<>();
        programs.add(MainProgram.getCode());
    }

    @Override
    public void outputPnmlFile(String folderPath) {
        SensorFactory sensorFactory =  new SensorFactory();
        List<Sensor> sensors = getListSensor();
        List<Link> links = getListChannel();
        List<BaseSensor> baseSensors = new ArrayList<>();
        Pnml pnml = new Pnml();

        if( sensors != null ){
            for ( int i = 0 ; i < sensors.size() ; i++) {
                BaseSensor sensor = sensorFactory.getSensor(pnml,sensors.get(i));
                sensor.convertToPnml();
                baseSensors.add(sensor);
                variables.add(sensor.buffer);
                variables.add(sensor.queue);
                if (sensor.Type == SensorType.SOURCE) {

                    BaseProgram genProgram = new GenerateProgram(sensor.Generate.id,sensor);
                    BaseProgram sendProgram = new SensorSendProgram(sensor.Send.id,sensor);
                    programs.add(genProgram.getCode());
                    programs.add(sendProgram.getCode());

                } else if (sensor.Type == SensorType.INTERMEDIATE) {

                    BaseProgram sendProgram = new SensorSendProgram(sensor.Send.id,sensor);
                    programs.add(sendProgram.getCode());

                } else if (sensor.Type == SensorType.SINk) {

                    BaseProgram processProgram = new ProcessProgram(sensor.Process.id,sensor);
                    programs.add(processProgram.getCode());

                }
            }
        }

        if ( links != null ) {
            for ( int i = 0 ; i < links.size() ; i++) {
                if (!links.get(i).IsConverted) {
                    BaseChannel channel = new BroadcastChannel(links, links.get(i), pnml, baseSensors);
                    channel.ConvertToPnml();
                    variables.add(channel.buffer);
                    programs.add(channel.getRecvCode());
                    programs.add(channel.getSendCode());
                }
            }
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Pnml.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(pnml,new File(folderPath+"temp.pnml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void outputProcessFile(String folderPath) {

        try {
            FileWriter writer = new FileWriter(folderPath+"temp.txt");
            for (Variable v : variables) {
                writer.write(v.toString());
                writer.write(System.lineSeparator());
            }
            for (String s : programs) {
                writer.write(s);
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void outputMinimizeProcessFile(String folderPath) {
        try {
            FileWriter writer = new FileWriter(folderPath+"temp_minize.txt");
            for (Variable v : variables) {
                writer.write(v.toMinimizeString());
                writer.write(System.lineSeparator());
            }
            for (String s : programs) {
                writer.write(s);
                writer.write(System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
