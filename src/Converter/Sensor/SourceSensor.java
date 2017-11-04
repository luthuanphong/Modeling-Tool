package Converter.Sensor;

import Converter.Coding.Common.BaseType;
import Converter.Coding.Common.Variable;
import Kwsn.Sensor;
import Pnml.Pnml;
import Pnml.Place;
import Pnml.Transition;
import Pnml.Arc;
import Pnml.ArcDirection;

public class SourceSensor extends BaseSensor {

    public SourceSensor (Pnml pnml, Sensor sensor) {
        //Initialize all information
        this.pnml = pnml;
        this.sensor = sensor;
        this.sensor.pnmlSensor = this;
        this.buffer = new Variable(BaseType.INT,"Buffer_"+this.sensor.Id,"0");
        this.queue = new Variable(BaseType.INT,"Queue_"+this.sensor.Id,"0");
        this.Type = SensorType.SOURCE;
        this.Token = sensor.token;
        this.InitiaiEnergy = new Variable(BaseType.FLOAT, "energy_"+this.sensor.Id, sensor.energy+"");
    }
    
    /**
     * 
     * @param token
     * @return
     */
    private int parseToken(String token) {
    	try {
    		return Integer.parseInt(token);
    	} catch(Exception e) {
    		return 1;
    	}
    }
    
    /**
     * Convert sensor data to pnml
     */
    @Override
    public void convertToPnml() {

        this.InputPlace = new Place();
        this.InputPlace.id = "src_in_"+this.sensor.Id;
        this.InputPlace.token = this.parseToken(this.Token);
        this.InputPlace.label = "Source input place";

        this.IntermediatePlace = new Place();
        this.IntermediatePlace.id = "src_int_"+this.sensor.Id;
        this.IntermediatePlace.label = "Source intermediate place";

        this.OutputPlace = new Place();
        this.OutputPlace.id = "src_out_"+this.sensor.Id;
        this.OutputPlace.label = "Source ouput place";

        this.Generate = new Transition();
        this.Generate.id = "source_gen";
        this.Generate.label = "Source generate";

        this.Send = new Transition();
        this.Send.id = "source_send";
        this.Send.label = "Source send";

        Arc input_generate = new Arc();
        input_generate.id = "src_gen_place_to_transition";
        input_generate.direction = ArcDirection.PLACE_TO_TRANSITION;
        input_generate.place = this.InputPlace.id;
        input_generate.transition = this.Generate.id;
        input_generate.weight = 1;

        Arc generate_int = new Arc();
        generate_int.id = "gen_int_transition_to_place";
        generate_int.direction = ArcDirection.TRANSITION_TO_PLACE;
        generate_int.place = this.IntermediatePlace.id;
        generate_int.transition = this.Generate.id;
        generate_int.weight = 1;

        Arc int_send = new Arc();
        int_send.id = "int_send_place_to_transition";
        int_send.direction = ArcDirection.PLACE_TO_TRANSITION;
        int_send.place = this.IntermediatePlace.id;
        int_send.transition = Send.id;
        int_send.weight = 1;

        Arc send_out = new Arc();
        send_out.id = "send_out_transition_to_place";
        send_out.direction = ArcDirection.TRANSITION_TO_PLACE;
        send_out.place = this.OutputPlace.id;
        send_out.transition = Send.id;
        send_out.weight = 1;

        this.pnml.net.places.add(this.InputPlace);
        this.pnml.net.places.add(this.IntermediatePlace);
        this.pnml.net.places.add(this.OutputPlace);

        this.pnml.net.transitions.add(this.Generate);
        this.pnml.net.transitions.add(this.Send);

        this.pnml.net.arcs.add(input_generate);
        this.pnml.net.arcs.add(generate_int);
        this.pnml.net.arcs.add(int_send);
        this.pnml.net.arcs.add(send_out);
    }
}
