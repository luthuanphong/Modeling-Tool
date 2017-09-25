package Converter.Coding.Program;

import Converter.Channel.BaseChannel;
import Converter.Coding.Common.*;

import java.util.List;

public class ChannelSendProgram extends BaseProgram {

    private Variable channelBuffer;
    private List<Variable> sensorBuffer;

    public ChannelSendProgram (String id, BaseChannel channel, List<Variable> sensorBuffer) {
        this.channelBuffer = channel.buffer;
        this.sensorBuffer = sensorBuffer;
        this.id = id;
    }

    @Override
    public String getCode() {

        Variable random  =  new Variable(BaseType.INT,
                "random" ,
                Function.createFunction("randomInt",CommonVariable.CHANNEL_MIN_SENDING_RATE, CommonVariable.CHANNEL_MAX_SENDING_RATE));

        StringBuilder pro = new StringBuilder();
        pro.append(id).append(" ").append("{").append(System.lineSeparator());
        pro.append(random.toString()).append(System.lineSeparator());
        //Decrease channel buffer
        //if channel buffer larger than random number
        pro.append(Condition.createIFCondition(
                Operator.Compare(channelBuffer.getVariableName(),random.getVariableName(),">="),
                Operator.Minus(channelBuffer.getVariableName(),channelBuffer.getVariableName(),random.getVariableName())));
        pro.append(System.lineSeparator());
        //else
        StringBuilder elseCommand = new StringBuilder();
        elseCommand.append(Operator.AssignValue(random.getVariableName(),channelBuffer.getVariableName()));
        elseCommand.append(System.lineSeparator());
        elseCommand.append(Operator.AssignValue(channelBuffer.getVariableName(),"0"));
        elseCommand.append(System.lineSeparator());
        pro.append(Condition.createELSECondition(elseCommand.toString()));

        //Increase sensor buffer
        for(Variable v : sensorBuffer) {

            pro.append(Operator.Add(v.getVariableName(),v.getVariableName(),random.getVariableName()));
            pro.append(System.lineSeparator());
            //Check condition
            pro.append(Condition.createIFCondition(
                    Operator.Compare(v.getVariableName(),CommonVariable.SENSOR_MAX_BUFFER_SIZE,">"),
                    Operator.AssignValue(CommonVariable.CONGESTION,"true")));
            pro.append(System.lineSeparator());
        }
        pro.append("}").append(System.lineSeparator())
                .append(System.lineSeparator());
        return pro.toString();
    }
}
