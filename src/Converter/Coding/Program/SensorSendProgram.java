package Converter.Coding.Program;

import Converter.Coding.Common.*;
import Converter.Sensor.BaseSensor;
import Converter.Sensor.SensorType;

public class SensorSendProgram extends BaseProgram {

    private Variable buffer;

    private Variable queue;
    
    private Variable energy;

    private SensorType type;

    public SensorSendProgram(String id, BaseSensor sensor) {
        this.buffer = sensor.buffer;
        this.queue = sensor.queue;
        this.energy = sensor.InitiaiEnergy;
        this.id = id;
        this.type = sensor.Type;
    }

    @Override
    public String getCode() {
        Variable random = new Variable(BaseType.INT,
                "random",
                Function.createFunction("randomInt",CommonVariable.SENSOR_MIN_SENDING_RATE, CommonVariable.SENSOR_MAX_SENDING_RATE));

        StringBuilder pro = new StringBuilder();
        pro.append(this.id).append(" ").append("{").append(System.lineSeparator());
        //Create random variable
        pro.append(random.toString()).append(System.lineSeparator());

        //Check random
        pro.append(Condition.createIFCondition(
                Operator.Compare(buffer.getVariableName(),random.getVariableName(),">="),
                Operator.Minus(buffer.getVariableName(),buffer.getVariableName(),random.getVariableName())));
        pro.append(System.lineSeparator());
        //else
        StringBuilder elseCommand = new StringBuilder();
        elseCommand.append(Operator.AssignValue(random.getVariableName(),buffer.getVariableName()));
        elseCommand.append(System.lineSeparator());
        elseCommand.append(Operator.AssignValue(buffer.getVariableName(),"0"));
        elseCommand.append(System.lineSeparator());
        pro.append(Condition.createELSECondition(elseCommand.toString()));
        //Increase queue
        pro.append(Operator.Add(queue.getVariableName(),queue.getVariableName(),random.getVariableName()));
        pro.append(System.lineSeparator());
        //Check congestion
        if(this.type == SensorType.INTERMEDIATE) {

            pro.append(Condition.createIFCondition(
                    Operator.Compare(queue.getVariableName(), CommonVariable.SENSOR_MAX_QUEUE_SIZE, ">"),
                    Operator.AssignValue(CommonVariable.CONGESTION, "true")));
            pro.append(System.lineSeparator());

        }
        pro.append(Operator.Minus(energy.getVariableName(), energy.getVariableName(),Function.createFunction("randomFloat","0.1", "0.2")));
        pro.append(System.lineSeparator());
        pro.append("}").append(System.lineSeparator())
                .append(System.lineSeparator());
        

        return pro.toString();
    }
}
