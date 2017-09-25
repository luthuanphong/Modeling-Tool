package Converter.Coding.Program;

import Converter.Coding.Common.*;
import Converter.Sensor.BaseSensor;

public class ProcessProgram extends BaseProgram {

    private Variable buffer;
    private Variable queue;

    public ProcessProgram (String id, BaseSensor sensor) {
        this.buffer = sensor.buffer;
        this.queue = sensor.queue;
        this.id = id;
    }

    @Override
    public String getCode() {
        Variable random = new Variable(BaseType.INT,
                "random",
                Function.createFunction("randomInt",CommonVariable.SENSOR_MIN_PROCESSING_RATE, CommonVariable.SENSOR_MAX_PROCESSING_RATE));

        StringBuilder pro = new StringBuilder();
        pro.append(this.id).append(" ").append("{").append(System.lineSeparator());
        pro.append(random.toString()).append(System.lineSeparator());
        //Check condition
        pro.append(Condition.createIFCondition(
                Operator.Compare(buffer.getVariableName(),random.getVariableName(),">="),
                Operator.Minus(buffer.getVariableName(),buffer.getVariableName(),random.getVariableName())));
        pro.append(System.lineSeparator());
        //Else
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
        //pro.append(Condition.createIFCondition(
        //        Operator.Compare(queue.getVariableName(),CommonVariable.SENSOR_MAX_QUEUE_SIZE,">"),
        //        Operator.AssignValue(CommonVariable.CONGESTION,"true")));
        //pro.append(System.lineSeparator());
        pro.append("}").append(System.lineSeparator())
                .append(System.lineSeparator());
        return pro.toString();
    }
}
