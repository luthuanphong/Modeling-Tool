package Converter.Sensor;

import Converter.Coding.Common.BaseType;
import Converter.Coding.Common.Variable;
import Kwsn.Sensor;
import Pnml.Pnml;
import Pnml.Arc;
import Pnml.ArcDirection;
import Pnml.Transition;
import Pnml.Place;

public class IntermediateSensor extends BaseSensor {

    public IntermediateSensor (Pnml pnml, Sensor sensor) {
        //Initialize all information
        this.pnml = pnml;
        this.sensor = sensor;
        this.buffer = new Variable(BaseType.INT,"Buffer_"+this.sensor.Id,"0");
        this.queue = new Variable(BaseType.INT,"Queue_"+this.sensor.Id,"0");
        this.Type = SensorType.INTERMEDIATE;
    }

    /**
     * Convert sensor to pnml data
     */
    @Override
    public void convertToPnml() {

        this.InputPlace = new Place();
        this.InputPlace.id = "int_in_"+this.sensor.Id;
        this.InputPlace.token = 0;
        this.InputPlace.label = "Int input place";

        this.OutputPlace = new Place();
        this.OutputPlace.id = "int_out_"+this.sensor.Id;
        this.OutputPlace.label = "Int ouput place";

        this.Send = new Transition();
        this.Send.id = "int_send_"+this.sensor.Id;
        this.Send.label = "Int send";


        Arc int_process = new Arc();
        int_process.id = "Int_in_"+this.sensor.Id;
        int_process.direction = ArcDirection.PLACE_TO_TRANSITION;
        int_process.place = this.InputPlace.id;
        int_process.transition = this.Send.id;
        int_process.weight = 1;

        Arc process_out = new Arc();
        process_out.id = "Int_out_"+this.sensor.Id;
        process_out.direction = ArcDirection.TRANSITION_TO_PLACE;
        process_out.place = this.OutputPlace.id;
        process_out.transition = this.Send.id;
        process_out.weight = 1;

        this.pnml.net.places.add(this.InputPlace);
        this.pnml.net.places.add(this.OutputPlace);

        this.pnml.net.transitions.add(this.Send);

        this.pnml.net.arcs.add(int_process);
        this.pnml.net.arcs.add(process_out);
    }
}