package Converter.Channel;

import Converter.Coding.Common.BaseType;
import Converter.Coding.Common.Variable;
import Converter.Coding.Program.BaseProgram;
import Converter.Coding.Program.ChannelReceiveProgram;
import Converter.Coding.Program.ChannelSendProgram;
import Converter.Sensor.BaseSensor;
import Kwsn.Link;
import Pnml.Pnml;
import Pnml.Place;
import Pnml.Transition;
import Pnml.Arc;
import Pnml.ArcDirection;

import java.util.ArrayList;
import java.util.List;

public class BroadcastChannel extends BaseChannel {

    private List<Variable> sensorBuffer;

    public BroadcastChannel (List<Link> links ,Link link, Pnml pnml, List<BaseSensor> sensors) {
        this.links = links;
        this.link = link;
        this.pnml = pnml;
        this.sensors = sensors;
        this.buffer = new Variable(BaseType.INT,"Channel_Buffer_"+this.link.id,"0");
        this.sensorTos = new ArrayList<>();
        this.sensorBuffer = new ArrayList<>();
        this.Type = ChannelType.BROADCAST;
    }

    @Override
    public void ConvertToPnml() {

        Place channelIntermediate = new Place();
        channelIntermediate.id = "Channel_Int_"+this.link.id;
        channelIntermediate.label = "Channel intermediate "+this.link.id;

        this.channelRecv = new Transition();
        this.channelRecv.label = "Channel receive "+this.link.id;
        this.channelRecv.id = "Channel_recv_"+this.link.id;

        this.channelSend = new Transition();
        this.channelSend.label = "Channel send "+this.link.id;
        this.channelSend.id = "Channel_send_"+this.link.id;

        Arc recv_in = new Arc();
        recv_in.weight = 1;
        recv_in.direction = ArcDirection.PLACE_TO_TRANSITION;
        recv_in.id = "Channel_recv_in_"+this.link.id;
        recv_in.place = GetSensorFromId();
        recv_in.transition = this.channelRecv.id;

        Arc recv_out = new Arc();
        recv_out.weight = 1;
        recv_out.direction = ArcDirection.TRANSITION_TO_PLACE;
        recv_out.id = "Channel_recv_out_"+this.link.id;
        recv_out.place = channelIntermediate.id;
        recv_out.transition = this.channelRecv.id;

        Arc send_in = new Arc();
        send_in.weight = 1;
        send_in.direction = ArcDirection.PLACE_TO_TRANSITION;
        send_in.id = "Channel_send_in_"+this.link.id;
        send_in.place = channelIntermediate.id;
        send_in.transition = this.channelSend.id;

        int count = 0;

        for (int i = 0 ; i < links.size() ; i++ ) {
            if (links.get(i).From.equals(this.link.From)) {
                count += 1;
                Arc out = new Arc();
                out.weight = 1;
                out.direction = ArcDirection.TRANSITION_TO_PLACE;
                out.id = "Channel_send_out_"+this.link.id+"_"+count;
                out.place = GetSensorToId(links.get(i).To);
                out.transition = this.channelSend.id;
                links.get(i).IsConverted = true;
                this.pnml.net.arcs.add(out);
            }
        }

        this.pnml.net.places.add(channelIntermediate);
        this.pnml.net.transitions.add(this.channelRecv);
        this.pnml.net.transitions.add(this.channelSend);
        this.pnml.net.arcs.add(recv_in);
        this.pnml.net.arcs.add(recv_out);
        this.pnml.net.arcs.add(send_in);
    }

    @Override
    public String getRecvCode() {
        BaseProgram program = new ChannelReceiveProgram(this.channelRecv.id, this, GetSensorFrom());
        return program.getCode();
    }

    @Override
    public String getSendCode() {

        BaseProgram program = new ChannelSendProgram(this.channelSend.id, this, this.sensorBuffer);
        return program.getCode();
    }

    /**
     *
     * @return
     */
    public BaseSensor GetSensorFrom () {
        if (this.sensors != null) {
            for (int i = 0 ; i < this.sensors.size() ; i++) {
                if(sensors.get(i).getSensorName().equals(this.link.From)) {
                    this.sensorFrom = sensors.get(i);
                    return sensors.get(i);
                }
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public String GetSensorFromId () {
        if (this.sensors != null) {
            for (int i = 0 ; i < this.sensors.size() ; i++) {
                if(sensors.get(i).getSensorName().equals(this.link.From)) {
                    this.sensorFrom = sensors.get(i);
                    return sensors.get(i).OutputPlace.id;
                }
            }
        }
        return null;
    }


    /**
     *
     * @return
     */
    public String GetSensorToId (String to) {
        if (this.sensors != null) {
            for (int i = 0 ; i < this.sensors.size() ; i++) {
                if(sensors.get(i).getSensorName().equals(to)) {
                    this.sensorTos.add(sensors.get(i));
                    this.sensorBuffer.add(sensors.get(i).buffer);
                    return sensors.get(i).InputPlace.id;
                }
            }
        }
        return null;
    }
}
