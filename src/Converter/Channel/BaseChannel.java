package Converter.Channel;

import Converter.Coding.Common.Variable;
import Converter.Sensor.BaseSensor;
import Pnml.Pnml;
import Pnml.Transition;
import Kwsn.Link;

import java.util.List;

public abstract class BaseChannel {
    /**
     *
     */
    public Variable buffer;

    /**
     *
     */
    public ChannelType Type;

    /**
     *
     */
    public Transition channelRecv;

    /**
     *
     */
    public Transition channelSend;

    /**
     *
     */
    public Link link;

    /**
     *
     */
    public List<Link> links;

    /**
     *
     */
    public BaseSensor sensorFrom;

    /**
     *
     */
    public List<BaseSensor> sensorTos;

    /**
     *
     */
    protected Pnml pnml;

    /**
     *
     */
    protected List<BaseSensor> sensors;

    /**
     *
     */
    public abstract void ConvertToPnml();

    /**
     *
     * @return
     */
    public abstract String getRecvCode ();

    /**
     *
     * @return
     */
    public abstract String getSendCode ();
}
