package Converter.Coding.Program;

import Converter.Coding.Common.*;
import Converter.Sensor.BaseSensor;

public class GenerateProgram extends BaseProgram {

    private Variable buffer;
    
    private Variable energy;

    public GenerateProgram (String id, BaseSensor sensor) {
        this.buffer = sensor.buffer;
        this.id = id;
        this.energy = sensor.InitiaiEnergy;
    }

    @Override
    public String getCode() {
        Variable random = new Variable(BaseType.INT,
                "random",
                Function.createFunction("randomInt","1", CommonVariable.NUMBER_OF_PACkAGE));

        StringBuilder pro = new StringBuilder();
        pro.append(this.id).append(" ").append("{").append(System.lineSeparator());

        //Create random number of package
        pro.append(random.toString()).append(System.lineSeparator());

        //Compare number of package with random number
        pro.append(Condition.createIFCondition(
                Operator.Compare(CommonVariable.NUMBER_OF_PACkAGE,random.getVariableName(),">="),
                Operator.Minus(CommonVariable.NUMBER_OF_PACkAGE,CommonVariable.NUMBER_OF_PACkAGE,random.getVariableName())));
        pro.append(System.lineSeparator());

        //Else random package is larger than
        StringBuilder elseCommand = new StringBuilder();
        elseCommand.append(Operator.AssignValue(random.getVariableName(),CommonVariable.NUMBER_OF_PACkAGE)).append(System.lineSeparator());
        elseCommand.append(Operator.AssignValue(CommonVariable.NUMBER_OF_PACkAGE,"0")).append(System.lineSeparator());
        pro.append(Condition.createELSECondition(elseCommand.toString()));

        //Increase sensor buffer

        pro.append(Operator.Add(buffer.getVariableName(),
                buffer.getVariableName(),
                random.getVariableName())).append(System.lineSeparator());
        //Check congestion
        //pro.append(Condition.createIFCondition(
        //        Operator.Compare(buffer.getVariableName(),CommonVariable.SENSOR_MAX_BUFFER_SIZE,">"),
        //        Operator.AssignValue(CommonVariable.CONGESTION,"true")));
        //pro.append(System.lineSeparator());
        pro.append(Operator.Minus(energy.getVariableName(), energy.getVariableName(),Function.createFunction("randomFloat","0.2", "0.3")));
        pro.append(System.lineSeparator());
        //End of program
        pro.append("}").append(System.lineSeparator())
                .append(System.lineSeparator());
        

        
        return pro.toString();
    }
}
