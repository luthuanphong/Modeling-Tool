package Converter.Coding.Program;

import Converter.Channel.BaseChannel;
import Converter.Coding.Common.*;
import Converter.Sensor.BaseSensor;

public class ChannelReceiveProgram extends BaseProgram {

    private Variable channelBuffer;
    private Variable sensorQueue;

    public ChannelReceiveProgram (String id, BaseChannel channel, BaseSensor sensor) {
        this.channelBuffer = channel.buffer;
        this.sensorQueue = sensor.queue;
        this.id = id;
    }

    @Override
    public String getCode() {

        Variable random = new Variable(BaseType.INT,
                "random",
                Function.createFunction("randomInt",CommonVariable.CHANNEL_MIN_SENDING_RATE, CommonVariable.CHANNEL_MAX_SENDING_RATE));

        StringBuilder pro = new StringBuilder();
        pro.append(id).append(" ").append("{").append(System.lineSeparator());
        pro.append(random.toString()).append(System.lineSeparator());
        //Compare random and sensor queue
        pro.append(Condition.createIFCondition(
                Operator.Compare(sensorQueue.getVariableName(),random.getVariableName(),">="),
                Operator.Minus(sensorQueue.getVariableName(),sensorQueue.getVariableName(),random.getVariableName())));
        pro.append(System.lineSeparator());
        //else
        StringBuilder elseCommand = new StringBuilder();
        elseCommand.append(Operator.AssignValue(random.getVariableName(),sensorQueue.getVariableName()));
        elseCommand.append(System.lineSeparator());
        elseCommand.append(Operator.AssignValue(sensorQueue.getVariableName(),"0"));
        elseCommand.append(System.lineSeparator());

        pro.append(Condition.createELSECondition(elseCommand.toString()));
        //Add channel buffer
        pro.append(Operator.Add(channelBuffer.getVariableName(),channelBuffer.getVariableName(),random.getVariableName()));
        pro.append(System.lineSeparator());
        //Check congestion
        pro.append(Condition.createIFCondition(
                Operator.Compare(channelBuffer.getVariableName(),CommonVariable.CHANNEL_MAX_BUFFER_SIZE,">"),
                Operator.AssignValue(CommonVariable.CONGESTION,"true")));
        pro.append(System.lineSeparator());
        pro.append("}").append(System.lineSeparator())
                .append(System.lineSeparator());
        return pro.toString();
    }
}
